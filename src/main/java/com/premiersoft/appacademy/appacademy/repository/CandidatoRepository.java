package com.premiersoft.appacademy.appacademy.repository;

import com.premiersoft.appacademy.appacademy.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long>{

    List<Candidato> findAllByVaga(String vaga);

}
