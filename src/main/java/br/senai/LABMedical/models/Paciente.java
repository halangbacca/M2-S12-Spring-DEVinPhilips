package br.senai.LABMedical.models;

import br.senai.LABMedical.dtos.PacienteDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pacientes")
public class Paciente extends Pessoa {
    private String alergias;
    private String cuidadosEspecificos;
    @Column(name = "contato_de_emergencia")
    private String contatoDeEmergencia;
    private String convenio;
    @Column(name = "numero_convenio")
    private String numeroConvenio;
    @Column(name = "validade_convenio")
    private LocalDate validadeConvenio;
    @ManyToOne(fetch = FetchType.EAGER)
    private Endereco endereco;

    public Paciente(PacienteDTO pacienteDTO) {
        super.setNome(pacienteDTO.nome());
        super.setGenero(pacienteDTO.genero());
        super.setDataNascimento(pacienteDTO.dataNascimento());
        super.setCpf(pacienteDTO.cpf());
        super.setRg(pacienteDTO.rg());
        super.setEstadoCivil(pacienteDTO.estadoCivil());
        super.setTelefone(pacienteDTO.telefone());
        super.setEmail(pacienteDTO.email());
        super.setNaturalidade(pacienteDTO.naturalidade());
        this.alergias = pacienteDTO.alergias();
        this.cuidadosEspecificos = pacienteDTO.cuidadosEspecificos();
        this.contatoDeEmergencia = pacienteDTO.contatoDeEmergencia();
        this.convenio = pacienteDTO.convenio();
        this.numeroConvenio = pacienteDTO.numeroConvenio();
        this.validadeConvenio = pacienteDTO.validadeConvenio();
        this.endereco = new Endereco(pacienteDTO.endereco_id());
    }

    public Paciente(Long pacienteId) {
        super.setId(pacienteId);
    }

}
