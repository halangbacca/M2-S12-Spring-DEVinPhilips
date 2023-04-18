package br.senai.LABMedical.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ConsultaDTO {
    @NotBlank
    private String motivo;
    @NotBlank
    private String dataHora;
    @NotBlank
    private String descricao;
    @NotBlank
    private String medicacao;
    @NotBlank
    private String dosagem;
}
