package br.edu.ifce.maissaude.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifce.maissaude.model.Consulta;
import br.edu.ifce.maissaude.repository.ConsultaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {
    @Autowired ConsultaRepository consultaRepository;
    @PostMapping("/api/solicitar")
    public String postsolicitar() {
        return null;
    }
    @PostMapping("/api/cancelar")
    public String postCancelarConsultas() {
        return null;
    }
    @PostMapping("/api/confirmar")
    public String postConfirmar() {
        return null;
    }
    @PostMapping("/api/recusar")
    public String postRecusar() {
        return null;
    }
    @GetMapping
    public  List<Consulta> listar() {
        return consultaRepository.findAll();
    }
    @PutMapping("/{id}")
    public Consulta atualizar(@PathVariable long id, @RequestBody Consulta consulta){
        return consultaRepository.save(consulta);
    }
    
    
    
}
