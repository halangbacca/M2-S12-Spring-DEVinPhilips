package br.senai.LABMedical.models;

import br.senai.LABMedical.dtos.ExameDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exames")
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "data_hora")
    private LocalDateTime dataHora;
    private String tipo;
    private String laboratorio;
    private String pdf;
    private String resultados;
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.EAGER)
    private Paciente paciente;

    public Exame(ExameDTO exameDTO) {
        this.nome = exameDTO.nome();
        this.dataHora = exameDTO.dataHora();
        this.tipo = exameDTO.tipo();
        this.laboratorio = exameDTO.laboratorio();
        this.pdf = exameDTO.pdf();
        this.resultados = exameDTO.resultados();
        this.usuario = new Usuario(exameDTO.usuario_id());
        this.paciente = new Paciente(exameDTO.paciente_id());
    }

}
