create table driver
(
    id serial not null,
    name varchar(60) not null,
    cpf varchar(11) not null,
    street varchar(60) not null,
    number varchar(10) not null,
    complement varchar(60),
    district varchar(30) not null,
    city varchar(30) not null,
    state varchar(2) not null,
    postal_code varchar(8) not null,
    phone_number varchar(20) not null,
    email varchar(60) not null,
    constraint driver_pk primary key (id)
);
create table vehicle
(
    id serial not null,
    model varchar(30) not null,
    license_plate varchar(10) not null,
    driver_id int not null,
    constraint vehicle_pk primary key (id),
    FOREIGN KEY (driver_id) REFERENCES driver(id)

);


-- create table estacionamento
-- (
--     numero_ticket uuid       not null,
--     tipo          char(3)    not null,
--     entrada       timestamp  not null,
--     saida         timestamp,
--     valor         decimal(6, 2),
--     placa         varchar(8) not null,
--     condutor_id int not null,
--     constraint estacionamento_pk primary key (numero_ticket)
-- );