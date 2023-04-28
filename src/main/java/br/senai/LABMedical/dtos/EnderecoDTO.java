package br.senai.LABMedical.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoDTO(
        @NotBlank(message = "O preenchimento do CEP do paciente é obrigatório!")
        String cep,
        @NotBlank(message = "O preenchimento da cidade do paciente é obrigatória!")
        String cidade,
        @NotBlank(message = "O preenchimento do estado do paciente é obrigatório!")
        String estado,
        @NotBlank(message = "O preenchimento do logradouro do paciente é obrigatório!")
        String logradouro,
        @NotNull(message = "O preenchimento do número de residência do paciente é obrigatório!")
        Integer numero,
        String complemento,
        @NotBlank(message = "O preenchimento do bairro do paciente é obrigatório!")
        String bairro,
        String pontoReferencia
) {
}
