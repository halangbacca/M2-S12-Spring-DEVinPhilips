package br.senai.LABMedical.services;

import br.senai.LABMedical.dtos.AtualizaConsulta;
import br.senai.LABMedical.dtos.ConsultaDTO;
import br.senai.LABMedical.dtos.ListagemConsultas;
import br.senai.LABMedical.models.Consulta;
import br.senai.LABMedical.repositories.ConsultaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public Consulta cadastra(ConsultaDTO consultaDTO) {
        Consulta consulta = new Consulta(consultaDTO);
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

        return repository.save(consulta);
    }

}
