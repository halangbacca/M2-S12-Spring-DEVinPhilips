package br.senai.LABMedical.controllers;

import br.senai.LABMedical.dtos.AtualizaConsultas;
import br.senai.LABMedical.dtos.ConsultaDTO;
import br.senai.LABMedical.dtos.ListagemConsultas;
import br.senai.LABMedical.models.Consulta;
import br.senai.LABMedical.services.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {
    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Consulta> cadastra(@RequestBody @Validated ConsultaDTO consultaDTO, UriComponentsBuilder builder) {
        Consulta consulta = service.cadastra(consultaDTO);

        URI uri = builder.path("/api/consultas/{id}").buildAndExpand(consulta.getId()).toUri();
        return ResponseEntity.created(uri).body(consulta);
    }

    @GetMapping("/{id}")
    public ListagemConsultas busca(@PathVariable Long id) {
        return service.busca(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleta(@PathVariable Long id) {
        service.deleta(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> atualiza(@RequestBody @Validated AtualizaConsultas consultaAtualizada, @PathVariable Long id) {
        return ResponseEntity.ok(service.atualiza(consultaAtualizada, id));
    }

}
