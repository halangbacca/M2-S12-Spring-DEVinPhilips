package br.senai.LABMedical.dtos;

import br.senai.LABMedical.models.EstadoCivil;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record PacienteDTO(
        @NotBlank(message = "O preenchimento do nome é obrigatório!")
        String nome,
        @NotBlank(message = "O preenchimento do gênero é obrigatório!")
        String genero,
        @NotNull(message = "O preenchimento da data de nascimento é obrigatória!")
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
        String alergias,
        String cuidadosEspecificos,
        @NotBlank(message = "O preenchimento de um contato de emergência é obrigatório!")
        String contatoDeEmergencia,
        String convenio,
        String numeroConvenio,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate validadeConvenio,
        @NotNull(message = "O preenchimento do ID do endereço é obrigatório!")
        Long endereco_id
) {
}
