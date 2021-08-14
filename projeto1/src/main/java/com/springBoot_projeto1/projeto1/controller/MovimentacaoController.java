package com.springBoot_projeto1.projeto1.controller;

import com.springBoot_projeto1.projeto1.model.JornadaTrabalho;
import com.springBoot_projeto1.projeto1.model.Movimentacao;
import com.springBoot_projeto1.projeto1.service.MovimentacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/movimentacao")
@Api(value="API REST Movimentacao")
@CrossOrigin(origins="*")
public class MovimentacaoController {

    @Autowired
    MovimentacaoService movimentacaoService;

    @PostMapping
    @ApiOperation(value="Insere um tipo de movimentacao")
    public Movimentacao createMovimentacao(@RequestBody Movimentacao movimentacao) {
        return movimentacaoService.saveMovimentacao(movimentacao);

    }

    @GetMapping("/list")
    @ApiOperation(value="Lista todas as movimentacao")
    public List<Movimentacao> getJornadaList() {
        return movimentacaoService.findAll();

    }

    @GetMapping("/{idJornada}")
    @ApiOperation(value="Lista a movimentacao selecionada pelo id")
    public ResponseEntity<Movimentacao> getJornadaByID(@PathVariable("idMovimentacao") Long idMovimentacao) throws Exception {
        return  ResponseEntity.ok(movimentacaoService.getById(idMovimentacao).orElseThrow(() -> new NoSuchElementException("Not found!" + HttpStatus.NOT_FOUND)));

    }

    @PutMapping
    @ApiOperation(value="Atualiza uma movimentacao")
    public Movimentacao updateMovimentacao(@RequestBody Movimentacao movimentacao){
        return movimentacaoService.updateMovimentacao(movimentacao);
    }

    @DeleteMapping("/{idMovimentacao}")
    @ApiOperation(value="Deleta a movimentacao selecionada pelo id")
    public ResponseEntity deleteByID(@PathVariable("idMovimentacao") Long idMovimentacao) throws Exception {
        try {
            movimentacaoService.deleteMovimentacao(idMovimentacao);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Movimentacao>) ResponseEntity.ok();

    }
}
