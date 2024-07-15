create table topico (
    id bigint primary key,
    titulo varchar(100) not null,
    mensagem varchar(255) not null,
    data_criacao timestamp not null default current_timestamp,
    status varchar(100) not null,
    autor_id bigint not null,
    curso_id bigint not null,
    constraint fk_topico_autor_id foreign key(autor_id) references usuario(id),
    constraint fk_topico_curso_id foreign key(curso_id) references curso(id)
);