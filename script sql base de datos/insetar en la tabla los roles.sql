Create procedure P_ReadTable()
select IdUsers,FirstName,LastName,Email,Phone,IdCc,pass,TipoUsers from tbl_users 


insert into tbl_roles(IdRol,Rol,Proinsetar,ProConsultar,ProActualizar,ProBorrar)
Values(0,'Administrador','SI','SI','SI','SI');


insert into tbl_roles(IdRol,Rol,Proinsetar,ProConsultar,ProActualizar,ProBorrar)
Values(1,'Jefe de tienda','SI','SI','NO','NO');


insert into tbl_roles(IdRol,Rol,Proinsetar,ProConsultar,ProActualizar,ProBorrar)
Values(2,'Tendero','NO','SI','NO','NO');