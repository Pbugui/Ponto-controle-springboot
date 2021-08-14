package com.springBoot_projeto1.projeto1.controller;

import com.springBoot_projeto1.projeto1.model.JornadaTrabalho;
import com.springBoot_projeto1.projeto1.model.NivelAcesso;
import com.springBoot_projeto1.projeto1.model.Usuario;
import com.springBoot_projeto1.projeto1.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/usuario")
@Api(value="API REST Usuario")
@CrossOrigin(origins="*")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    @ApiOperation(value="Insere um tipo de usuario")
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);

    }

    @GetMapping("/list")
    @ApiOperation(value="Lista todas os usuario")
    public List<Usuario> getUsuario() {
        return usuarioService.findAll();

    }

    @GetMapping("/{idUsuario}")
    @ApiOperation(value="Lista o usuario selecionada pelo id")
    public ResponseEntity<Usuario> getNivelAcessoByID(@PathVariable("idUsuario") Long idUsuario) throws Exception {
        return  ResponseEntity.ok(usuarioService.getById(idUsuario).orElseThrow(() -> new NoSuchElementException("Not found!" + HttpStatus.NOT_FOUND)));

    }

    @PutMapping
    @ApiOperation(value="Atualiza um usuario")
    public Usuario updateUsuario(@RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(usuario);

    }

    @DeleteMapping("/{idUsuario}")
    @ApiOperation(value="Deleta o usuario selecionada pelo id")
    public ResponseEntity deleteByID(@PathVariable("idUsuario") Long idUsuario) throws Exception {
        try {
            usuarioService.deleteUsuario(idUsuario);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();

    }
}
