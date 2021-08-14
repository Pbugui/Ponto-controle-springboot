package com.springBoot_projeto1.projeto1.controller;

import com.springBoot_projeto1.projeto1.model.JornadaTrabalho;
import com.springBoot_projeto1.projeto1.model.Localidade;
import com.springBoot_projeto1.projeto1.service.LocalidadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/localidade")
@Api(value="API REST Localidade")
@CrossOrigin(origins="*")
public class LocalidadeController {

    @Autowired
    LocalidadeService localidadeService;

    @PostMapping
    @ApiOperation(value="Insere um tipo de localidade")
    public Localidade createLocalidade(@RequestBody Localidade localidade) {
        return localidadeService.saveLocalidade(localidade);

    }

    @GetMapping("/list")
    @ApiOperation(value="Lista todas as localidades")
    public List<Localidade> getLocalidadeList() {
        return localidadeService.findAll();

    }

    @GetMapping("/{idLocalidade}")
    @ApiOperation(value="Lista a localidade selecionada pelo id")
    public ResponseEntity<Localidade> getJornadaByID(@PathVariable("idLocalidade") Long idLocalidade) throws Exception {
        return  ResponseEntity.ok(localidadeService.getById(idLocalidade).orElseThrow(() -> new NoSuchElementException("Not found!" + HttpStatus.NOT_FOUND)));

    }

    @PutMapping
    @ApiOperation(value="Atualiza uma localidade")
    public Localidade updateLocalidade(@RequestBody Localidade localidade){
        return localidadeService.updateLocalidade(localidade);
    }

    @DeleteMapping("/{idLocalidade}")
    @ApiOperation(value="Deleta a localidade selecionada pelo id")
    public ResponseEntity deleteByID(@PathVariable("idLocalidade") Long idLocalidade) throws Exception {
        try {
            localidadeService.deleteJornada(idLocalidade);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();

    }
}
