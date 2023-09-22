create sequence hibernate_sequence start 1 increment 1;

create table users(
                      id uuid primary key,
                      username varchar,
                      password text
);

