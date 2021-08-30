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
public class OPackDetalle {
    private int cantidad;
    private OArticulos articulo;

    public OPackDetalle() {
    }

    public OPackDetalle(int cantidad, OArticulos articulo) {
        this.cantidad = cantidad;
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public OArticulos getArticulo() {
        return articulo;
    }

    public void setArticulo(OArticulos articulo) {
        this.articulo = articulo;
    }
}
