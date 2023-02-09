Create procedure P_ReadUserById(In _Id varchar(200))
select IdUsers,FirstName,LastName,Email,Phone,IdCc from tbl_users 
where Id = _Id