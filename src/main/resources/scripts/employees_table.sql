CREATE TABLE IF NOT EXISTS employees(
    id serial primary key,
    name varchar(255),
    city varchar(50),
    created timestamp
);