/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class OPack {

    private int id;
    private String nombre;
    private String costo;
    private int stock;
    private boolean estado;
    private List<OPackDetalle> packDetalles = new ArrayList();

    public OPack() {

    }

    public OPack(int id, String nombre, String costo, int stock, boolean estado, List<OPackDetalle> packDetalles) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
        this.stock = stock;
        this.estado = estado;
        this.packDetalles = packDetalles;
    }

    public List<OPackDetalle> getPackDetalles() {
        return packDetalles;
    }

    public void setPackDetalles(List<OPackDetalle> packDetalles) {
        this.packDetalles = packDetalles;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}