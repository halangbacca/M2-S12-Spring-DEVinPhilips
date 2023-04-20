package br.senai.LABMedical.dtos;

import org.springframework.validation.FieldError;

public record Exceptions(String campo, String mensagem) {

    public Exceptions(FieldError fieldError) {
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }

}
