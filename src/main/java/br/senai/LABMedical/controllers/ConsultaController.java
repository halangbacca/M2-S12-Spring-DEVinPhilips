package br.senai.LABMedical.controllers;

import br.senai.LABMedical.dtos.AtualizaConsultas;
import br.senai.LABMedical.dtos.ConsultaDTO;
import br.senai.LABMedical.dtos.ListagemConsultas;
import br.senai.LABMedical.services.ConsultaService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ListagemConsultas busca(@PathVariable Long id) {
        return service.busca(id);
    }

    @DeleteMapping("/{id}")
    public void deleta(@PathVariable Long id) {
        service.deleta(id);
    }

    @PutMapping("/{id}")
    public void atualiza(@RequestBody @Validated AtualizaConsultas consultaAtualizada, @PathVariable Long id) {
        service.atualiza(consultaAtualizada, id);
    }

}
