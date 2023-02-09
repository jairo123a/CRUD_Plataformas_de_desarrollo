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
public class QueryTabla extends ConexionBd{
    
   public ResultSet selectTable() throws SQLException
    { System.out.print("llega");
        PreparedStatement Ps = null;
        Connection con = GetConexion();                   
        String Query = "call P_ReadTable()";   
        Ps = con.prepareStatement(Query);  
         ResultSet resultado=Ps.executeQuery();
           if(resultado.next()){
            return resultado;
           }else{
               return resultado;
           }
    }
    
}
