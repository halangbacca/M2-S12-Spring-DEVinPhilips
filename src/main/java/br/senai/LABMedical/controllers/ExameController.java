package br.senai.LABMedical.controllers;

import br.senai.LABMedical.dtos.ExameDTO;
import br.senai.LABMedical.services.ExameService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exames")
public class ExameController {
    private final ExameService service;

    public ExameController(ExameService service) {
        this.service = service;
    }

    @PostMapping
    public void cadastra(@RequestBody @Validated ExameDTO exameDTO) {
        service.cadastra(exameDTO);
    }

}
