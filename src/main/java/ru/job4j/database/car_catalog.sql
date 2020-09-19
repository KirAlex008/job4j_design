create table body (
                      id serial primary key,
                      name varchar(200)
);

create table engine (
                        id serial primary key,
                        name varchar(200)
);

create table transmission (
                              id serial primary key,
                              name varchar(200)
);

create table car (
                     id serial primary key,
                     name varchar(200),
                     body_id integer references body,
                     engine_id integer references engine,
                     transmission_id integer references transmission
);

insert into body(name) values ('body_1');
insert into body(name) values ('body_2');
insert into body(name) values ('body_3');
insert into body(name) values ('body_4');

insert into engine(name) values ('engine_1');
insert into engine(name) values ('engine_2');
insert into engine(name) values ('engine_3');
insert into engine(name) values ('engine_4');

insert into transmission(name) values ('transmission_1');
insert into transmission(name) values ('transmission_2');
insert into transmission(name) values ('transmission_3');
insert into transmission(name) values ('transmission_4');

insert into car(name, body_id, engine_id, transmission_id) values ('car_1', 2, 3, 4);
insert into car(name, body_id, engine_id, transmission_id) values ('car_2', 3, 4, 1);
insert into car(name, body_id, engine_id, transmission_id) values ('car_3', 4, 1, 2);


select c.name, b.name, e.name, t.name from car as c
    left outer join body as b on b.id = c.body_id
    join engine as e on e.id = c.engine_id
    join transmission as t on t.id = c.transmission_id;

select  b.name from body as b left outer join car as c on b.id = c.body_id where c.body_id is null;

select  e.name from engine as e left outer join car as c on e.id = c.engine_id where c.engine_id is null;

select  t.name from transmission as t left outer join car as c on t.id = c.transmission_id where c.transmission_id is null;




