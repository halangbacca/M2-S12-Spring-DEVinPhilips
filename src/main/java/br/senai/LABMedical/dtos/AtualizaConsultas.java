package br.senai.LABMedical.dtos;

import jakarta.validation.constraints.NotBlank;

public record AtualizaConsultas(
        Long id,
        @NotBlank
        String motivo,
        @NotBlank
        String descricao,
        @NotBlank
        String medicacao,
        @NotBlank
        String dosagem) {
}
