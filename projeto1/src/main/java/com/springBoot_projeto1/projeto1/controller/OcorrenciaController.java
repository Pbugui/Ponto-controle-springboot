package com.springBoot_projeto1.projeto1.controller;

import com.springBoot_projeto1.projeto1.model.JornadaTrabalho;
import com.springBoot_projeto1.projeto1.model.Ocorrencia;
import com.springBoot_projeto1.projeto1.service.OcorrenciaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/ocorrencia")
@Api(value="API REST Jornada")
@CrossOrigin(origins="*")
public class OcorrenciaController {

    @Autowired
    OcorrenciaService ocorrenciaService;

    @PostMapping
    @ApiOperation(value="Insere um tipo de ocorrencia")
    public Ocorrencia createOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaService.createOcorrencia(ocorrencia);

    }

    @GetMapping("/list")
    @ApiOperation(value="Lista todas as ocorrencia")
    public List<Ocorrencia> getOcorrenciaList() {
        return ocorrenciaService.findAll();

    }

    @GetMapping("/{idOcorencia}")
    @ApiOperation(value="Lista a ocorrencia selecionada pelo id")
    public ResponseEntity<Ocorrencia> getOcorrenciaByID(@PathVariable("idOcorencia") Long idOcorencia) throws Exception {
        return  ResponseEntity.ok(ocorrenciaService.getById(idOcorencia).orElseThrow(() -> new NoSuchElementException("Not found!" + HttpStatus.NOT_FOUND)));

    }

    @PutMapping
    @ApiOperation(value="Atualiza uma ocorrencia")
    public Ocorrencia updateOcorrencia(@RequestBody Ocorrencia ocorrencia){
        return ocorrenciaService.updateOcorrencia(ocorrencia);
    }

    @DeleteMapping("/{idOcorencia}")
    @ApiOperation(value="Deleta a ocorrencia selecionada pelo id")
    public ResponseEntity deleteByID(@PathVariable("idOcorencia") Long idOcorencia) throws Exception {
        try {
            ocorrenciaService.deleteOcorrencia(idOcorencia);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Ocorrencia>) ResponseEntity.ok();

    }
}
