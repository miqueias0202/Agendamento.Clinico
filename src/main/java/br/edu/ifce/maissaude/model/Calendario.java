package br.edu.ifce.maissaude.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Calendario {
    @Id
    private Long idcalendario;

    private Date data;
    private  Time hora;
    
}
