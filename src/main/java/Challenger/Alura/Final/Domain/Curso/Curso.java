package Challenger.Alura.Final.Domain.Curso;

import jakarta.persistence.*;

@Table(name = "curso")
@Entity(name = "Curso")

public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria;
}
