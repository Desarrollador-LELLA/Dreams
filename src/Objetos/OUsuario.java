/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author TOULON-NOTE
 */
public class OUsuario {
    //ATRIBUTOS
    private int Id = 0;
    private String Nombre = "";
    private String Apellidos = "";
    private String Username = "";
    private String Clave = "";
    private boolean Estado = false;
    
    //CONSTRUCTORES
    public OUsuario() { }
    
    public OUsuario(int id, String nombre, String apellidos, String username, String clave, boolean estado) {
        Id = id;
        Nombre = nombre;
        Apellidos = apellidos;
        Username = username;
        Clave = clave;
        Estado = estado;
    }
    
    //PROPIEDADES
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
    
    //METODOS
    
}
