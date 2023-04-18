package br.senai.LABMedical.models;

import br.senai.LABMedical.dtos.PacienteDTO;
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

    public Endereco(PacienteDTO pacienteDTO) {
        this.cep = pacienteDTO.getEndereco().cep;
        this.cidade = pacienteDTO.getEndereco().cidade;
        this.estado = pacienteDTO.getEndereco().estado;
        this.logradouro = pacienteDTO.getEndereco().logradouro;
        this.numero = pacienteDTO.getEndereco().numero;
        this.complemento = pacienteDTO.getEndereco().complemento;
        this.bairro = pacienteDTO.getEndereco().bairro;
        this.pontoReferencia = pacienteDTO.getEndereco().pontoReferencia;
    }

}
