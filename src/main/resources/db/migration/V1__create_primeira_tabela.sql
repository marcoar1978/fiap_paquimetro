CREATE TABLE checkin_estacionamento (
    id bigint not null auto_increment,
    placa varchar(8) not null,
    qde_horas int not null,
    entrada datetime not null,
    saida datetime not null,
    valor decimal(6,2),
    primary key(id)
);