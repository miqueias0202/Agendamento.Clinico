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
    public Consulta postsolicitar(@RequestBody Consulta consulta) {
        consulta.setStatusconsulta("SOLICITADA");
        return consultaRepository.save(consulta);
    }
    @PostMapping("/api/cancelar")
    public String postCancelarConsultas(PathVariable Long id){
        if (!consultaRepository.existeById(id)) {
            return "Consulta não encontrada.";
    }   consultaRepository.deleteById(id);
        return "Consulta cancelada com sucesso.";
    }
    @PostMapping("/api/confirmar")
    public Consulta postConfirmaConsultar(@PathVariable long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        consulta.setStatusconsulta("CONFIRMADA");
        return consultaRepository.save(consulta);
    }

    @PostMapping("/api/recusar")
    public Consulta postRecusarConsulta(@PathVariable long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        consulta.setStatusconsulta("RECUSADA");
        return consultaRepository.save(consulta);
}
    @GetMapping
    public  List<Consulta> listaConsultasr() {
        return consultaRepository.findAll();
    }
    @PutMapping("/{id}")
    public Consulta atualizarConsulta(@PathVariable long id, @RequestBody Consulta consulta) {
        consulta.setIdconsulta(id);
        return consultaRepository.save(consulta);
        
    
    
    
}
}
