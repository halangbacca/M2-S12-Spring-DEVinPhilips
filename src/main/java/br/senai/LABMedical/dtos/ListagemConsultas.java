package br.senai.LABMedical.dtos;

import br.senai.LABMedical.models.Consulta;

import java.time.LocalDateTime;

public record ListagemConsultas(Long id, String motivo, LocalDateTime dataHora, String descricao, String medicacao,
                                String dosagem) {

    public ListagemConsultas(Consulta consulta) {
        this(consulta.getId(), consulta.getMotivo(), consulta.getDataHora(), consulta.getDescricao(), consulta.getMedicacao(), consulta.getDosagem());
    }

}
