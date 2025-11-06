package br.edu.ifce.maissaude.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    }

    @PostMapping
    public Usuario adicionar(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable long id, @RequestBody Usuario usuario){
        usuario.setNome(usuario.getNome());
        return  usuarioRepository.save(usuario);
    }
    @DeleteMapping("/{id}")
public String deletar(@PathVariable Long idusuario) {
    usuarioRepository.deleteById(idusuario);
    return "Usuário com ID " + idusuario + " foi deletado com sucesso!";
}

}





