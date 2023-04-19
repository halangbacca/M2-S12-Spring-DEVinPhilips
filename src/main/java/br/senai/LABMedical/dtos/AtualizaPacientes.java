package br.senai.LABMedical.dtos;

import br.senai.LABMedical.models.Endereco;
import br.senai.LABMedical.models.EstadoCivil;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public record AtualizaPacientes(
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
        String alergias,
        String cuidadosEspecificos,
        @NotBlank
        String contatoDeEmergencia,
        String convenio,
        String numeroConvenio,
        String validadeConvenio,
        Endereco endereco
) {
}
