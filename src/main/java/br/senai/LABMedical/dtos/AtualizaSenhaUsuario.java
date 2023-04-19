package br.senai.LABMedical.dtos;

import jakarta.validation.constraints.NotBlank;

public record AtualizaSenhaUsuario(@NotBlank String senha) {
}
