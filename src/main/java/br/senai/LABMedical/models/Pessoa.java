package br.senai.LABMedical.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@MappedSuperclass
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String genero;
    @Column(name = "data_nascimento")
    private String dataNascimento;
    private String cpf;
    private String rg;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_civil")
    private EstadoCivil estadoCivil;
    private String telefone;
    private String email;
    private String naturalidade;
}
