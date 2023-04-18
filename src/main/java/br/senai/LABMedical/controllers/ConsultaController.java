package br.senai.LABMedical.controllers;

import br.senai.LABMedical.dtos.ConsultaDTO;
import br.senai.LABMedical.services.ConsultaService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {
    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @PostMapping
    public void cadastra(@RequestBody @Validated ConsultaDTO consultaDTO) {
        service.cadastra(consultaDTO);
    }

}
