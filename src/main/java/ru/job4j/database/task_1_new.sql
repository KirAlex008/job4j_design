
create table category (
	id serial primary key,
	name varchar(2000)
);

insert into category (name) values ('Category_1');
insert into category (name) values ('Category_2');
insert into category (name) values ('Category_3');

create table states (
	id serial primary key,
	name varchar(2000)
);

insert into states (name) values ('State_1');
insert into states (name) values ('State_2');
insert into states (name) values ('State_3');

create table roles (
   id serial primary key,
   name varchar(2000)
);

insert into roles(name) values ('Role_1');
insert into roles(name) values ('Role_2');
insert into roles(name) values ('Role_3');


create table users (
   id serial primary key,
   name varchar(2000),
   role_id int references roles
);

insert into users(name, role_id) values ('User_1', 1);
insert into users(name, role_id) values ('User_2', 2);
insert into users(name, role_id) values ('User_3', 3);

create table items (
   id serial primary key,
   name varchar(2000),
   user_id int references users,
   category_id int references category,
   state_id int references states
);

insert into items (name, user_id, category_id, state_id) values ('Item_1', 1, 2, 3);
insert into items (name, user_id, category_id, state_id) values ('Item_2', 2, 1, 2);
insert into items (name, user_id, category_id, state_id) values ('Item_3', 3, 3, 1);

create table rules (
   id serial primary key,
   name varchar(2000)
);

insert into rules(name) values ('Rule_1');
insert into rules(name) values ('Rule_2');
insert into rules(name) values ('Rule_3');

create table roles_rules (
   id serial primary key,
   role_id int references roles,
   rule_id int references rules
);

insert into roles_rules (role_id, rule_id) values (1, 1);
insert into roles_rules (role_id, rule_id) values (1, 2);
insert into roles_rules (role_id, rule_id) values (2, 3);
insert into roles_rules (role_id, rule_id) values (2, 1);
insert into roles_rules (role_id, rule_id) values (3, 2);
insert into roles_rules (role_id, rule_id) values (3, 3);

create table commentss (
	id serial primary key,
	name varchar(2000),
	item_id int references items
);

insert into commentss(name, item_id) values ('Comment_1', 1);
insert into commentss(name, item_id) values ('Comment_2', 2);
insert into commentss(name, item_id) values ('Comment_3', 3);

create table attachments (
	id serial primary key,
	name varchar(2000),
	item_id int references items
);

insert into attachments (name, item_id) values ('Attachment_1', 1);
insert into attachments (name, item_id) values ('Attachment_2', 2);
insert into attachments (name, item_id) values ('Attachment_3', 3);

