package br.senai.LABMedical.dtos;

import br.senai.LABMedical.models.Endereco;
import br.senai.LABMedical.models.EstadoCivil;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PacienteDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String genero;
    @NotBlank
    private String dataNascimento;
    @NotBlank
    private String cpf;
    @NotBlank
    private String rg;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
    @NotBlank
    private String telefone;
    @NotBlank
    private String email;
    @NotBlank
    private String naturalidade;
    private String alergias;
    private String cuidadosEspecificos;
    @NotBlank
    private String contatoDeEmergencia;
    private String convenio;
    private String numeroConvenio;
    private String validadeConvenio;
    private Endereco endereco;
}
