package br.senai.LABMedical.dtos;

import jakarta.validation.constraints.NotBlank;

public record AtualizaExames(
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String tipo,
        @NotBlank
        String laboratorio,
        @NotBlank
        String pdf,
        @NotBlank
        String resultados) {
}
