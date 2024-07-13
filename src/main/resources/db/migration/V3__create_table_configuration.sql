CREATE TABLE configuration (
    id int PRIMARY KEY,
    rate_per_hour DECIMAL(10, 2) NOT NULL,
    minimum_time INTEGER NOT NULL,
    currency VARCHAR(3) NOT NULL
);

INSERT INTO configuration (id, rate_per_hour, minimum_time, currency)
VALUES (1, 5.00, 1, 'BRL');
