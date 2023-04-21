package br.senai.LABMedical.dtos;

import jakarta.validation.constraints.NotBlank;

public record AtualizaExame(
        @NotBlank(message = "O preenchimento do nome do exame é obrigatório!")
        String nome,
        @NotBlank(message = "O preenchimento do tipo de exame é obrigatório!")
        String tipo,
        @NotBlank(message = "O preenchimento do laboratório que irá executar o exame é obrigatório!")
        String laboratorio,
        String pdf,
        @NotBlank(message = "O preenchimento dos resultados do exame são obrigatórios!")
        String resultados) {
}
