/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.QueryTabla;
import Modelo.QueryTipoUsers;
import java.awt.event.ActionListener;
import Modelo.QueryUsers;
import Modelo.Rol;
import Modelo.Usuario;
import com.mycompany.semana2.Frm_Usuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jairo
 */
public final class ControlUser implements KeyListener, ActionListener {
    private QueryUsers queriesUsers;
    private QueryTabla queriesTabla;
    private Usuario users;
    private Frm_Usuarios formUsuarios;
    private QueryTipoUsers querytTipoUsers;
    private Rol rol;
    private int idRol;

    public ControlUser(QueryUsers Queries, Usuario Users, Frm_Usuarios formUsuarios, QueryTabla queriesTabla, QueryTipoUsers querytTipoUsers, Rol rol, int idRol) throws SQLException {
        this.queriesUsers = Queries;
        this.queriesTabla = queriesTabla;
        this.users = Users;
        this.formUsuarios = formUsuarios;
        this.querytTipoUsers = querytTipoUsers;
        this.rol = rol;
        this.idRol = idRol;
        this.formUsuarios.jButton1.addActionListener(this);
        this.formUsuarios.jButton2.addActionListener(this);
        this.formUsuarios.jButton3.addActionListener(this);
        this.formUsuarios.jButton4.addActionListener(this);
        this.formUsuarios.jTextField5.addKeyListener(this);
        try {
            llenarCampos();
            rolesUsuario();
        } catch (SQLException ex) {
            Logger.getLogger(ControlUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void rolesUsuario() throws SQLException {
        rol.setIdRol(idRol);
        System.out.println(idRol);
        ResultSet resultados = this.querytTipoUsers.selectTipo(rol);
        if (resultados.getRow() > 0) {
            {
                String insertar = resultados.getString("Proinsetar");
                String consultar = resultados.getString("ProConsultar");
                String Actualizar = resultados.getString("ProActualizar");
                String borrar = resultados.getString("ProBorrar");
                System.out.println(insertar + consultar + Actualizar + borrar);
                if (insertar.equals("SI")) {
                } else {
                    formUsuarios.jButton1.setEnabled(Boolean.FALSE);
                }
                if (consultar.equals("SI")) {
                } else {
                    formUsuarios.jButton2.setEnabled(Boolean.FALSE);
                }
                if (Actualizar.equals("SI")) {
                } else {
                    formUsuarios.jButton3.setEnabled(Boolean.FALSE);
                }
                if (borrar.equals("SI")) {
                } else {
                    formUsuarios.jButton4.setEnabled(Boolean.FALSE);
                }
            }
        }
    }

    public void llenarCampos() throws SQLException {
        ResultSet resultados = this.queriesTabla.selectTable();
        if (resultados.getRow() > 0) {
            DefaultTableModel dtmModelo = new DefaultTableModel();
            dtmModelo.addColumn("IdCc");
            dtmModelo.addColumn("FirstName");
            dtmModelo.addColumn("LastName");
            dtmModelo.addColumn("Cargo");
            for (int i = 0; i < resultados.getRow(); i++) {
                if (resultados.next()) {
                    String r[] = {resultados.getString("IdCc"), resultados.getString("FirstName"), resultados.getString("LastName"), resultados.getString("TipoUsers")};
                    dtmModelo.addRow(r);
                    formUsuarios.tblUsers.setModel(dtmModelo);
                } else {
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formUsuarios.jButton1) {
            if ((formUsuarios.jTextField1.getText().length() > 0) && (formUsuarios.jTextField2.getText().length() > 0) && (formUsuarios.jTextField3.getText().length() > 0)
                    && (formUsuarios.jTextField4.getText().length() > 0) && (formUsuarios.jTextField6.getText().length() > 0)) {
                users.setCedula(formUsuarios.jTextField1.getText());
                users.setNombre(formUsuarios.jTextField2.getText());
                users.setApellido(formUsuarios.jTextField3.getText());
                users.setEmail(formUsuarios.jTextField4.getText());
                users.setPhone(formUsuarios.jTextField6.getText());
                users.setPassword(formUsuarios.jTextField7.getText());
                users.setTipo((String) formUsuarios.jComboBox1.getSelectedItem());
                int index = formUsuarios.jComboBox1.getSelectedIndex();
                System.out.println(index);
                users.setIdTipo(index);
                if (queriesUsers.InsertUsers(users)) {
                    formUsuarios.jTextField1.setText("");
                    formUsuarios.jTextField2.setText("");
                    formUsuarios.jTextField3.setText("");
                    formUsuarios.jTextField4.setText("");
                    formUsuarios.jTextField6.setText("");
                    formUsuarios.jTextField7.setText("");
                    JOptionPane.showMessageDialog(null, "Guardado Exitosamente");
                } else {
                    System.out.println("Error al Guardar");
                }
            } else {
                JOptionPane.showMessageDialog(null, "debe ingresar todo los datos");
            }
        }

        if (e.getSource() == formUsuarios.jButton2) {
            if (formUsuarios.jTextField5.getText().length() == 0) {
                int index = Integer.parseInt(String.valueOf(formUsuarios.tblUsers.getSelectedRow()));
                formUsuarios.jTextField5.setText(String.valueOf(formUsuarios.tblUsers.getValueAt(index, 0)));
            }
            if (formUsuarios.jTextField5.getText().length() > 0) {
                try {
                    users.setCedula(formUsuarios.jTextField5.getText());
                    ResultSet resultado = queriesUsers.selectUsers(users);
                    try {
                        if (resultado.getRow() > 0) {
                            DefaultTableModel dtmModelo = new DefaultTableModel();
                            dtmModelo.addColumn("IdCc");
                            dtmModelo.addColumn("FirstName");
                            dtmModelo.addColumn("LastName");
                            dtmModelo.addColumn("Email");
                            String a[] = {resultado.getString("IdCc"), resultado.getString("FirstName"), resultado.getString("LastName"), resultado.getString("Email")};
                            dtmModelo.addRow(a);
                            formUsuarios.tblUsers.setModel(dtmModelo);
                            formUsuarios.jTextField1.setText(resultado.getString("IdCc"));
                            formUsuarios.jTextField2.setText(resultado.getString("FirstName"));
                            formUsuarios.jTextField3.setText(resultado.getString("LastName"));
                            formUsuarios.jTextField4.setText(resultado.getString("Email"));
                            formUsuarios.jTextField6.setText(resultado.getString("Phone"));
                            formUsuarios.jTextField7.setText(resultado.getString("pass"));
                            formUsuarios.jComboBox1.setSelectedItem(resultado.getString("TipoUsers"));
                            /*add*/
                        } else {
                            JOptionPane.showMessageDialog(null, "este usuario no se encuentra registrado");
                        }
                    } catch (SQLException ex) {
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ControlUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "debe ingresar un numero de cedula");
            }
        }
        if (e.getSource() == formUsuarios.jButton3) {
            if ((formUsuarios.jTextField1.getText().length() > 0) && (formUsuarios.jTextField2.getText().length() > 0) && (formUsuarios.jTextField3.getText().length() > 0)
                    && (formUsuarios.jTextField4.getText().length() > 0) && (formUsuarios.jTextField6.getText().length() > 0)) {

                users.setCedula(formUsuarios.jTextField1.getText());
                users.setNombre(formUsuarios.jTextField2.getText());
                users.setApellido(formUsuarios.jTextField3.getText());
                users.setEmail(formUsuarios.jTextField4.getText());
                users.setPhone(formUsuarios.jTextField6.getText());
                users.setPassword(formUsuarios.jTextField7.getText());
                users.setTipo((String) formUsuarios.jComboBox1.getSelectedItem());
                if (queriesUsers.updateUser(users)) {
                    formUsuarios.jTextField1.setText("");
                    formUsuarios.jTextField2.setText("");
                    formUsuarios.jTextField3.setText("");
                    formUsuarios.jTextField4.setText("");
                    formUsuarios.jTextField6.setText("");
                    formUsuarios.jTextField7.setText("");
                    JOptionPane.showMessageDialog(null, "datos actualizados correctamente");
                } else {
                    System.out.println("Error al Modifificar");
                }
            } else {
                JOptionPane.showMessageDialog(null, "debe ingresar todos los datos");
            }
        }

        if (e.getSource() == formUsuarios.jButton4) {

            if (formUsuarios.jTextField5.getText().length() > 0) {
                users.setCedula(formUsuarios.jTextField5.getText());
                try {
                    if (queriesUsers.deleteUsers(users)) {
                        JOptionPane.showMessageDialog(null, "datos borrados");
                        formUsuarios.jTextField1.setText("");
                        formUsuarios.jTextField2.setText("");
                        formUsuarios.jTextField3.setText("");
                        formUsuarios.jTextField4.setText("");
                        formUsuarios.jTextField6.setText("");
                    } else {
                        System.out.println("Error al Borrar");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ControlUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "debe ingresar una cedula");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == formUsuarios.jTextField5) {
            if (formUsuarios.jTextField5.getText().length() <= 1) {
                try {
                    llenarCampos();
                    formUsuarios.jTextField1.setText("");
                    formUsuarios.jTextField2.setText("");
                    formUsuarios.jTextField3.setText("");
                    formUsuarios.jTextField4.setText("");
                    formUsuarios.jTextField6.setText("");
                    formUsuarios.jTextField7.setText("");
                } catch (SQLException ex) {
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
