package com.springBoot_projeto1.projeto1.controller;

import com.springBoot_projeto1.projeto1.model.CategoriaUsuario;
import com.springBoot_projeto1.projeto1.service.CategoriaUsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/categoriaUsuario")
@Api(value="API REST Categoria Usuario")
@CrossOrigin(origins="*")
public class CategoriaUsuarioController {

    @Autowired
    CategoriaUsuarioService categoriaUsuarioService;

    @PostMapping
    @ApiOperation(value = "Insere uma categoria de usuario")
    public CategoriaUsuario createCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario) {
        return categoriaUsuarioService.saveCategoriaUsuario(categoriaUsuario);

    }

    @GetMapping("/list")
    @ApiOperation(value="Lista todas as categoria do usuario")
    public List<CategoriaUsuario> getJornadaList() {
        return categoriaUsuarioService.findAll();

    }

    @GetMapping("/{idCategoriaUsuario}")
    @ApiOperation(value="Lista a categoria do usuario selecionada pelo id")
    public ResponseEntity<CategoriaUsuario> getJornadaByID(@PathVariable("idCategoriaUsuario") Long idCategoriaUsuario) throws Exception {
        return  ResponseEntity.ok(categoriaUsuarioService.getById(idCategoriaUsuario).orElseThrow(() -> new NoSuchElementException("Not found!" + HttpStatus.NOT_FOUND)));

    }

    @PutMapping
    @ApiOperation(value = "Atualiza uma categoria de usuario")
    public CategoriaUsuario updateCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario) {
        return categoriaUsuarioService.updateCategoriaUsuario(categoriaUsuario);

    }

    @DeleteMapping("/{idCategoriaUsuario}")
    @ApiOperation(value="Deleta a categoria de usuario selecionada pelo id")
    public ResponseEntity deleteByID(@PathVariable("idCategoriaUsuario") Long idCategoriaUsuario) throws Exception {

        try {
            categoriaUsuarioService.deleteCategoriaUsuario(idCategoriaUsuario);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<CategoriaUsuario>) ResponseEntity.ok();

    }

}
