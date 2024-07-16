alter table driver
    add payment_method varchar(12) not null;

alter table parking
    add payment_method varchar(12),
    add payment_auth varchar(100);

