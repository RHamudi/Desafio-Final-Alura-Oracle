package Challenger.Alura.Final.DTO;

import Challenger.Alura.Final.Domain.Topico;

import java.time.LocalDateTime;

public record DadosRepostaTopico (
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String status,
        String nomeCurso,
        String nomeAutor
){
    public DadosRepostaTopico(Topico topico){
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getData_criacao(),
                topico.getStatus(),
                topico.getCurso().getNome(),
                topico.getAutor().getNome());
    }
}
