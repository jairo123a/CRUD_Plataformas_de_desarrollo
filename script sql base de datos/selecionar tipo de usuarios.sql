SELECT * FROM bd_crud.tbl_users;

Create procedure P_SelectUserType(_tipoId int)
select Proinsetar,ProConsultar,ProActualizar,ProBorrar  from tbl_Roles
where idRol = _tipoId
