package br.com.losystem.mastersys.repository;

import br.com.losystem.mastersys.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
