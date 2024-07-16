package Challenger.Alura.Final.Repository;

import Challenger.Alura.Final.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
