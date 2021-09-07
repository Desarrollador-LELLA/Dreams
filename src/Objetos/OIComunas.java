/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Usuario
 */
//para sumar valores de las otras tablas
public class OIComunas {
    private String nombre;
    private String pack;   
    private int cantidad;
    private int valor ;

    public OIComunas() {
    }

    public OIComunas(String nombre, String pack, int cantidad, int valor) {
        this.nombre = nombre;
        this.pack = pack;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    
    
    

    
    
}
