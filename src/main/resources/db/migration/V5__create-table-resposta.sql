create table resposta (
    id bigint primary key,
    mensagem varchar(255) not null,
    topico_id bigint not null,
    data_criacao timestamp not null default current_timestamp,
    autor_id bigint not null,
    solucao boolean not null,
    constraint fk_resposta_topico_id foreign key(topico_id) references topico(id),
    constraint fk_resposta_autor_id foreign key(autor_id) references usuario(id)
);