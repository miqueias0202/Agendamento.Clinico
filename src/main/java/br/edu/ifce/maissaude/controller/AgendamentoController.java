package br.edu.ifce.maissaude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
         if(lista.isEmpty()){
            return Agendamento.status(204).body("Nenhum agendamento encontrado.");
        }

        return Agendamento.ok(lista);
    }
    @PostMapping
    public  Agendamento adicionar(@RequestBody Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
        if (agendamento.getUsuario() == null) {
            return Agendamento.badRequest().body("É obrigatório informar o paciente (usuário).");
        }

        if (agendamento.getMedico() == null) {
            return Agendamento.badRequest().body("É obrigatório informar o médico.");
        }

        if (agendamento.getData() == null) {
            return Agendamento.badRequest().body("A data da consulta é obrigatória.");
        }

        if (agendamento.getHorario() == null) {
            return Agendamento.badRequest().body("O horário da consulta é obrigatório.");
        }
         Optional<Agendamento> existente = agendamentoRepository
                .findByMedicoIdmedicoAndDataAndHorario(
                        agendamento.getMedico().getIdmedico(),
                        agendamento.getData(),
                        agendamento.getHorario()
                );
                 if (existente.isPresent()) {
            return ResponseEntity.status(409)
            .body("O médico já possui uma consulta marcada neste dia e horário.");
        }

        Agendamento salvo = agendamentoRepository.save(agendamento);

        return Agendamento.ok(salvo);
    }


}
