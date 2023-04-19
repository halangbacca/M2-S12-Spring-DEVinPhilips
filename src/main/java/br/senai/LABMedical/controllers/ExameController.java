package br.senai.LABMedical.controllers;

import br.senai.LABMedical.dtos.AtualizaExames;
import br.senai.LABMedical.dtos.ExameDTO;
import br.senai.LABMedical.dtos.ListagemExames;
import br.senai.LABMedical.services.ExameService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ListagemExames busca(@PathVariable Long id) {
        return service.busca(id);
    }

    @DeleteMapping("/{id}")
    public void deleta(@PathVariable Long id) {
        service.deleta(id);
    }

    @PutMapping("/{id}")
    public void atualiza(@RequestBody AtualizaExames exameAtualizado, @PathVariable Long id) {
        service.atualiza(exameAtualizado, id);
    }

}
