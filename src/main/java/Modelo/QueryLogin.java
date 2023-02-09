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
public class QueryLogin extends ConexionBd{
     public ResultSet LoginUsers(Usuario user) throws SQLException
    {   
        System.out.println(user.getPassword());
        PreparedStatement Ps = null;
        Connection con = GetConexion();                   
        String Query = "call P_LoginUser(?,?)";   
        Ps = con.prepareStatement(Query);  
        Ps.setString(1,user.getEmail());
         Ps.setString(2,user.getPassword());
         ResultSet resultado=Ps.executeQuery();
           if(resultado.next()){
            return resultado;
           }else{
               return resultado;
           }
    }
    
    
}
