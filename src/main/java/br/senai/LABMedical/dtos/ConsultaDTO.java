package br.senai.LABMedical.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConsultaDTO {
    @NotBlank(message = "O preenchimento do motivo da consulta é obrigatória!")
    private String motivo;
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDateTime dataHora;
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
