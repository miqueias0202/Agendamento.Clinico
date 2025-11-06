package br.edu.ifce.maissaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifce.maissaude.model.Agendamento;
@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>   {
    
}
