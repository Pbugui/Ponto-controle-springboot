package com.springBoot_projeto1.projeto1.repository;

import com.springBoot_projeto1.projeto1.model.TipoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDataRepository extends JpaRepository<TipoData,Long> {
}
