package com.springBoot_projeto1.projeto1.controller;

import com.springBoot_projeto1.projeto1.model.CategoriaUsuario;
import com.springBoot_projeto1.projeto1.model.Empresa;
import com.springBoot_projeto1.projeto1.service.EmpresaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/empresa")
@Api(value="API REST Empresa")
@CrossOrigin(origins="*")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @PostMapping
    @ApiOperation(value = "Insere uma Empresa")
    public Empresa createEmpresa(@RequestBody Empresa empresa) {
        return empresaService.saveEmpresa(empresa);

    }

    @GetMapping("/list")
    @ApiOperation(value="Lista todas as categoria do usuario")
    public List<Empresa> getEmpresaList() {
        return empresaService.findAll();

    }

    @GetMapping("/{idEmpresa}")
    @ApiOperation(value="Lista a Empresa selecionada pelo id")
    public ResponseEntity<Empresa> getEmpresaByID(@PathVariable("idEmpresa") Long idEmpresa) throws Exception {
        return  ResponseEntity.ok(empresaService.getById(idEmpresa).orElseThrow(() -> new NoSuchElementException("Not found!" + HttpStatus.NOT_FOUND)));

    }

    @PutMapping
    @ApiOperation(value = "Atualiza uma Empresa")
    public Empresa updateEmpresa(@RequestBody Empresa empresa) {
        return empresaService.updateEmpresa(empresa);

    }

    @DeleteMapping("/{idEmpresa}")
    @ApiOperation(value="Deleta a empresa selecionada pelo id")
    public ResponseEntity deleteByID(@PathVariable("idEmpresa") Long idEmpresa) throws Exception {

        try {
            empresaService.deleteEmpresa(idEmpresa);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<CategoriaUsuario>) ResponseEntity.ok();

    }
}
