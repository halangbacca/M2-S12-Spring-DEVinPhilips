package br.senai.LABMedical.exceptions;

import br.senai.LABMedical.dtos.Exceptions;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestControllerAdvice
public class Handler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> trataErro404NotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> trataErro400SQL(SQLIntegrityConstraintViolationException exception) {
        if (exception.getMessage().contains("Duplicate")) {
            return ResponseEntity.badRequest().body("Este CPF já está cadastrado!");
        } else if (exception.getMessage().contains("foreign key")) {
            return ResponseEntity.badRequest().body("Não é possível deletar este paciente, pois este possui exames e/ou consultas cadastradas!");
        }
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> trataErro400EstadoCivil(HttpMessageNotReadableException exception) {
        if (exception.getMessage().contains("java.time.LocalDateTime")) {
            return ResponseEntity.badRequest().body("Formato de data/hora inválidos!");
        } else if (exception.getMessage().contains("java.time.LocalDate")) {
            return ResponseEntity.badRequest().body("Formato de data inválida!");
        } else if (exception.getMessage().contains("Especialidade")) {
            return ResponseEntity.badRequest().body("Especialidade médica incorreta!");
        } else if (exception.getMessage().contains("EstadoCivil")) {
            return ResponseEntity.badRequest().body("Estado Civil incorreto!");
        }
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Exceptions>> trataErro400Validators(MethodArgumentNotValidException exception) {
        List<FieldError> erros = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(Exceptions::new).toList());
    }

}
