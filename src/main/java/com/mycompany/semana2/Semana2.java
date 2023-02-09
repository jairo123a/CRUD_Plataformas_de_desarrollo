/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana2;

import Controlador.ControlLogin;
import Modelo.QueryLogin;
import Modelo.QueryTabla;
import Modelo.Usuario;
import Modelo.QueryTipoUsers;
import Modelo.Rol;

/**
 *
 * @author 1022979657
 */
public class Semana2 {

    public static void main(String[] args) {
        Usuario user = new Usuario();
        QueryLogin queryLogin= new QueryLogin();
        Frm_Usuarios frmUsuario = new Frm_Usuarios();
        QueryTabla queryTabla=new QueryTabla();
        QueryTipoUsers querytTipoUsers=new QueryTipoUsers();
        Rol rol=new Rol();
        Login login=new Login();
        ControlLogin controlLogin=new ControlLogin(queryLogin,user,login,frmUsuario,queryTabla,querytTipoUsers,rol);
        login.setVisible(true);
       // frmUsuario.setVisible(true);
    }
}
