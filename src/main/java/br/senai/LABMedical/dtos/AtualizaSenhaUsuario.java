package br.senai.LABMedical.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AtualizaSenhaUsuario(
        @NotBlank(message = "O preenchimento da senha é obrigatória!")
        @Size(min = 8, message = "A senha deve possuir pelo menos 8 caracteres alfanuméricos!")
        String senha) {
}
