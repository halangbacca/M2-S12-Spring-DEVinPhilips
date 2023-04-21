package br.senai.LABMedical.dtos;

import br.senai.LABMedical.models.Especialidade;
import br.senai.LABMedical.models.EstadoCivil;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record UsuarioDTO(
        @NotBlank(message = "O preenchimento do nome é obrigatório!")
        String nome,
        @NotBlank(message = "O preenchimento do gênero é obrigatório!")
        String genero,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNascimento,
        @NotBlank(message = "O preenchimento do CPF é obrigatório!")
        @CPF(message = "O formato do CPF é inválido!")
        String cpf,
        @NotBlank(message = "O preenchimento do RG é obrigatório!")
        String rg,
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
        String crm,
        @Enumerated(EnumType.STRING)
        Especialidade especialidade,
        @NotBlank(message = "O preenchimento da senha é obrigatória!")
        @Size(min = 8, message = "A senha deve possuir pelo menos 8 caracteres alfanuméricos!")
        String senha
) {
}
