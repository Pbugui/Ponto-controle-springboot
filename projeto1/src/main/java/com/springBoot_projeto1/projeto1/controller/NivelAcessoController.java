package com.springBoot_projeto1.projeto1.controller;

import com.springBoot_projeto1.projeto1.model.JornadaTrabalho;
import com.springBoot_projeto1.projeto1.model.NivelAcesso;
import com.springBoot_projeto1.projeto1.service.NivelAcessoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/nivelAcesso")
@Api(value="API REST Nivel Acesso")
@CrossOrigin(origins="*")
public class NivelAcessoController {

    @Autowired
    NivelAcessoService nivelAcessoService;

    @PostMapping
    @ApiOperation(value="Insere um tipo de nivel acesso")
    public NivelAcesso createNivelAcesso(@RequestBody NivelAcesso nivelAcesso) {
        return nivelAcessoService.saveNivelAcesso(nivelAcesso);

    }

    @GetMapping("/list")
    @ApiOperation(value="Lista todas os nivel acesso")
    public List<NivelAcesso> getNivelAcesso() {
        return nivelAcessoService.findAll();

    }

    @GetMapping("/{idNivelAcesso}")
    @ApiOperation(value="Lista o nivel acesso selecionada pelo id")
    public ResponseEntity<NivelAcesso> getNivelAcessoByID(@PathVariable("idNivelAcesso") Long idNivelAcesso) throws Exception {
        return  ResponseEntity.ok(nivelAcessoService.getById(idNivelAcesso).orElseThrow(() -> new NoSuchElementException("Not found!" + HttpStatus.NOT_FOUND)));

    }

    @PutMapping
    @ApiOperation(value="Atualiza um nivel acesso")
    public NivelAcesso updateNivelAcesso(@RequestBody NivelAcesso nivelAcesso) {
        return nivelAcessoService.updateNivelAcesso(nivelAcesso);

    }

    @DeleteMapping("/{idNivelAcesso}")
    @ApiOperation(value="Deleta o nivel acesso selecionada pelo id")
    public ResponseEntity deleteByID(@PathVariable("idNivelAcesso") Long idNivelAcesso) throws Exception {
        try {
            nivelAcessoService.deleteJornada(idNivelAcesso);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();

    }


}
