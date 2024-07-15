package Challenger.Alura.Final.Domain.Topico;

import Challenger.Alura.Final.Domain.Curso.Curso;
import Challenger.Alura.Final.Domain.Resposta.Resposta;
import Challenger.Alura.Final.Domain.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topico")
@Entity(name = "Topico")
@NoArgsConstructor
@AllArgsConstructor
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    private Curso curso;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario autor;

    @OneToMany(mappedBy = "topico")
    private List<Resposta> respostas;

    public Topico(String titulo, String mensagem, Curso curso, Usuario autor) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = LocalDateTime.now();
        this.status = "Não resolvido";
        this.curso = curso;
        this.autor = autor;
    }
}
