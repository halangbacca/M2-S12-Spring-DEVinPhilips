package br.senai.LABMedical.dtos;

import br.senai.LABMedical.models.Especialidade;
import br.senai.LABMedical.models.EstadoCivil;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
public class UsuarioDTO {
    @NotBlank(message = "O preenchimento do nome é obrigatório!")
    private String nome;
    @NotBlank(message = "O preenchimento do gênero é obrigatório!")
    private String genero;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    @NotBlank(message = "O preenchimento do CPF é obrigatório!")
    @CPF(message = "O formato do CPF é inválido!")
    private String cpf;
    @NotBlank(message = "O preenchimento do RG é obrigatório!")
    private String rg;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
    @NotBlank(message = "O preenchimento do telefone é obrigatório!")
    private String telefone;
    @NotBlank(message = "O preenchimento do e-mail é obrigatório!")
    @Email(message = "O formato do email é inválido!")
    private String email;
    @NotBlank(message = "O preenchimento da naturalidade é obrigatória!")
    private String naturalidade;
    @NotBlank(message = "O preenchimento do CRM/UF é obrigatório!")
    @Pattern(regexp = "\\d{4,6}", message = "O formato do CRM/UF é inválido!")
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @NotBlank(message = "O preenchimento da senha é obrigatória!")
    @Size(min = 8, message = "A senha deve possuir pelo menos 8 caracteres alfanuméricos!")
    private String senha;
}
