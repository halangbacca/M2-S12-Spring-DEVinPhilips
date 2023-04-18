package br.senai.LABMedical.services;

import br.senai.LABMedical.dtos.ListagemConsultas;
import br.senai.LABMedical.dtos.ListagemEstatisticas;
import br.senai.LABMedical.dtos.ListagemExames;
import br.senai.LABMedical.dtos.ListagemPacientes;
import br.senai.LABMedical.repositories.ConsultaRepository;
import br.senai.LABMedical.repositories.ExameRepository;
import br.senai.LABMedical.repositories.PacienteRepository;
import org.springframework.stereotype.Service;

@Service
public class EstatisticaService {
    private final PacienteRepository pacienteRepository;

    private final ConsultaRepository consultaRepository;

    private final ExameRepository exameRepository;

    public EstatisticaService(PacienteRepository pacienteRepository, ConsultaRepository consultaRepository, ExameRepository exameRepository) {
        this.pacienteRepository = pacienteRepository;
        this.consultaRepository = consultaRepository;
        this.exameRepository = exameRepository;
    }

    public ListagemEstatisticas estatisticas(ListagemEstatisticas estatisticas) {
        estatisticas.setPacientes(pacienteRepository.findAll().stream().map(ListagemPacientes::new).toList().size());
        estatisticas.setConsultas(consultaRepository.findAll().stream().map(ListagemConsultas::new).toList().size());
        estatisticas.setExames(exameRepository.findAll().stream().map(ListagemExames::new).toList().size());
        return estatisticas;
    }

}
