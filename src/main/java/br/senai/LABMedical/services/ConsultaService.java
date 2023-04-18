package br.senai.LABMedical.services;

import br.senai.LABMedical.dtos.ConsultaDTO;
import br.senai.LABMedical.dtos.ListagemConsultas;
import br.senai.LABMedical.models.Consulta;
import br.senai.LABMedical.repositories.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ListagemConsultas> busca() {
        return repository.findAll().stream().map(ListagemConsultas::new).toList();
    }

    public ListagemConsultas busca(Long id) {
        var consulta = repository.getReferenceById(id);
        return new ListagemConsultas(consulta);
    }

}
