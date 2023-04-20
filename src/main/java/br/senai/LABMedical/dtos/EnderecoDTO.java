package br.senai.LABMedical.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EnderecoDTO {
    @NotBlank(message = "O preenchimento do CEP do paciente é obrigatório!")
    private String cep;
    @NotBlank(message = "O preenchimento da cidade do paciente é obrigatória!")
    private String cidade;
    @NotBlank(message = "O preenchimento do estado do paciente é obrigatório!")
    private String estado;
    @NotBlank(message = "O preenchimento do logradouro do paciente é obrigatório!")
    private String logradouro;
    @NotNull(message = "O preenchimento do número de residência do paciente é obrigatório!")
    private Integer numero;
    private String complemento;
    @NotBlank(message = "O preenchimento do bairro do paciente é obrigatório!")
    private String bairro;
    private String pontoReferencia;
}
