package com.springBoot_projeto1.projeto1.controller;

import com.springBoot_projeto1.projeto1.model.Calendario;
import com.springBoot_projeto1.projeto1.model.JornadaTrabalho;
import com.springBoot_projeto1.projeto1.service.CalendarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/calendario")
@Api(value="API REST Calendario")
@CrossOrigin(origins="*")
public class CalendarioController {

    @Autowired
    CalendarioService calendarioService;

    @PostMapping
    @ApiOperation(value="Insere um tipo de calendario")
    public Calendario createCalendario(@RequestBody Calendario calendario) {
        return calendarioService.saveCalendario(calendario);

    }

    @GetMapping("/list")
    @ApiOperation(value="Lista todas as calendario")
    public List<Calendario> getCalendarioList() {
        return calendarioService.findAll();

    }

    @GetMapping("/{idCalendario}")
    @ApiOperation(value="Lista a calendario selecionada pelo id")
    public ResponseEntity<Calendario> getJornadaByID(@PathVariable("idCalendario") Long idCalendario) throws Exception {
        return  ResponseEntity.ok(calendarioService.getById(idCalendario).orElseThrow(() -> new NoSuchElementException("Not found!" + HttpStatus.NOT_FOUND)));

    }

    @PutMapping
    @ApiOperation(value="Atualiza uma calendario")
    public Calendario updateCalendario(@RequestBody Calendario calendario){
        return calendarioService.updateCalendario(calendario);
    }

    @DeleteMapping("/{idCalendario}")
    @ApiOperation(value="Deleta a calendario selecionada pelo id")
    public ResponseEntity deleteByID(@PathVariable("idCalendario") Long idCalendario) throws Exception {
        try {
            calendarioService.deleteCalendario(idCalendario);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Calendario>) ResponseEntity.ok();

    }
}
