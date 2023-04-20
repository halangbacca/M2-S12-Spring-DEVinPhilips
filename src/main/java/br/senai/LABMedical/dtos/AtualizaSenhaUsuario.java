package br.senai.LABMedical.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record AtualizaSenhaUsuario(
        @NotBlank(message = "O preenchimento da senha é obrigatória!")
        @Min(value = 8, message = "A senha deve possuir pelo menos 8 caracteres alfanuméricos!")
        String senha) {
}
