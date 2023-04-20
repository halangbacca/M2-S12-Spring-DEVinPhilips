package br.senai.LABMedical.dtos;

import jakarta.validation.constraints.NotBlank;

public record AtualizaConsultas(
        @NotBlank(message = "O preenchimento do motivo da consulta é obrigatória!")
        String motivo,
        @NotBlank(message = "O preenchimento da descrição da consulta é obrigatória!")
        String descricao,
        @NotBlank(message = "O preenchimento da medicação receitada é obrigatória!")
        String medicacao,
        @NotBlank(message = "O preenchimento da dosagem e precauções da medicação receitada são obrigatórias!")
        String dosagem) {
}
