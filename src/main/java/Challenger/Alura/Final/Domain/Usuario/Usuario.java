package Challenger.Alura.Final.Domain.Usuario;

import Challenger.Alura.Final.Domain.Perfil.Perfil;
import jakarta.persistence.*;

@Table(name = "usuario")
@Entity(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String usuario;

    @ManyToOne
    private Perfil perfil;


}
