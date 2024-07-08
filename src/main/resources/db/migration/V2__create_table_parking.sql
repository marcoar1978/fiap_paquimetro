

 create table parking
 (
     ticketNumber uuid       not null PRIMARY KEY,
     type          char(3)    not null,
     startTime       timestamp  not null,
     endTime         timestamp,
     value         decimal(6, 2),
     driver_id int not null,
     vehicle_id int not null,

     FOREIGN KEY (driver_id) REFERENCES driver(id),
     FOREIGN KEY (vehicle_id) REFERENCES vehicle(id)
 );