/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author TOULON
 */
public class OCliente {
    private int id = 0;
    private String rut = "";
    private String nombre = "";
    private String apellido = "";
    private String direccion = "";
    private String correo = "";
    private int telefono = 0;
    private boolean estado = false;
    
    private OCanales canal = new OCanales();

    public OCliente() {
    }
    
    public OCliente(int _id, String _rut, String _nombre, String _apellido, String _direccion, String _correo, int _telefono, boolean _estado, OCanales _canal) {
        id = _id;
        rut = _rut;
        nombre = _nombre;
        apellido = _apellido;
        direccion = _direccion;
        correo = _correo;
        telefono = _telefono;
        estado = _estado;
        canal = _canal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public OCanales getCanal() {
        return canal;
    }

    public void setCanal(OCanales canal) {
        this.canal = canal;
    }
}
