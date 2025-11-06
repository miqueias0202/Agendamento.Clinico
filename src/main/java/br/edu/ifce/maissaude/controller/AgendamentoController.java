package br.edu.ifce.maissaude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifce.maissaude.model.Agendamento;
import br.edu.ifce.maissaude.repository.AgendamentoRepository;

@RestController
@RequestMapping("/api/agendamento")
public class AgendamentoController {
    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @GetMapping
    public List<Agendamento> listar( ) {
        return agendamentoRepository.findAll();
    }
    @PostMapping
    public  Agendamento adicionar(@RequestBody Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }


}
