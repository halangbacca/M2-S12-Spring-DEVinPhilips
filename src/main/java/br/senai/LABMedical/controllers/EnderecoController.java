package br.senai.LABMedical.controllers;

import br.senai.LABMedical.dtos.EnderecoDTO;
import br.senai.LABMedical.dtos.ListagemEnderecos;
import br.senai.LABMedical.services.EnderecoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
    private final EnderecoService service;

    public EnderecoController(EnderecoService service) {
        this.service = service;
    }

    @PostMapping
    public void cadastra(@RequestBody @Validated EnderecoDTO enderecoDTO) {
        service.cadastra(enderecoDTO);
    }

    @GetMapping
    public List<ListagemEnderecos> busca() {
        return service.busca();
    }

}
