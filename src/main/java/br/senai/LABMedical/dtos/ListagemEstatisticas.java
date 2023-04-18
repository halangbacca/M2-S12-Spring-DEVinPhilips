package br.senai.LABMedical.dtos;

import lombok.Data;

@Data
public class ListagemEstatisticas {
    Integer pacientes;
    Integer exames;
    Integer consultas;
}
