package Challenger.Alura.Final.Repository;

import Challenger.Alura.Final.Domain.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTitulo(String titulo);
}
