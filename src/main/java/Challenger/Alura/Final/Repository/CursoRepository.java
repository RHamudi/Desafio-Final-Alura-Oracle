package Challenger.Alura.Final.Repository;

import Challenger.Alura.Final.Domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
