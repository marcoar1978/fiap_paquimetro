create table driver
(
    id             serial      not null,
    name           varchar(60) not null,
    cpf            varchar(11) not null,
    street         varchar(60) not null,
    number         varchar(10) not null,
    complement     varchar(60),
    district       varchar(30) not null,
    city           varchar(30) not null,
    state          varchar(2)  not null,
    postal_code    varchar(8)  not null,
    phone_number   varchar(20) not null,
    email          varchar(60) not null,
    payment_method varchar(12) not null,
    constraint driver_pk primary key (id)
);
create table vehicle
(
    id            serial      not null,
    model         varchar(30) not null,
    license_plate varchar(10) not null,
    driver_id     int         not null,
    constraint vehicle_pk primary key (id),
    foreign key (driver_id) references driver (id)
);

create table parking
(
    ticketnumber   uuid        not null primary key,
    type           char(3)     not null,
    starttime      timestamp   not null,
    endtime        timestamp,
    value          decimal(6, 2),
    status         varchar(30) not null,
    payment_method varchar(12),
    payment_auth   varchar(100),
    driver_id      int         not null,
    vehicle_id     int         not null,

    foreign key (driver_id) references driver (id),
    foreign key (vehicle_id) references vehicle (id)
);

create table configuration
(
    id            int primary key,
    rate_per_hour decimal(10, 2) not null,
    minimum_time  integer        not null,
    currency      varchar(3)     not null
);

insert into configuration (id, rate_per_hour, minimum_time, currency)
values (1, 5.00, 1, 'BRL');
