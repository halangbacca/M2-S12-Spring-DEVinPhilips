package br.senai.LABMedical.services;

import br.senai.LABMedical.dtos.AtualizaConsulta;
import br.senai.LABMedical.dtos.ConsultaDTO;
import br.senai.LABMedical.dtos.ListagemConsultas;
import br.senai.LABMedical.models.Consulta;
import br.senai.LABMedical.models.Paciente;
import br.senai.LABMedical.models.Usuario;
import br.senai.LABMedical.repositories.ConsultaRepository;
import br.senai.LABMedical.repositories.PacienteRepository;
import br.senai.LABMedical.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Consulta cadastra(ConsultaDTO consultaDTO) {
        Consulta consulta = new Consulta(consultaDTO);
        consulta.setPaciente(pacienteRepository.findById(consulta.getPaciente().getId()).orElseThrow(EntityNotFoundException::new));
        consulta.setUsuario(usuarioRepository.findById(consulta.getUsuario().getId()).orElseThrow(EntityNotFoundException::new));
        return repository.save(consulta);
    }

    public ListagemConsultas busca(Long id) {
        var consulta = repository.getReferenceById(id);
        return new ListagemConsultas(consulta);
    }

    public void deleta(Long id) {
        repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.deleteById(id);
    }

    public Consulta atualiza(AtualizaConsulta consultaAtualizada, Long id) {
        Consulta consulta = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (consultaAtualizada.motivo() != null && !consultaAtualizada.motivo().isEmpty()) {
            consulta.setMotivo(consultaAtualizada.motivo());
        }

        if (consultaAtualizada.descricao() != null && !consultaAtualizada.descricao().isEmpty()) {
            consulta.setDescricao(consultaAtualizada.descricao());
        }

        if (consultaAtualizada.medicacao() != null && !consultaAtualizada.medicacao().isEmpty()) {
            consulta.setMedicacao(consultaAtualizada.medicacao());
        }

        if (consultaAtualizada.dosagem() != null && !consultaAtualizada.dosagem().isEmpty()) {
            consulta.setDosagem(consultaAtualizada.dosagem());
        }

        if (consultaAtualizada.paciente_id() != null) {
            Paciente paciente = new Paciente(consultaAtualizada.paciente_id());
            consulta.setPaciente(paciente);
            consulta.setPaciente(pacienteRepository.findById(consulta.getPaciente().getId()).orElseThrow(EntityNotFoundException::new));
        }

        if (consultaAtualizada.usuario_id() != null) {
            Usuario usuario = new Usuario(consultaAtualizada.usuario_id());
            consulta.setUsuario(usuario);
            consulta.setUsuario(usuarioRepository.findById(consulta.getUsuario().getId()).orElseThrow(EntityNotFoundException::new));
        }

        return repository.save(consulta);
    }

}
