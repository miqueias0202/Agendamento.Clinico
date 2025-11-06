package br.edu.ifce.maissaude.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Consulta {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idconsulta;
    private Long idagendamento;

    private String statusconsulta;
    
}
