package br.senai.LABMedical.models;

import br.senai.LABMedical.dtos.PacienteDTO;
import jakarta.persistence.*;
import lombok.*;

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
    private String validadeConvenio;
    @ManyToOne
    private Endereco endereco;

    public Paciente(PacienteDTO pacienteDTO) {
        super.setNome(pacienteDTO.getNome());
        super.setGenero(pacienteDTO.getGenero());
        super.setDataNascimento(pacienteDTO.getDataNascimento());
        super.setCpf(pacienteDTO.getCpf());
        super.setRg(pacienteDTO.getRg());
        super.setEstadoCivil(pacienteDTO.getEstadoCivil());
        super.setTelefone(pacienteDTO.getTelefone());
        super.setEmail(pacienteDTO.getEmail());
        super.setNaturalidade(pacienteDTO.getNaturalidade());
        this.alergias = pacienteDTO.getAlergias();
        this.cuidadosEspecificos = pacienteDTO.getCuidadosEspecificos();
        this.contatoDeEmergencia = pacienteDTO.getContatoDeEmergencia();
        this.convenio = pacienteDTO.getConvenio();
        this.numeroConvenio = pacienteDTO.getNumeroConvenio();
        this.validadeConvenio = pacienteDTO.getValidadeConvenio();
        this.endereco = new Endereco(pacienteDTO.getEndereco_id());
    }

    public Paciente(Long pacienteId) {
        super.setId(pacienteId);
    }

}
