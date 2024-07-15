create table usuario (
    id bigint primary key,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    senha varchar(255) not null,
    perfil_id bigint not null,
    constraint fk_usuario_perfil_id foreign key(perfil_id) references perfil(id)
);