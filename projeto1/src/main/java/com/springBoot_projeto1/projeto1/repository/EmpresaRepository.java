package com.springBoot_projeto1.projeto1.repository;

import com.springBoot_projeto1.projeto1.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Long> {
}
