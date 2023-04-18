package br.senai.LABMedical.services;

import br.senai.LABMedical.dtos.ListagemPacientes;
import br.senai.LABMedical.dtos.PacienteDTO;
import br.senai.LABMedical.models.Paciente;
import br.senai.LABMedical.repositories.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public void cadastra(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente(pacienteDTO);
        repository.save(paciente);
    }

    public List<ListagemPacientes> busca() {
        return repository.findAll().stream().map(ListagemPacientes::new).toList();
    }

    public ListagemPacientes busca(Long id) {
        var paciente = repository.getReferenceById(id);
        return new ListagemPacientes(paciente);
    }

    public void deleta(Long id) {
        repository.deleteById(id);
    }

}
