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
 * @author jairo
 */
public class QueryUsers extends ConexionBd{
    
    public boolean InsertUsers(Usuario user)
    {
        PreparedStatement Ps = null;
        Connection con = GetConexion();    
        String Query = "call P_InsertNewUser(?,?,?,?,?,?,?,?)";   
        try {Ps = con.prepareStatement(Query);         
        Ps.setString(1, user.getCedula());
        Ps.setString(2, user.getNombre());
        Ps.setString(3, user.getApellido());
        Ps.setString(4, user.getEmail());
        Ps.setString(5, user.getPhone());
        Ps.setString(6, user.getPassword());
        Ps.setString(7, user.getTipo());
        Ps.setInt   (8,  user.getIdTipo());
        Ps.execute();
        return true;
        }catch(SQLException e){
        
            System.out.println(e);return false;
        }
    }
    
    
    
    
      public ResultSet selectUsers(Usuario user) throws SQLException
    {   
        System.out.println(user.getCedula());
        PreparedStatement Ps = null;
        Connection con = GetConexion();                   
        String Query = "call P_ReadUserById(?)";   
        Ps = con.prepareStatement(Query);  
        Ps.setString(1,user.getCedula());
         ResultSet resultado=Ps.executeQuery();
           if(resultado.next()){
            return resultado;
           }else{
               return resultado;
           }
    }
       public boolean updateUser(Usuario user)
    {
        PreparedStatement Ps = null;
        Connection con = GetConexion();    
        String Query = "call P_UpdateUser(?,?,?,?,?,?,?)";   
        try {Ps = con.prepareStatement(Query);         
        Ps.setString(1, user.getCedula());
        Ps.setString(2, user.getNombre());
        Ps.setString(3, user.getApellido());
        Ps.setString(4, user.getEmail());
        Ps.setString(5, user.getPhone());
        Ps.setString(6, user.getPassword());
        Ps.setString(7, user.getTipo());
        Ps.execute();
        return true;
        }catch(SQLException e){
        System.out.println(e.getMessage());
        return false;
        }
    }
    
      
      
      
     public Boolean  deleteUsers(Usuario user) throws SQLException
    {   
        System.out.println(user.getCedula());
        PreparedStatement Ps = null;
        Connection con = GetConexion();                   
        String Query = "call p_DeleteByIdUser(?)";   
        Ps = con.prepareStatement(Query);  
        Ps.setString(1,user.getCedula());
         Ps.execute();
         return true;
    } 
}
