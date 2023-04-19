package br.senai.LABMedical.dtos;

import br.senai.LABMedical.models.Especialidade;
import br.senai.LABMedical.models.EstadoCivil;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public record AtualizaUsuarios(
        @NotBlank
        String nome,
        @NotBlank
        String genero,
        @NotBlank
        String dataNascimento,
        @Enumerated(EnumType.STRING)
        EstadoCivil estadoCivil,
        @NotBlank
        String telefone,
        @NotBlank
        String email,
        @NotBlank
        String naturalidade,
        @NotBlank
        String crm,
        @Enumerated(EnumType.STRING)
        Especialidade especialidade
) {
}
