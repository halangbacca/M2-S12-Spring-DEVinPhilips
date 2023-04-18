package br.senai.LABMedical.dtos;

import br.senai.LABMedical.models.Endereco;
import br.senai.LABMedical.models.EstadoCivil;
import br.senai.LABMedical.models.Paciente;

public record ListagemPacientes(Long id, String nome, String genero, String dataNascimento, String cpf, String rg,
                                EstadoCivil estadoCivil, String telefone, String email, String naturalidade,
                                String alergias, String cuidadosEspecificos, String contatoDeEmergencia,
                                String convenio, String numeroConvenio, String validadeConvenio, Endereco endereco) {

    public ListagemPacientes(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getGenero(), paciente.getDataNascimento(), paciente.getCpf(), paciente.getRg(), paciente.getEstadoCivil(), paciente.getTelefone(), paciente.getEmail(), paciente.getNaturalidade(), paciente.getAlergias(), paciente.getCuidadosEspecificos(), paciente.getContatoDeEmergencia(), paciente.getConvenio(), paciente.getNumeroConvenio(), paciente.getValidadeConvenio(), paciente.getEndereco());
    }

}
