package br.senai.LABMedical.controllers;

import br.senai.LABMedical.dtos.EnderecoDTO;
import br.senai.LABMedical.dtos.ListagemEnderecos;
import br.senai.LABMedical.models.Endereco;
import br.senai.LABMedical.services.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
    private final EnderecoService service;

    public EnderecoController(EnderecoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Endereco> cadastra(@RequestBody @Validated EnderecoDTO enderecoDTO, UriComponentsBuilder builder) {
        Endereco endereco = service.cadastra(enderecoDTO);

        URI uri = builder.path("/api/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(endereco);
    }

    @GetMapping
    public List<ListagemEnderecos> busca() {
        return service.busca();
    }

}
