package br.senai.LABMedical.dtos;

import br.senai.LABMedical.models.Consulta;

public record ListagemConsultas(Long id, String motivo, String dataHora, String descricao, String medicacao,
                                String dosagem) {

    public ListagemConsultas(Consulta consulta) {
        this(consulta.getId(), consulta.getMotivo(), consulta.getDataHora(), consulta.getDescricao(), consulta.getMedicacao(), consulta.getDosagem());
    }

}
