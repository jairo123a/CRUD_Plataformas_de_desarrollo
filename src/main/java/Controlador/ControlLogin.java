


 package Controlador;

import Modelo.QueryLogin;
import Modelo.QueryTabla;
import Modelo.QueryTipoUsers;
import java.awt.event.ActionListener;
import Modelo.QueryUsers;
import Modelo.Usuario;
 import Modelo.Rol;
import com.mycompany.semana2.Frm_Usuarios;
import com.mycompany.semana2.Login;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author jairo
 */
public class ControlLogin implements ActionListener{
    
    private QueryLogin queriesLogin;
    private Usuario users;
    private Login login;
    private Frm_Usuarios form;
    private QueryTabla queriesTabla;
    private QueryTipoUsers querytTipoUsers;
    private Rol rol;
    public ControlLogin(QueryLogin Queries, Usuario Users ,Login login,Frm_Usuarios form,QueryTabla queriesTabla,QueryTipoUsers querytTipoUsers,Rol rol){
        this.queriesLogin= Queries;
        this.users = Users;
        this.login=login;
        this.form=form;
        this.queriesTabla=queriesTabla;
        this.querytTipoUsers=querytTipoUsers;
        this.rol=rol;
        this.login.jButton1.addActionListener(this);    
    }
    public ControlLogin(Usuario user, QueryLogin queryLogin, Login login) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login.jButton1){
         if(login.jTextField1.getText().length()>0 &&(login.jTextField2.getText().length()>0)){
            try {      
                users.setEmail(login.jTextField2.getText());
                users.setPassword(login.jTextField1.getText());
                ResultSet resultado= queriesLogin.LoginUsers(users);
                
                try {
                    if(resultado.getRow()>0){
                        System.out.println("pasa por aca");
                    int idRol= resultado.getInt("tipoId");
                           form.setVisible(true);
                            System.out.println("pasa por aca");
                         Usuario user = new Usuario();
                         QueryUsers query= new QueryUsers();
                           ControlUser controlUser=new ControlUser(query, user, form,queriesTabla,querytTipoUsers,rol,idRol);
                    }else{
                      JOptionPane.showMessageDialog(null, "este usuario no se encuentra registrado");
                         }  
                } catch (SQLException ex) {                  
                }        
            } catch (SQLException ex) {
                Logger.getLogger(ControlUser.class.getName()).log(Level.SEVERE, null, ex); 
            }     
        }else{
                 JOptionPane.showMessageDialog(null, "Debe ingresar todos los datos");
            }    
        
        
        }
        
            
    }

/**
 *
 * @author JAIRO
 */
}