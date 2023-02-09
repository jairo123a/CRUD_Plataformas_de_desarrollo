create procedure P_InsertNewUser(IN _IdCc varchar(200),IN _FirstName varchar(200),IN _LastName varchar(200), In _Email Varchar(200),IN _Phone varchar(200),IN _Id varchar(200))
insert into tbl_users(_IdCc,FirstName,LastName,Email,Phone)
Values(IdCc,_FirstName,_LastName,_Email,_Phone);


