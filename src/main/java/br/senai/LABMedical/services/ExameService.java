package br.senai.LABMedical.services;

import br.senai.LABMedical.dtos.AtualizaExame;
import br.senai.LABMedical.dtos.ExameDTO;
import br.senai.LABMedical.dtos.ListagemExames;
import br.senai.LABMedical.models.Endereco;
import br.senai.LABMedical.models.Exame;
import br.senai.LABMedical.models.Paciente;
import br.senai.LABMedical.models.Usuario;
import br.senai.LABMedical.repositories.ExameRepository;
import br.senai.LABMedical.repositories.PacienteRepository;
import br.senai.LABMedical.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExameService {

    @Autowired
    private ExameRepository repository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Exame cadastra(ExameDTO exameDTO) {
        Exame exame = new Exame(exameDTO);
        exame.setPaciente(pacienteRepository.findById(exame.getPaciente().getId()).orElseThrow(EntityNotFoundException::new));
        exame.setUsuario(usuarioRepository.findById(exame.getUsuario().getId()).orElseThrow(EntityNotFoundException::new));
        return repository.save(exame);
    }

    public ListagemExames busca(Long id) {
        var exame = repository.getReferenceById(id);
        return new ListagemExames(exame);
    }

    public void deleta(Long id) {
        repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.deleteById(id);
    }

    public Exame atualiza(AtualizaExame exameAtualizado, Long id) {
        Exame exame = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (exameAtualizado.nome() != null && !exameAtualizado.nome().isEmpty()) {
            exame.setNome(exameAtualizado.nome());
        }

        if (exameAtualizado.tipo() != null && !exameAtualizado.tipo().isEmpty()) {
            exame.setTipo(exameAtualizado.tipo());
        }

        if (exameAtualizado.laboratorio() != null && !exameAtualizado.laboratorio().isEmpty()) {
            exame.setLaboratorio(exameAtualizado.laboratorio());
        }

        if (exameAtualizado.pdf() != null && !exameAtualizado.pdf().isEmpty()) {
            exame.setPdf(exameAtualizado.pdf());
        }

        if (exameAtualizado.resultados() != null && !exameAtualizado.resultados().isEmpty()) {
            exame.setResultados(exameAtualizado.resultados());
        }

        if (exameAtualizado.paciente_id() != null) {
            Paciente paciente = new Paciente(exameAtualizado.paciente_id());
            exame.setPaciente(paciente);
            exame.setPaciente(pacienteRepository.findById(exame.getPaciente().getId()).orElseThrow(EntityNotFoundException::new));
        }

        if (exameAtualizado.usuario_id() != null) {
            Usuario usuario = new Usuario(exameAtualizado.usuario_id());
            exame.setUsuario(usuario);
            exame.setUsuario(usuarioRepository.findById(exame.getUsuario().getId()).orElseThrow(EntityNotFoundException::new));
        }

        return repository.save(exame);
    }

}
