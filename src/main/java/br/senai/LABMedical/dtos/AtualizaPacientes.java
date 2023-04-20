package br.senai.LABMedical.dtos;

import br.senai.LABMedical.models.EstadoCivil;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizaPacientes(
        @NotBlank(message = "O preenchimento do nome é obrigatório!")
        String nome,
        @NotBlank(message = "O preenchimento do gênero é obrigatório!")
        String genero,
        @NotBlank(message = "O preenchimento da data de nascimento é obrigatória!")
        String dataNascimento,
        @Enumerated(EnumType.STRING)
        EstadoCivil estadoCivil,
        @NotBlank(message = "O preenchimento do telefone é obrigatório!")
        String telefone,
        @NotBlank(message = "O preenchimento do e-mail é obrigatório!")
        String email,
        @NotBlank(message = "O preenchimento da naturalidade é obrigatória!")
        String naturalidade,
        String alergias,
        String cuidadosEspecificos,
        @NotBlank(message = "O preenchimento de um contato de emergência é obrigatório!")
        String contatoDeEmergencia,
        String convenio,
        String numeroConvenio,
        String validadeConvenio,
        @NotNull(message = "O preenchimento do ID do endereço é obrigatório!")
        Long endereco_id
) {
}
