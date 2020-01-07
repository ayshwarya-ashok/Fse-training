create database employeeDB;
use employeeDB;
create table employee(
    em_id int primary key,
    em_name varchar(30),
    em_date_of_birth date,
    em_salary mediumint
);
select * from employee;
delete from employee where em_id = 2;