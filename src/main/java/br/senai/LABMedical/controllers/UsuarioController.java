package br.senai.LABMedical.controllers;

import br.senai.LABMedical.dtos.UsuarioDTO;
import br.senai.LABMedical.services.UsuarioService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public void cadastra(@RequestBody @Validated UsuarioDTO usuarioDTO) {
        service.cadastra(usuarioDTO);
    }

}
