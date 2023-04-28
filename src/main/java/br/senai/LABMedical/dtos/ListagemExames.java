package br.senai.LABMedical.dtos;

import br.senai.LABMedical.models.Exame;
import br.senai.LABMedical.models.Paciente;
import br.senai.LABMedical.models.Usuario;

import java.time.LocalDateTime;

public record ListagemExames(Long id, String nome, LocalDateTime dataHora, String tipo, String laboratorio, String pdf,
                             String resultados, Paciente paciente, Usuario usuario) {

    public ListagemExames(Exame exame) {
        this(exame.getId(), exame.getNome(), exame.getDataHora(), exame.getTipo(), exame.getLaboratorio(), exame.getPdf(), exame.getResultados(), exame.getPaciente(), exame.getUsuario());
    }

}
