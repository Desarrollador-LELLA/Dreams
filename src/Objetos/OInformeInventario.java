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
public class OInformeInventario {
    private OArticulos Articulo;
    private OCatArticulos categoria;

    public OInformeInventario(OArticulos Articulo, OCatArticulos categoria) {
        this.Articulo = Articulo;
        this.categoria = categoria;
    }


    public OArticulos getArticulo() {
        return Articulo;
    }

    public OCatArticulos getCategoria() {
        return categoria;
    }

    public void setArticulo(OArticulos Articulo) {
        this.Articulo = Articulo;
    }

    public void setCategoria(OCatArticulos categoria) {
        this.categoria = categoria;
    }
    
}
