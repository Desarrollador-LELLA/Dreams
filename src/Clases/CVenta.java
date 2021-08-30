/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Objetos.OBanco;
import Objetos.OCliente;
import Objetos.OComuna;
import Objetos.OError;
import Objetos.OEstadoVenta;
import Objetos.OPack;
import Objetos.OVenta;

/**
 *
 * @author TOULON-NOTE
 */
public class CVenta extends OVenta {
    private final String TagCodigoClase = "CVenta - %s";
    private OError Error = new OError();

    public CVenta() {
    }

    public CVenta(int id, int total, String fechaVenta, String fechaTrasferencia, int codigoTrasferencia, String nombreDestinatario, String apellidoDestinatario, String direccionDestinatario, int telefonoDestinatario, String fechaEntrega, String horaEntregaInicial, String horaEntregaFinal, String saludoTexto, int cantidad, OCliente cliente, OPack pack, OBanco banco, OComuna comuna, OEstadoVenta estadoVenta) {
        super(id, total, fechaVenta, fechaTrasferencia, codigoTrasferencia, nombreDestinatario, apellidoDestinatario, direccionDestinatario, telefonoDestinatario, fechaEntrega, horaEntregaInicial, horaEntregaFinal, saludoTexto, cantidad, cliente, pack, banco, comuna, estadoVenta);
    }

    public OError getError() {
        return Error;
    }
    
    
}
