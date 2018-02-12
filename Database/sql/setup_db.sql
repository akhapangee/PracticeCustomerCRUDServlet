create database customer;

use customer;

create table customers (
	id int primary key auto_increment,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	email varchar(20),
	contact varchar(30),
	status tinyint
	);

insert into customers (
	first_name,
	last_name,
	email,
	contact,
	status
	)
values (
	'Akhilesh',
	'Khapangee',
	'akhafkj@gmail.com',
	'9853343434',
	1
	);
