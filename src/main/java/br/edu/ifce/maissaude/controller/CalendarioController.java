package br.edu.ifce.maissaude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifce.maissaude.model.Calendario;
import br.edu.ifce.maissaude.repository.CalendarioRepository;
@RestController
@RequestMapping("/api/calendario")
public class CalendarioController {
    @Autowired
    private CalendarioRepository calendarioRepository;

    @GetMapping
    public List<Calendario> listar() {
        return calendarioRepository.findAll();
    }

    @PostMapping
    public Calendario adicionar(@RequestBody Calendario calendario) {
        return calendarioRepository.save(calendario);
    }
}
