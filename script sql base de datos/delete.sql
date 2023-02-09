CREATE PROCEDURE p_DeleteByIdUser (IN _IdUsers int)
DELETE FROM Tbl_Users
 WHERE IdUsers = _IdUsers