package com.springBoot_projeto1.projeto1.repository;

import com.springBoot_projeto1.projeto1.model.JornadaTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JornadaRepository  extends JpaRepository<JornadaTrabalho, Long> {
}
