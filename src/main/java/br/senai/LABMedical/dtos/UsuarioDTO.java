package br.senai.LABMedical.dtos;

import br.senai.LABMedical.models.Especialidade;
import br.senai.LABMedical.models.EstadoCivil;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioDTO {
    @NotBlank(message = "O preenchimento do nome é obrigatório!")
    private String nome;
    @NotBlank(message = "O preenchimento do gênero é obrigatório!")
    private String genero;
    @NotBlank(message = "O preenchimento da data de nascimento é obrigatória!")
    private String dataNascimento;
    @NotBlank(message = "O preenchimento do CPF é obrigatório!")
    private String cpf;
    @NotBlank(message = "O preenchimento do RG é obrigatório!")
    private String rg;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
    @NotBlank(message = "O preenchimento do telefone é obrigatório!")
    private String telefone;
    @NotBlank(message = "O preenchimento do e-mail é obrigatório!")
    private String email;
    @NotBlank(message = "O preenchimento da naturalidade é obrigatória!")
    private String naturalidade;
    @NotBlank(message = "O preenchimento do CRM/UF é obrigatório!")
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @NotBlank(message = "O preenchimento da senha é obrigatória!")
    @Min(value = 8, message = "A senha deve possuir pelo menos 8 caracteres alfanuméricos!")
    private String senha;
}
