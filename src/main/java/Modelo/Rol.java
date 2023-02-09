/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author JAIRO
 */
public class Rol extends ConexionBd{

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getProInsertar() {
        return proInsertar;
    }

    public void setProInsertar(String proInsertar) {
        this.proInsertar = proInsertar;
    }

    public String getProConsultar() {
        return proConsultar;
    }

    public void setProConsultar(String proConsultar) {
        this.proConsultar = proConsultar;
    }

    public String getProActulizar() {
        return proActulizar;
    }

    public void setProActulizar(String proActulizar) {
        this.proActulizar = proActulizar;
    }

    public String getProBorrar() {
        return proBorrar;
    }

    public void setProBorrar(String proBorrar) {
        this.proBorrar = proBorrar;
    }
    private int idRol;
    private String rol;
    private String proInsertar;
    private String proConsultar;
    private String proActulizar;
    private String proBorrar;
}
