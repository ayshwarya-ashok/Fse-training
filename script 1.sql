
create table employees
(
    eid int,
    ename varchar(30),
    ephone bigint,
    officeCode mediumint,
    department varchar(30)
);
create database xyz_db;
use xyz_db;
create table employees_xyz
(
    em_id int primary key,
    em_first_name varchar(30),
    em_last_name varchar(30),
    em_dateofbirth date,
    em_salary mediumint,
    em_department varchar(30),
    em_de_id int,
    foreign key em_de_fk(em_de_id) references employees_xyz(em_de_id)
);
create table department_xyz
(
    em_de_id int primary key,
    address varchar(20),
    city varchar(50),
    pincode int,
    contact_number bigint
);
select * from department_xyz;
DROP DATABASE country_db;
