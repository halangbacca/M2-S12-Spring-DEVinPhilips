package br.senai.LABMedical.models;

import br.senai.LABMedical.dtos.EnderecoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enderecos")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String cep;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;
    @NotBlank
    private String logradouro;
    @NotNull
    private Integer numero;
    private String complemento;
    @NotBlank
    private String bairro;
    @Column(name = "ponto_referencia")
    private String pontoReferencia;

    public Endereco(EnderecoDTO enderecoDTO) {
        this.cep = enderecoDTO.cep();
        this.cidade = enderecoDTO.cidade();
        this.estado = enderecoDTO.estado();
        this.logradouro = enderecoDTO.logradouro();
        this.numero = enderecoDTO.numero();
        this.complemento = enderecoDTO.complemento();
        this.bairro = enderecoDTO.bairro();
        this.pontoReferencia = enderecoDTO.pontoReferencia();
    }

    public Endereco(Long enderecoId) {
        this.setId(enderecoId);
    }
}
