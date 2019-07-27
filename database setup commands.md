

create database cdacteamprojectdb;
use cdacteamprojectdb;
create table Employee(empid int(5) not null,empname varchar(20) not null,pwd varchar(20) not null,mobile varchar(10),primary key(empid));
create table Admin(adminid int(5) not null,pwd varchar(10) not null,primary key(adminid));
alter table Employee add column money int(5) not null;
alter table Employee add column status int(1) not null;
alter table employee add column blocked bool not null;
create table item(itemno int(5) not null,itemname varchar(20) not null,price int(5) not null,status bool not null,primary key(itemno));
create table orders(orderid int(5) not null auto_increment,itemnames varchar(100) not null,orderprice int(4) not null,empid int(5) not null,empname varchar(50),date date not null,primary key(orderid));
alter table orders add constraint fk_empid foreign key(empid) references employee(empid);
alter table orders add column status int(1) not null;
