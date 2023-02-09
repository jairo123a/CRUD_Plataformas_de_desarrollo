create procedure P_UpdateUser(IN _IdCc varchar(200),IN _FirstName varchar(200),IN _LastName varchar(200), In _Email Varchar(200),IN _Phone varchar(200))
update tbl_users
set FirstName= _FirstName,
    LastName=_LastName,
    Email = _Email,
    Phone=_Phone
where IdCc = _IdCc

    
    
