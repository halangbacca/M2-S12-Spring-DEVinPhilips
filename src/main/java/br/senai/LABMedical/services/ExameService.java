package br.senai.LABMedical.services;

import br.senai.LABMedical.dtos.ExameDTO;
import br.senai.LABMedical.dtos.ListagemExames;
import br.senai.LABMedical.models.Exame;
import br.senai.LABMedical.repositories.ExameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExameService {
    private final ExameRepository repository;

    public ExameService(ExameRepository repository) {
        this.repository = repository;
    }

    public void cadastra(ExameDTO exameDTO) {
        Exame exame = new Exame(exameDTO);
        repository.save(exame);
    }

    public ListagemExames busca(Long id) {
        var exame = repository.getReferenceById(id);
        return new ListagemExames(exame);
    }

}
