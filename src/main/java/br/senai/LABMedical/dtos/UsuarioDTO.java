package br.senai.LABMedical.dtos;

import br.senai.LABMedical.models.Especialidade;
import br.senai.LABMedical.models.EstadoCivil;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioDTO {
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
    @NotBlank
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @NotBlank
    private String senha;
}
