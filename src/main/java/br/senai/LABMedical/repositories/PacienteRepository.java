package br.senai.LABMedical.repositories;

import br.senai.LABMedical.dtos.ListagemPacientes;
import br.senai.LABMedical.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    List<ListagemPacientes> findByNomeContainingIgnoreCase(String nome);
}
