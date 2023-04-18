package br.senai.LABMedical.controllers;

import br.senai.LABMedical.dtos.ListagemEstatisticas;
import br.senai.LABMedical.services.EstatisticaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estatisticas")
public class EstatisticasController {
    private final EstatisticaService service;

    public EstatisticasController(EstatisticaService service) {
        this.service = service;
    }

    @GetMapping
    public ListagemEstatisticas estatisticas(ListagemEstatisticas estatisticas) {
        return service.estatisticas(estatisticas);
    }

}
