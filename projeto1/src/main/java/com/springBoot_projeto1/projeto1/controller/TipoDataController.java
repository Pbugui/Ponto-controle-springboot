package com.springBoot_projeto1.projeto1.controller;

import com.springBoot_projeto1.projeto1.model.JornadaTrabalho;
import com.springBoot_projeto1.projeto1.model.TipoData;
import com.springBoot_projeto1.projeto1.service.TipoDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/tipoData")
@Api(value="API REST Jornada")
@CrossOrigin(origins="*")
public class TipoDataController {

    @Autowired
    TipoDataService tipoDataService;

    @PostMapping
    @ApiOperation(value="Insere um tipo de tipoData")
    public TipoData createTipoData(@RequestBody TipoData tipoData) {
        return tipoDataService.saveTipoData(tipoData);

    }

    @GetMapping("/list")
    @ApiOperation(value="Lista todas as tipoData")
    public List<TipoData> getTipoDataList() {
        return tipoDataService.findAll();

    }

    @GetMapping("/{idTipoData}")
    @ApiOperation(value="Lista a tipoData selecionada pelo id")
    public ResponseEntity<TipoData> getTipoDataByID(@PathVariable("idTipoData") Long idTipoData) throws Exception {
        return  ResponseEntity.ok(tipoDataService.getById(idTipoData).orElseThrow(() -> new NoSuchElementException("Not found!" + HttpStatus.NOT_FOUND)));

    }

    @PutMapping
    @ApiOperation(value="Atualiza uma tipoData")
    public TipoData updateTipoData(@RequestBody TipoData tipoData){
        return tipoDataService.updateJornada(tipoData);
    }

    @DeleteMapping("/{idTipoData}")
    @ApiOperation(value="Deleta a tipoData selecionada pelo id")
    public ResponseEntity deleteByID(@PathVariable("idTipoData") Long idTipoData) throws Exception {
        try {
            tipoDataService.deleteTipoData(idTipoData);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<TipoData>) ResponseEntity.ok();

    }
}
