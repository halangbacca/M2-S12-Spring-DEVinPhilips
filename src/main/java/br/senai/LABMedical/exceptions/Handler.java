package br.senai.LABMedical.exceptions;

import br.senai.LABMedical.dtos.Exceptions;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestControllerAdvice
public class Handler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> trataErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> trataErro400() {
        return ResponseEntity.badRequest().body("Não é possível deletar este paciente, pois este possui exames e/ou consultas cadastradas!");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Exceptions>> trataErro400(MethodArgumentNotValidException exception) {
        List<FieldError> erros = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(Exceptions::new).toList());
    }

}