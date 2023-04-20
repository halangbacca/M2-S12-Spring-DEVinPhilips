package br.senai.LABMedical.dtos;

import br.senai.LABMedical.models.Especialidade;
import br.senai.LABMedical.models.EstadoCivil;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AtualizaUsuarios(
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
        @Email(message = "O formato do email é inválido!")
        String email,
        @NotBlank(message = "O preenchimento da naturalidade é obrigatória!")
        String naturalidade,
        @NotBlank(message = "O preenchimento do CRM/UF é obrigatório!")
        @Pattern(regexp = "\\d{4,6}", message = "O formato do CRM/UF é inválido!")
        String crm,
        @Enumerated(EnumType.STRING)
        Especialidade especialidade
) {
}
