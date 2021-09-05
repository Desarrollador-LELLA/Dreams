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
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    
    public OError Agregar(){
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("INSERT INTO venta(CLI_ID_CLIENTE, PCK_ID_PACK, VTA_TOTAL, VTA_FECHA_VENTA"
                        + ", VTA_NOMBRE_DESTINATARIO, VTA_APELLIDO_DESTINATARIO, VTA_DIRECCION_DESTINATARIO, COM_ID_COMUNA, VTA_TELEFONO_DESTINATARIO"
                        + ", VTA_FECHA_ENTREGA, VTA_HORA_ENTREGA_INICIAL, VTA_HORA_ENTREGA_FINAL, VTA_SALUDO_TEXTO, VTA_CANTIDAD, EST_ID_ESTADO, BAN_ID_BANCO, VTA_FECHA_TRANSFERENCIA"
                        + ", VTA_CODIGO_TRANSFERENCIA) VALUES ("
                        + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                Preparando.setInt(1, this.getCliente().getId());
                Preparando.setInt(2, this.getPack().getId());
                Preparando.setInt(3, this.getTotalT());
                Preparando.setString(4, this.getFechaVenta());
                Preparando.setString(5, this.getNombreDestinatario());
                Preparando.setString(6, this.getApellidoDestinatario());
                Preparando.setString(7, this.getDireccionDestinatario());
                Preparando.setInt(8, this.getComuna().getId());
                Preparando.setInt(9, this.getTelefonoDestinatario());
                Preparando.setString(10, this.getFechaEntrega());
                Preparando.setString(11, this.getHoraEntregaInicial());//revisar
                Preparando.setString(12, this.getHoraEntregaFinal());//revisar
                Preparando.setString(13, this.getSaludoTexto());
                Preparando.setInt(14, this.getCantidad());
                Preparando.setInt(15, this.getEstadoVenta().getId());
                Preparando.setInt(16, this.getBanco().getId());
                Preparando.setString(17, this.getFechaTrasferencia());
                Preparando.setInt(18, this.getCodigoTrasferencia());
                
                if(!Preparando.execute()){
                    Error = new OError(String.format(TagCodigoClase, 1), "Venta Agregada Correctamente", null, true);
                }
                else{
                    Error = new OError(String.format(TagCodigoClase, 2), "La Venta no fue Agregada", null, false);
                }
                Preparando.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                Error = new OError(String.format(TagCodigoClase, 3), String.format("<html>%s (Codigo %s)</html>", ex, String.format(TagCodigoClase, 3)), null, false);
            }
            finally{
                Sql.Desconectar();
            }
        }
        return Error;
    }
}
