package com.springBoot_projeto1.projeto1.service;

import com.springBoot_projeto1.projeto1.model.Movimentacao;
import com.springBoot_projeto1.projeto1.repository.MovimentacaoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    MovimentacaoRespository movimentacaoRespository;

    @Autowired
    public MovimentacaoService(MovimentacaoRespository movimentacaoRespository) {
        this.movimentacaoRespository = movimentacaoRespository;
    }

    public Movimentacao saveMovimentacao(Movimentacao movimentacao) {
        return movimentacaoRespository.save(movimentacao);
    }

    public List<Movimentacao> findAll() {
        return movimentacaoRespository.findAll();
    }

    public Optional<Movimentacao> getById(Long idMovimentacao) {
        return movimentacaoRespository.findById(idMovimentacao);
    }

    public Movimentacao updateMovimentacao(Movimentacao movimentacao) {
        return movimentacaoRespository.save(movimentacao);
    }

    public void deleteMovimentacao(Long idMovimentacao) {
        movimentacaoRespository.deleteById(idMovimentacao);
    }
}
