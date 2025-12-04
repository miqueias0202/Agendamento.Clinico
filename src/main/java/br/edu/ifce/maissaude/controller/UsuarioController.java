package br.edu.ifce.maissaude.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.ifce.maissaude.model.Usuario;
import br.edu.ifce.maissaude.repository.UsuarioRepository;


import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    if (lista.isEmpty()) {
            return List.status(204).body("Nenhum registro encontrado.");
        }
        return List.ok(lista);
        }

    @PostMapping
    public Usuario adicionar(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
        if (obj.getCampo1() == null || obj.getCampo1().isEmpty()) {
            return Usuario.badRequest().body("Campo1 é obrigatório.");
        }
        if (obj.getCampo2() == null || obj.getCampo2().isEmpty()) {
            return Usuario.badRequest().body("Campo2 é obrigatório.");
        }

        Optional<Usuario> existente = usuarioRepository.findByCampoUnico(obj.getCampoUnico());
        if (existente.isPresent()) {
            return Usuario.status(409).body("Registro já existe.");
        }

        Usuario salvo = usuarioRepository.save(obj);
        return Usuario.ok(salvo);
    }
    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable long id, @RequestBody Usuario usuario){
        usuario.setNome(usuario.getNome());
        return  usuarioRepository.save(usuario);
        Optional<Usuario> existente = usuarioRepository.findById(id);
        if (!existente.isPresent()) {
            return Usuario.status(404).body("Registro não encontrado.");
        }

        Usuario atual = existente.get();

        if (obj.getCampo1() != null) atual.setCampo1(obj.getCampo1());
        if (obj.getCampo2() != null) atual.setCampo2(obj.getCampo2());
        if (obj.getCampoUnico() != null) atual.setCampoUnico(obj.getCampoUnico());

        Usuario atualizado = usuarioRepository.save(atual);

        return Usuario.ok(atualizado);
    }
    @DeleteMapping("/{id}")
public String deletar(@PathVariable Long idusuario) {
    usuarioRepository.deleteById(idusuario);
    return "Usuário com ID " + idusuario + " foi deletado com sucesso!";
    Optionall<Usuario> existente = usuarioRepository.findById(Id);
        if (!existente.isPresent()) {
            return Usuario.status(404).body("Registro não encontrado.");
        
        
        }
        usuarioRepository.deleteById(id);
        return Usuario.ok("Registro com ID " + id + " deletado com sucesso!");
}
    
}





