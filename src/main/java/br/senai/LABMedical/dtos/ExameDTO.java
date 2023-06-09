package br.senai.LABMedical.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ExameDTO(
        @NotBlank(message = "O preenchimento do nome do exame é obrigatório!")
        String nome,
        @NotNull(message = "O preenchimento da data e hora da realização do exame são obrigatórias!")
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime dataHora,
        @NotBlank(message = "O preenchimento do tipo de exame é obrigatório!")
        String tipo,
        @NotBlank(message = "O preenchimento do laboratório que irá executar o exame é obrigatório!")
        String laboratorio,
        String pdf,
        @NotNull(message = "O preenchimento dos resultados do exame são obrigatórios!")
        String resultados,
        @NotNull(message = "O preenchimento do ID do paciente é obrigatório!")
        Long paciente_id,
        @NotNull(message = "O preenchimento do ID do médico é obrigatório!")
        Long usuario_id) {
}
