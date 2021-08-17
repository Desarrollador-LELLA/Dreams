/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author rodka
 */
public class OProveedor {
    private int id;
    private String rut;
    private String rsocial;
    private String nombre;
    private int telefono;
    private String correo;
    private String direccion;
    private boolean estado;

    public OProveedor() {
    }

    public OProveedor(int id, String rut, String rsocial, String nombre, int telefono, String Correo, String direccion, boolean estado) {
        this.id = id;
        this.rut = rut;
        this.rsocial = rsocial;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = Correo;
        this.direccion = direccion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getRut() {
        return rut;
    }

    public String getRsocial() {
        return rsocial;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setRsocial(String rsocial) {
        this.rsocial = rsocial;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String Correo) {
        this.correo = Correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    
}
