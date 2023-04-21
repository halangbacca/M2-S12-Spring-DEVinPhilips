package br.senai.LABMedical.services;

import br.senai.LABMedical.dtos.AtualizaPaciente;
import br.senai.LABMedical.dtos.ListagemPacientes;
import br.senai.LABMedical.dtos.PacienteDTO;
import br.senai.LABMedical.models.Endereco;
import br.senai.LABMedical.models.Paciente;
import br.senai.LABMedical.repositories.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public Paciente cadastra(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente(pacienteDTO);
        return repository.save(paciente);
    }

    public List<ListagemPacientes> busca(String nome) {
        if (nome != null && !nome.isEmpty()) {
            return repository.findByNomeContainingIgnoreCase(nome);
        }
        return repository.findAll().stream().map(ListagemPacientes::new).toList();
    }

    public ListagemPacientes busca(Long id) {
        var paciente = repository.getReferenceById(id);
        return new ListagemPacientes(paciente);
    }

    public void deleta(Long id) {
        Paciente paciente = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.deleteById(id);
    }

    public Paciente atualiza(AtualizaPaciente pacienteAtualizado, Long id) {
        Paciente paciente = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (pacienteAtualizado.nome() != null && !pacienteAtualizado.nome().isEmpty()) {
            paciente.setNome(pacienteAtualizado.nome());
        }

        if (pacienteAtualizado.genero() != null && !pacienteAtualizado.genero().isEmpty()) {
            paciente.setGenero(pacienteAtualizado.genero());
        }

        if (pacienteAtualizado.dataNascimento() != null) {
            paciente.setDataNascimento(pacienteAtualizado.dataNascimento());
        }

        if (pacienteAtualizado.estadoCivil() != null) {
            paciente.setEstadoCivil(pacienteAtualizado.estadoCivil());
        }

        if (pacienteAtualizado.telefone() != null && !pacienteAtualizado.telefone().isEmpty()) {
            paciente.setTelefone(pacienteAtualizado.telefone());
        }

        if (pacienteAtualizado.email() != null && !pacienteAtualizado.email().isEmpty()) {
            paciente.setEmail(pacienteAtualizado.email());
        }

        if (pacienteAtualizado.naturalidade() != null && !pacienteAtualizado.naturalidade().isEmpty()) {
            paciente.setNaturalidade(pacienteAtualizado.naturalidade());
        }

        if (pacienteAtualizado.contatoDeEmergencia() != null && !pacienteAtualizado.contatoDeEmergencia().isEmpty()) {
            paciente.setContatoDeEmergencia(pacienteAtualizado.contatoDeEmergencia());
        }

        if (pacienteAtualizado.endereco_id() != null) {
            Endereco endereco = new Endereco(pacienteAtualizado.endereco_id());
            paciente.setEndereco(endereco);
        }

        return repository.save(paciente);
    }

}
