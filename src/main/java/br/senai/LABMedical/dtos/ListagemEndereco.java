package br.senai.LABMedical.dtos;

import br.senai.LABMedical.models.Endereco;

public record ListagemEndereco(Long id, String cep, String cidade, String estado, String logradouro, Integer numero,
                               String complemento, String bairro, String pontoReferencia) {

    public ListagemEndereco(Endereco endereco) {
        this(endereco.getId(), endereco.getCep(), endereco.getCidade(), endereco.getEstado(), endereco.getLogradouro(), endereco.getNumero(), endereco.getComplemento(), endereco.getBairro(), endereco.getPontoReferencia());
    }

}
