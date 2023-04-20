package br.senai.LABMedical.dtos;

import br.senai.LABMedical.models.Endereco;
import br.senai.LABMedical.models.EstadoCivil;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PacienteDTO {
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
    private String alergias;
    private String cuidadosEspecificos;
    @NotBlank(message = "O preenchimento de um contato de emergência é obrigatório!")
    private String contatoDeEmergencia;
    private String convenio;
    private String numeroConvenio;
    private String validadeConvenio;
    private Endereco endereco;
}
