/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.Date;

/**
 *
 * @author TOULON-NOTE
 */
public class OVenta {
    //ATRIBUTOS
    private int id;
    private int total;
    private Date fechaVenta;
    private Date fechaTrasferencia;
    private int codigoTrasferencia;
    private String nombreDestinatario;
    private String apellidoDestinatario;
    private String direccionDestinatario;
    private int telefonoDestinatario;
    private Date fechaEntrega;
    private String horaEntregaInicial;
    private String horaEntregaFinal;
    private String saludoTexto;
    private int cantidad;
    
    private OCliente cliente;
    //private OPack pack;
    private OBanco banco;
    private OComuna comuna;
    //private OEstadoVenta estadoVenta;
}
