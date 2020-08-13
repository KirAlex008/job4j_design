
create table items (
   id serial primary key,
   name varchar(2000)
);


insert into items (name) values ('Item_1');
insert into items (name) values ('Item_2');
insert into items (name) values ('Item_3');

create table users (
   id serial primary key,
   name varchar(2000),
   item_id int references items
);

insert into users(name, item_id) values ('User_1', 1);
insert into users(name, item_id) values ('User_2', 2);
insert into users(name, item_id) values ('User_3', 3);

create table roles (
   id serial primary key,
   name varchar(2000),
   user_id int references users
);

insert into roles(name, user_id) values ('Role_1', 1);
insert into roles(name, user_id) values ('Role_2', 1);
insert into roles(name, user_id) values ('Role_3', 2);
insert into roles(name, user_id) values ('Role_1', 2);
insert into roles(name, user_id) values ('Role_2', 3);
insert into roles(name, user_id) values ('Role_3', 3);

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
	name varchar(2000)
);

insert into commentss(name) values ('Comment_1');
insert into commentss(name) values ('Comment_2');
insert into commentss(name) values ('Comment_3');

create table items_commentss (
	item_id int references items,
	comment_id int references commentss
);

insert into items_commentss(item_id, comment_id) values (1, 1);
insert into items_commentss(item_id, comment_id) values (1, 2);
insert into items_commentss(item_id, comment_id) values (1, 3);

create table attachments (
	id serial primary key,
	name varchar(2000)
);

insert into attachments (name) values ('Attachment_1');
insert into attachments (name) values ('Attachment_2');
insert into attachments (name) values ('Attachment_3');

create table items_attachments (
	id serial primary key,
	item_id int references items,
	attachment_id int references attachments
);

insert into items_attachments(item_id, attachment_id) values (2, 1);
insert into items_attachments(item_id, attachment_id) values (2, 2);
insert into items_attachments(item_id, attachment_id) values (2, 3);

create table states (
	id serial primary key,
	name varchar(2000),
	item_id int references items
);

insert into states (name, item_id) values ('State_1', 2);
insert into states (name, item_id) values ('State_2', 2);
insert into states (name, item_id) values ('State_3', 2);

create table category (
	id serial primary key,
	name varchar(2000),
	item_id int references items
);

insert into category (name, item_id) values ('Category_1', 1);
insert into category (name, item_id) values ('Category_2', 1);
insert into category (name, item_id) values ('Category_3', 1);
