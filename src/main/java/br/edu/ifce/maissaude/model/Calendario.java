package br.edu.ifce.maissaude.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Calendario {
    @Id
    private Long id;

    private  String data;
    private  String hora;
    
}
