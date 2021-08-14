package com.springBoot_projeto1.projeto1.service;

import com.springBoot_projeto1.projeto1.model.BancoHoras;
import com.springBoot_projeto1.projeto1.model.JornadaTrabalho;
import com.springBoot_projeto1.projeto1.repository.BancoHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoHorasService {

    BancoHorasRepository bancoHorasRepository;

    @Autowired
    public BancoHorasService(BancoHorasRepository bancoHorasRepository) {
        this.bancoHorasRepository = bancoHorasRepository;
    }

    public BancoHoras saveBancoHoras(BancoHoras bancoHoras) {
        return bancoHorasRepository.save(bancoHoras);
    }

    public List<BancoHoras> findAll() {
        return bancoHorasRepository.findAll();
    }

    public Optional<BancoHoras> getById(Long idBancohoras) {
        return  bancoHorasRepository.findById(idBancohoras);
    }

    public BancoHoras updateBancoHoras(BancoHoras bancoHoras) {
        return bancoHorasRepository.save(bancoHoras);
    }

    public void deleteBancoHoras(Long idBancohoras) {
        bancoHorasRepository.deleteById(idBancohoras);
    }
}
