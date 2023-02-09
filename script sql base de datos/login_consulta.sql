Create procedure P_LoginUser(_Email varchar(200),_pass varchar(200))
select IdUsers,FirstName,LastName,Email,Phone,IdCc,pass,TipoUsers,tipoId from tbl_users 
where Email = _Email and pass=_pass 