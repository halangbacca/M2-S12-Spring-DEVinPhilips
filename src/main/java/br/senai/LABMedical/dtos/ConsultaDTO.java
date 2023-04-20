package br.senai.LABMedical.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ConsultaDTO {
    @NotBlank(message = "O preenchimento do motivo da consulta é obrigatória!")
    private String motivo;
    @NotBlank(message = "O preenchimento da data e hora da consulta são obrigatórias!")
    private String dataHora;
    @NotBlank(message = "O preenchimento da descrição da consulta é obrigatória!")
    private String descricao;
    @NotBlank(message = "O preenchimento da medicação receitada é obrigatória!")
    private String medicacao;
    @NotBlank(message = "O preenchimento da dosagem e precauções da medicação receitada são obrigatórias!")
    private String dosagem;
    @NotNull(message = "O preenchimento do ID do paciente é obrigatório!")
    private Long paciente_id;
    @NotNull(message = "O preenchimento do ID do médico é obrigatório!")
    private Long usuario_id;
}
