package br.senai.LABMedical.repositories;

import br.senai.LABMedical.models.Exame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {
}
