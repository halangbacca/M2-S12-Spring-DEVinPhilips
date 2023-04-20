package br.senai.LABMedical.models;

import br.senai.LABMedical.dtos.ConsultaDTO;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "consultas")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String motivo;
    @Column(name = "data_hora")
    private String dataHora;
    private String descricao;
    private String medicacao;
    private String dosagem;
    @OneToOne
    private Usuario usuario;
    @OneToOne
    private Paciente paciente;

    public Consulta(ConsultaDTO consultaDTO) {
        this.motivo = consultaDTO.getMotivo();
        this.dataHora = consultaDTO.getDataHora();
        this.descricao = consultaDTO.getDescricao();
        this.medicacao = consultaDTO.getMedicacao();
        this.dosagem = consultaDTO.getDosagem();
        this.usuario = new Usuario(consultaDTO.getUsuario_id());
        this.paciente = new Paciente(consultaDTO.getPaciente_id());
    }

}
