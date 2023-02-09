/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jairo
 */
public class ConexionBd {
    
    private final String user = "admin";
    private final String pass = "Miercolesenlatarde1*";
    private final String url = "jdbc:mysql://localhost:3306/BD_Crud";
    private Connection connection = null;
            
public Connection GetConexion() {
System.out.println("Conectando…");

try{
    connection = DriverManager.getConnection(url, user, pass);
    
System.out.println("Conectado!!");
 /// Resto del codigo aqui
}catch(SQLException e){
System.out.println(e.getMessage());
}
return connection;
}
}
