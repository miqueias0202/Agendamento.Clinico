package br.edu.ifce.maissaude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifce.maissaude.model.Medico;
import br.edu.ifce.maissaude.repository.MedicoRepository;


public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;
    @GetMapping
    public List<Medico> listar(){
        return medicoRepository.findAll();
    }
    
}
