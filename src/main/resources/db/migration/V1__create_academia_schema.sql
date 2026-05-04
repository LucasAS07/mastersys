
CREATE TABLE alunos(
                       id bigserial primary key,
                       nome varchar(150) not null ,
                       data_nascimento date,
                       sexo varchar(1) check ( sexo in ('M','F') ),
                       telefone varchar(30),
                       celular varchar(30),
                       email varchar(150),
                       observacao text,
                       endereco varchar(150),
                       numero varchar(20),
                       complemento varchar(100),
                       bairro varchar(100),
                       cidade varchar(100),
                       estado varchar(2),
                       cep varchar(20),
                       criado_em timestamp not null default current_timestamp,
                       atualizado_em timestamp
);

create table modalidades(
                            id bigserial primary key ,
                            nome varchar(100) not null unique ,
                            ativa boolean not null default true
);

create table graduacoes(
                           id bigserial primary key ,
                           modalidade_id bigint not null references modalidades(id),
                           nome varchar(100) not null,
                           unique (modalidade_id, nome)
);

create table planos(
                       id bigserial primary key ,
                       modalidade_id bigint not null references modalidades(id),
                       nome varchar(100) not null,
                       valor_mensal numeric(10,2) not null check ( valor_mensal >= 0),
                       ativo boolean not null default true,
                       unique (modalidade_id,nome)
);

create table matricula(
                          id bigserial primary key,
                          aluno_id bigint not null references alunos(id),
                          data_matricula date not null default current_date,
                          dia_vencimento integer not null check ( dia_vencimento between 1 and 31),
                          data_encerramento date,
                          status varchar(20) not null default 'ATIVA',
                          check ( status in ('ATIVA', 'ENCERRADA', 'CANCELADA') )
);

create table matricula_modalidade(
                                     id bigserial primary key ,
                                     matricula_id bigint not null references matricula(id),
                                     modalidade_id bigint not null references modalidades(id),
                                     graduacao_id bigint not null references graduacoes(id),
                                     plano_id bigint not null references planos(id),
                                     data_inicio date not null default current_date,
                                     data_fim date,
                                     unique (matricula_id, modalidade_id)
);


create table faturas_matriculas(
                                   id bigserial primary key ,
                                   matricula_id bigint not null references matricula(id),
                                   data_vencimento date not null ,
                                   valor numeric(10,2) not null check ( valor >= 0 ),
                                   data_pagamento timestamp,
                                   data_cancelamento date,
                                   status varchar(20) not null default 'ABERTA',
                                   check ( status in ('ABERTA', 'PAGA', 'CANCELADA', 'VENCIDA') ),
                                   unique (matricula_id,data_vencimento)
);

create table assiduidade(
                            id bigserial primary key ,
                            matricula_id bigint not null references matricula(id),
                            data_entrada timestamp not null default current_timestamp,
                            data_saida timestamp
);