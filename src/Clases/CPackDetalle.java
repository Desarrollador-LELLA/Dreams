/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Objetos.OArticulos;
import Objetos.OError;
import Objetos.OPackDetalle;

/**
 *
 * @author TOULON-NOTE
 */
public class CPackDetalle extends OPackDetalle {
    private final String TagCodigoClase = "CPackDetalle - %s";
    private OError Error = new OError();

    public CPackDetalle() {
        super();
    }

    public CPackDetalle(int cantidad, OArticulos articulo) {
        super(cantidad, articulo);
    }

    public OError getError() {
        return Error;
    }
}
