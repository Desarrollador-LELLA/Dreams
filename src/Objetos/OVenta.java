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
    private String fechaVenta;
    private String fechaTrasferencia;
    private int codigoTrasferencia;
    private String nombreDestinatario;
    private String apellidoDestinatario;
    private String direccionDestinatario;
    private int telefonoDestinatario;
    private String fechaEntrega;
    private String horaEntregaInicial;
    private String horaEntregaFinal;
    private String saludoTexto;
    private int cantidad;
    
    private OCliente cliente;
    private OPack pack;
    private OBanco banco;
    private OComuna comuna;
    private OEstadoVenta estadoVenta;

    public OVenta() {
    }

    public OVenta(int id, int total, String fechaVenta, String fechaTrasferencia, int codigoTrasferencia, String nombreDestinatario, String apellidoDestinatario, String direccionDestinatario, int telefonoDestinatario, String fechaEntrega, String horaEntregaInicial, String horaEntregaFinal, String saludoTexto, int cantidad, OCliente cliente, OPack pack, OBanco banco, OComuna comuna, OEstadoVenta estadoVenta) {
        this.id = id;
        this.total = total;
        this.fechaVenta = fechaVenta;
        this.fechaTrasferencia = fechaTrasferencia;
        this.codigoTrasferencia = codigoTrasferencia;
        this.nombreDestinatario = nombreDestinatario;
        this.apellidoDestinatario = apellidoDestinatario;
        this.direccionDestinatario = direccionDestinatario;
        this.telefonoDestinatario = telefonoDestinatario;
        this.fechaEntrega = fechaEntrega;
        this.horaEntregaInicial = horaEntregaInicial;
        this.horaEntregaFinal = horaEntregaFinal;
        this.saludoTexto = saludoTexto;
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.pack = pack;
        this.banco = banco;
        this.comuna = comuna;
        this.estadoVenta = estadoVenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getFechaTrasferencia() {
        return fechaTrasferencia;
    }

    public void setFechaTrasferencia(String fechaTrasferencia) {
        this.fechaTrasferencia = fechaTrasferencia;
    }

    public int getCodigoTrasferencia() {
        return codigoTrasferencia;
    }

    public void setCodigoTrasferencia(int codigoTrasferencia) {
        this.codigoTrasferencia = codigoTrasferencia;
    }

    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public void setNombreDestinatario(String nombreDestinatario) {
        this.nombreDestinatario = nombreDestinatario;
    }

    public String getApellidoDestinatario() {
        return apellidoDestinatario;
    }

    public void setApellidoDestinatario(String apellidoDestinatario) {
        this.apellidoDestinatario = apellidoDestinatario;
    }

    public String getDireccionDestinatario() {
        return direccionDestinatario;
    }

    public void setDireccionDestinatario(String direccionDestinatario) {
        this.direccionDestinatario = direccionDestinatario;
    }

    public int getTelefonoDestinatario() {
        return telefonoDestinatario;
    }

    public void setTelefonoDestinatario(int telefonoDestinatario) {
        this.telefonoDestinatario = telefonoDestinatario;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getHoraEntregaInicial() {
        return horaEntregaInicial;
    }

    public void setHoraEntregaInicial(String horaEntregaInicial) {
        this.horaEntregaInicial = horaEntregaInicial;
    }

    public String getHoraEntregaFinal() {
        return horaEntregaFinal;
    }

    public void setHoraEntregaFinal(String horaEntregaFinal) {
        this.horaEntregaFinal = horaEntregaFinal;
    }

    public String getSaludoTexto() {
        return saludoTexto;
    }

    public void setSaludoTexto(String saludoTexto) {
        this.saludoTexto = saludoTexto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public OCliente getCliente() {
        return cliente;
    }

    public void setCliente(OCliente cliente) {
        this.cliente = cliente;
    }

    public OPack getPack() {
        return pack;
    }

    public void setPack(OPack pack) {
        this.pack = pack;
    }

    public OBanco getBanco() {
        return banco;
    }

    public void setBanco(OBanco banco) {
        this.banco = banco;
    }

    public OComuna getComuna() {
        return comuna;
    }

    public void setComuna(OComuna comuna) {
        this.comuna = comuna;
    }

    public OEstadoVenta getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(OEstadoVenta estadoVenta) {
        this.estadoVenta = estadoVenta;
    }
    
    public int getTotalT(){
        return cantidad * Integer.valueOf(pack.getCosto());
    }
}
