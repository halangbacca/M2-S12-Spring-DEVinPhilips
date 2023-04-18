package br.senai.LABMedical.repositories;

import br.senai.LABMedical.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
