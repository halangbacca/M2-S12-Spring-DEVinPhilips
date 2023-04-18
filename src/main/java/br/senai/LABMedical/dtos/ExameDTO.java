package br.senai.LABMedical.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ExameDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String dataHora;
    @NotBlank
    private String tipo;
    @NotBlank
    private String laboratorio;
    private String pdf;
    @NotBlank
    private String resultados;
}
