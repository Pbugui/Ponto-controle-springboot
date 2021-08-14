package com.springBoot_projeto1.projeto1.controller;

import com.springBoot_projeto1.projeto1.model.BancoHoras;
import com.springBoot_projeto1.projeto1.model.JornadaTrabalho;
import com.springBoot_projeto1.projeto1.service.BancoHorasService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/bancoHoras")
@Api(value="API REST bancoHoras")
@CrossOrigin(origins="*")
public class BancoHorasController {

    @Autowired
    BancoHorasService bancoHorasService;

    @PostMapping
    @ApiOperation(value="Insere um tipo de banco horas")
    public BancoHoras createBancoHoras(@RequestBody BancoHoras bancoHoras) {
        return bancoHorasService.saveBancoHoras(bancoHoras);

    }

    @GetMapping("/list")
    @ApiOperation(value="Lista todas as banco horas")
    public List<BancoHoras> getBancoHorasList() {
        return bancoHorasService.findAll();

    }

    @GetMapping("/{idBancohoras}")
    @ApiOperation(value="Lista a banco horas selecionada pelo id")
    public ResponseEntity<BancoHoras> getBancoHorasByID(@PathVariable("idBancohoras") Long idBancohoras) throws Exception {
        return  ResponseEntity.ok(bancoHorasService.getById(idBancohoras).orElseThrow(() -> new NoSuchElementException("Not found!" + HttpStatus.NOT_FOUND)));

    }

    @PutMapping
    @ApiOperation(value="Atualiza uma banco horas")
    public BancoHoras updateBancoHoras(@RequestBody BancoHoras bancoHoras){
        return bancoHorasService.updateBancoHoras(bancoHoras);
    }

    @DeleteMapping("/{idBancohoras}")
    @ApiOperation(value="Deleta a banco horas selecionada pelo id")
    public ResponseEntity deleteByID(@PathVariable("idBancohoras") Long idBancohoras) throws Exception {
        try {
            bancoHorasService.deleteBancoHoras(idBancohoras);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<BancoHoras>) ResponseEntity.ok();

    }
}
