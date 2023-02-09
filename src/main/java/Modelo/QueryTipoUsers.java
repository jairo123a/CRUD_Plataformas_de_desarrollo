/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JAIRO
 */
public class QueryTipoUsers extends ConexionBd{
   
      public ResultSet selectTipo(Rol rol) throws SQLException
    {   
        PreparedStatement Ps = null;
        Connection con = GetConexion();                   
        String Query = "call P_SelectUserType(?)";   
        Ps = con.prepareStatement(Query);  
        Ps.setInt(1,rol.getIdRol());
         ResultSet resultado=Ps.executeQuery();
           if(resultado.next()){
            return resultado;
           }else{
               return resultado;
    }   
    }
}
