package br.senai.LABMedical.services;

import br.senai.LABMedical.dtos.ConsultaDTO;
import br.senai.LABMedical.models.Consulta;
import br.senai.LABMedical.repositories.ConsultaRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public void cadastra(ConsultaDTO consultaDTO) {
        Consulta consulta = new Consulta(consultaDTO);
        repository.save(consulta);
    }

}
