package br.senai.LABMedical.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizaConsulta(
        @NotBlank(message = "O preenchimento do motivo da consulta é obrigatória!")
        String motivo,
        @NotBlank(message = "O preenchimento da descrição da consulta é obrigatória!")
        String descricao,
        @NotBlank(message = "O preenchimento da medicação receitada é obrigatória!")
        String medicacao,
        @NotBlank(message = "O preenchimento da dosagem e precauções da medicação receitada são obrigatórias!")
        String dosagem,
        @NotNull(message = "O preenchimento do ID do paciente é obrigatório!")
        Long paciente_id,
        @NotNull(message = "O preenchimento do ID do médico é obrigatório!")
        Long usuario_id) {
}
