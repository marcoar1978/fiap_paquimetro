create table condutor
(
);
create table veiculo
(
);


create table estacionamento
(
    numero_ticket uuid       not null,
    tipo          char(3)    not null,
    entrada       timestamp  not null,
    saida         timestamp,
    valor         decimal(6, 2),
    placa         varchar(8) not null,
    condutor_id int not null,
    constraint estacionamento_pk primary key (numero_ticket)
);