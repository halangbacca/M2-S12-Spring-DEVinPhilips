package br.senai.LABMedical.controllers;

import br.senai.LABMedical.dtos.AtualizaExame;
import br.senai.LABMedical.dtos.ExameDTO;
import br.senai.LABMedical.dtos.ListagemExames;
import br.senai.LABMedical.models.Exame;
import br.senai.LABMedical.services.ExameService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/exames")
public class ExameController {
    private final ExameService service;

    public ExameController(ExameService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Exame> cadastra(@RequestBody @Validated ExameDTO exameDTO, UriComponentsBuilder builder) {
        Exame exame = service.cadastra(exameDTO);

        URI uri = builder.path("/api/exames/{id}").buildAndExpand(exame.getId()).toUri();
        return ResponseEntity.created(uri).body(exame);
    }

    @GetMapping("/{id}")
    public ListagemExames busca(@PathVariable Long id) {
        return service.busca(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleta(@PathVariable Long id) {
        service.deleta(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exame> atualiza(@RequestBody @Validated AtualizaExame exameAtualizado, @PathVariable Long id) {
        return ResponseEntity.ok(service.atualiza(exameAtualizado, id));
    }

}
