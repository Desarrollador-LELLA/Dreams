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
    private String rsocial;
    private String nombre;
    private String apellido;
    private int telefono;
    private String correo;
    private String direccion;
    private String rut;
    private boolean estado;

    public OProveedor() {
    }

    public OProveedor(int id, String rsocial, String nombre, String apellido, int telefono, String correo, String direccion, String rut, boolean estado) {
        this.id = id;
        this.rsocial = rsocial;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.rut = rut;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getRsocial() {
        return rsocial;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
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

    public String getRut() {
        return rut;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRsocial(String rsocial) {
        this.rsocial = rsocial;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    

      
}
