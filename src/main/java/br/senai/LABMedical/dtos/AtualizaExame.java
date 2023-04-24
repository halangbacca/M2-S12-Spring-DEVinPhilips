package br.senai.LABMedical.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AtualizaExame(
        @NotBlank(message = "O preenchimento do nome do exame é obrigatório!")
        String nome,
        @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
        LocalDateTime dataHora,
        @NotBlank(message = "O preenchimento do tipo de exame é obrigatório!")
        String tipo,
        @NotBlank(message = "O preenchimento do laboratório que irá executar o exame é obrigatório!")
        String laboratorio,
        String pdf,
        @NotBlank(message = "O preenchimento dos resultados do exame são obrigatórios!")
        String resultados,
        @NotNull(message = "O preenchimento do ID do paciente é obrigatório!")
        Long paciente_id,
        @NotNull(message = "O preenchimento do ID do médico é obrigatório!")
        Long usuario_id) {
}
