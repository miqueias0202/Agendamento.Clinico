package br.edu.ifce.maissaude.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifce.maissaude.model.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    Optional<Agendamento> findByMedicoIdmedicoAndDataAndHorario(
            Long idmedico,
            Date data,
            Time horario
    );
}

