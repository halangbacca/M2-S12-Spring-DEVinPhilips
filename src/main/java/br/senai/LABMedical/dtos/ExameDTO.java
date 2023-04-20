package br.senai.LABMedical.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ExameDTO {
    @NotBlank(message = "O preenchimento do nome do exame é obrigatório!")
    private String nome;
    @NotBlank(message = "O preenchimento da data e hora do exame são obrigatórias!")
    private String dataHora;
    @NotBlank(message = "O preenchimento do tipo de exame é obrigatório!")
    private String tipo;
    @NotBlank(message = "O preenchimento do laboratório que irá executar o exame é obrigatório!")
    private String laboratorio;
    private String pdf;
    @NotBlank(message = "O preenchimento dos resultados do exame são obrigatórios!")
    private String resultados;
}
