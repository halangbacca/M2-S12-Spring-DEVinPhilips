package br.senai.LABMedical.controllers;

import br.senai.LABMedical.dtos.AtualizaPacientes;
import br.senai.LABMedical.dtos.ListagemPacientes;
import br.senai.LABMedical.dtos.PacienteDTO;
import br.senai.LABMedical.models.Paciente;
import br.senai.LABMedical.services.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @PostMapping
    public void cadastra(@RequestBody @Validated PacienteDTO pacienteDTO) {
        service.cadastra(pacienteDTO);
    }

    @GetMapping
    public List<ListagemPacientes> busca(@RequestParam(required = false) String nome) {
        return service.busca(nome);
    }

    @GetMapping("/{id}")
    public ListagemPacientes busca(@PathVariable Long id) {
        return service.busca(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleta(@PathVariable Long id) {
        service.deleta(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualiza(@RequestBody @Validated AtualizaPacientes pacienteAtualizado, @PathVariable Long id) {
        return ResponseEntity.ok(service.atualiza(pacienteAtualizado, id));
    }

}