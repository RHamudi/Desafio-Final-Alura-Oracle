package Challenger.Alura.Final.Domain.Perfil;

import jakarta.persistence.*;

@Table(name = "perfil")
@Entity(name = "Perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
}
