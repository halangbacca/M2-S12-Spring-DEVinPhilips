package br.senai.LABMedical.controllers;

import br.senai.LABMedical.dtos.ExameDTO;
import br.senai.LABMedical.dtos.ListagemExames;
import br.senai.LABMedical.services.ExameService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<ListagemExames> busca() {
        return service.busca();
    }

    @GetMapping("/{id}")
    public ListagemExames busca(@PathVariable Long id) {
        return service.busca(id);
    }

}
