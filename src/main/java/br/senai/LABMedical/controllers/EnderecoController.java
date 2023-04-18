package br.senai.LABMedical.controllers;

import br.senai.LABMedical.dtos.ListagemEnderecos;
import br.senai.LABMedical.services.EnderecoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
    private final EnderecoService service;

    public EnderecoController(EnderecoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ListagemEnderecos> busca() {
        return service.busca();
    }

}
