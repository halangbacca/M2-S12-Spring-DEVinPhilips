package br.senai.LABMedical.services;

import br.senai.LABMedical.dtos.EnderecoDTO;
import br.senai.LABMedical.dtos.ListagemEnderecos;
import br.senai.LABMedical.models.Endereco;
import br.senai.LABMedical.repositories.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public void cadastra(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco(enderecoDTO);
        repository.save(endereco);
    }

    public List<ListagemEnderecos> busca() {
        return repository.findAll().stream().map(ListagemEnderecos::new).toList();
    }

}
