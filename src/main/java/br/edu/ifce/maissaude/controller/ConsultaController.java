package br.edu.ifce.maissaude.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifce.maissaude.model.Consulta;
import br.edu.ifce.maissaude.repository.ConsultaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    // LISTAR TODAS
    @GetMapping
    public List<Consulta> listar() {
        return consultaRepository.findAll();
    }

    // ADICIONAR CONSULTA
    @PostMapping
    public Consulta adicionar(@RequestBody Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    // ATUALIZAR CONSULTA
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable long id, @RequestBody Consulta consulta) {
        Optional<Consulta> existente = consultaRepository.findById(id);

        if (!existente.isPresent()) {
            return ResponseEntity.status(404).body("Consulta não encontrada.");
        }

        consulta.setIdconsulta(id);
        return ResponseEntity.ok(consultaRepository.save(consulta));
    }

    // DELETAR CONSULTA
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id) {
        Optional<Consulta> existente = consultaRepository.findById(id);

        if (!existente.isPresent()) {
            return ResponseEntity.status(404).body("Consulta não encontrada.");
        }

        consultaRepository.deleteById(id);
        return ResponseEntity.ok("Consulta deletada com sucesso!");
    }
}
