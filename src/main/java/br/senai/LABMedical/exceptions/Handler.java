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
    public ResponseEntity<String> trataErro404NotFound(EntityNotFoundException exception) {
        if (exception.getMessage().contains("Endereço")) {
            return ResponseEntity.status(404).body("O ID do endereço informado não foi encontrado no banco de dados!");
        } else if (exception.getMessage().contains("Paciente")) {
            return ResponseEntity.status(404).body("O ID do paciente informado não foi encontrado no banco de dados!");
        } else if (exception.getMessage().contains("Usuário")) {
            return ResponseEntity.status(404).body("O ID do usuário informado não foi encontrado no banco de dados!");
        } else if (exception.getMessage().contains("Exame")) {
            return ResponseEntity.status(404).body("O ID do exame informado não foi encontrado no banco de dados!");
        } else if (exception.getMessage().contains("Consulta")) {
            return ResponseEntity.status(404).body("O ID da consulta informada não foi encontrada no banco de dados!");
        }
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> trataErro400ConstraintViolation(SQLIntegrityConstraintViolationException exception) {
        if (exception.getMessage().contains("Duplicate")) {
            return ResponseEntity.status(409).body("Este CPF já está cadastrado!");
        } else if (exception.getMessage().contains("exames")) {
            return ResponseEntity.badRequest().body("Não é possível deletar este paciente, pois este possui exames cadastrados!");
        } else if (exception.getMessage().contains("consultas")) {
            return ResponseEntity.badRequest().body("Não é possível deletar este paciente, pois este possui consultas cadastradas!");
        } else if (exception.getMessage().contains("enderecos")) {
            return ResponseEntity.badRequest().body("O ID do endereço informado não foi encontrado no banco de dados!");
        }
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> trataErro400BadRequest(HttpMessageNotReadableException exception) {
        if (exception.getMessage().contains("java.time.LocalDateTime")) {
            return ResponseEntity.badRequest().body("Formato de data/hora inválidos!");
        } else if (exception.getMessage().contains("java.time.LocalDate")) {
            return ResponseEntity.badRequest().body("Formato de data inválida!");
        } else if (exception.getMessage().contains("Especialidade")) {
            return ResponseEntity.badRequest().body("Especialidade médica incorreta!");
        } else if (exception.getMessage().contains("EstadoCivil")) {
            return ResponseEntity.badRequest().body("Estado Civil incorreto!");
        } else if (exception.getMessage().contains("Paciente")) {
            return ResponseEntity.badRequest().body("O ID do paciente informado não foi encontrado no banco de dados!");
        } else if (exception.getMessage().contains("Usuário")) {
            return ResponseEntity.badRequest().body("O ID do usuário informado não foi encontrado no banco de dados!");
        } else if (exception.getMessage().contains("Endereço")) {
            return ResponseEntity.badRequest().body("O ID do endereço informado não foi encontrado no banco de dados!");
        } else if (exception.getMessage().contains("Data")) {
            return ResponseEntity.badRequest().body("Data e hora não podem ser alteradas!");
        } else if (exception.getMessage().contains("RG")) {
            return ResponseEntity.badRequest().body("O RG do usuário não pode ser alterado!");
        } else if (exception.getMessage().contains("CPF")) {
            return ResponseEntity.badRequest().body("O CPF do usuário não pode ser alterado!");
        } else if (exception.getMessage().contains("senha")) {
            return ResponseEntity.badRequest().body("A senha do usuário não pode ser alterada!");
        }
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Exceptions>> trataErro400Constraints(MethodArgumentNotValidException exception) {
        List<FieldError> erros = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(Exceptions::new).toList());
    }

}
