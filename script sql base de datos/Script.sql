create database BD_Crud;

drop table tbl_Users

USE bd_crud;
CREATE table tbl_Users(
IdUsers int AUTO_INCREMENT,
FirstName varchar(200),
LastsName varchar(200),
Email varchar(200),
Phone varchar(200),
Pass BLOB,
PRIMARY KEY(idUsers)
);

ALTER TABLE tbl_Users add
Id varchar(200);

select * from tbl_Users
