package br.edu.ifce.maissaude.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ifce.maissaude.model.Usuario;
import br.edu.ifce.maissaude.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // ---------- LISTAR ----------
    @GetMapping
    public ResponseEntity<?> listar() {

        List<Usuario> lista = usuarioRepository.findAll();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    // ---------- ADICIONAR ----------
    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody Usuario usuario) {

        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            return ResponseEntity.badRequest()
                    .body("Nome é obrigatório.");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            return ResponseEntity.badRequest()
                    .body("Email é obrigatório.");
        }

        // Verifica duplicidade por email
        Optional<Usuario> existente = usuarioRepository.findAll()
                .stream()
                .filter(u -> u.getEmail().equals(usuario.getEmail()))
                .findFirst();

        if (existente.isPresent()) {
            return ResponseEntity.status(409)
                    .body("Usuário já cadastrado com este e-mail.");
        }

        Usuario salvo = usuarioRepository.save(usuario);

        return ResponseEntity.ok(salvo);
    }

    // ---------- ATUALIZAR ----------
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {

        Optional<Usuario> existente = usuarioRepository.findById(id);

        if (!existente.isPresent()) {
            return ResponseEntity.status(404)
                    .body("Usuário não encontrado.");
        }

        Usuario atual = existente.get();

        if (usuario.getNome() != null)
            atual.setNome(usuario.getNome());

        if (usuario.getEmail() != null)
            atual.setEmail(usuario.getEmail());

        if (usuario.getSenha() != null)
            atual.setSenha(usuario.getSenha());

        if (usuario.getCpf() != null)
            atual.setCpf(usuario.getCpf());

        if (usuario.getTelefone() != null)
            atual.setTelefone(usuario.getTelefone());

        atual.setEpaciente(usuario.isEpaciente());

        Usuario atualizado = usuarioRepository.save(atual);

        return ResponseEntity.ok(atualizado);
    }

    // ---------- DELETAR ----------
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {

        Optional<Usuario> existente = usuarioRepository.findById(id);

        if (!existente.isPresent()) {
            return ResponseEntity.status(404)
                    .body("Usuário não encontrado.");
        }

        usuarioRepository.deleteById(id);

        return ResponseEntity.ok("Usuário com ID " + id + " foi deletado com sucesso.");
    }
}
