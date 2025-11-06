package br.edu.ifce.maissaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifce.maissaude.model.Consulta;
@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
    
}
