package Challenger.Alura.Final.Domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topico")
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime data_criacao;
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
        this.data_criacao = LocalDateTime.now();
        this.status = "Não resolvido";
        this.curso = curso;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getData_criacao() {
        return data_criacao;
    }

    public String getStatus() {
        return status;
    }

    public Curso getCurso() {
        return curso;
    }

    public Usuario getAutor() {
        return autor;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }
}
