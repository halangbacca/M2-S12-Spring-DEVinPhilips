package br.senai.LABMedical.dtos;

import br.senai.LABMedical.models.EstadoCivil;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
public class PacienteDTO {
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
    private String alergias;
    private String cuidadosEspecificos;
    @NotBlank(message = "O preenchimento de um contato de emergência é obrigatório!")
    private String contatoDeEmergencia;
    private String convenio;
    private String numeroConvenio;
    private String validadeConvenio;
    @NotNull(message = "O preenchimento do ID do endereço é obrigatório!")
    private Long endereco_id;
}
