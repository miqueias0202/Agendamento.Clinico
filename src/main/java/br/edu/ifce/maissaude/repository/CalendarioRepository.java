package br.edu.ifce.maissaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifce.maissaude.model.Calendario;
@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, Long>{
    
}
