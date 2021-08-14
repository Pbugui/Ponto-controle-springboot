package com.springBoot_projeto1.projeto1.repository;

import com.springBoot_projeto1.projeto1.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia,Long> {
}
