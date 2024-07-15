package Challenger.Alura.Final.Domain.Resposta;

import Challenger.Alura.Final.Domain.Topico.Topico;
import Challenger.Alura.Final.Domain.Usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "resposta")
@Entity(name = "Resposta")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;

    @ManyToOne
    private Topico topico;

    private LocalDateTime dataCriacao;

    @ManyToOne
    private Usuario autor;
    private Boolean solucao;
}
