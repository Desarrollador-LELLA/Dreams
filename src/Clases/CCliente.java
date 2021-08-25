/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Objetos.OCanales;
import Objetos.OCliente;
import Objetos.OError;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOULON-NOTE
 */
public class CCliente extends OCliente {
    //ATRIBUTOS
    private OError Error = new OError();
    private final String TagCodigoClase = "CCLIENTE - %s";

    //CONSTRUCTORES
    public CCliente() {
        super();
    }

    public CCliente(int _id, String _rut, String _nombre, String _apellido, String _direccion, String _correo, int _telefono, boolean _estado, OCanales _canal) {
        super(_id, _rut, _nombre, _apellido, _direccion, _correo, _telefono, _estado, _canal);
    }

    //PROPIEDADES
    public OError getError() {
        return Error;
    }
    
    //METODOS
    public OError BuscaRut() {
        boolean encuentra = false;
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        CMysqlHelp Sql = new CMysqlHelp();
        OCliente cliente = new OCliente();
        Error = Sql.Conectar();
        if (Error.isConfirma()) {
            try {
                //sql = "SELECT * FROM cliente CL, canal CA WHERE CL.CAN_ID_CANAL = CA.CAN_ID_CANAL";
                //sql = "SELECT * FROM cliente, canal WHERE cliente.CAN_ID_CANAL = canal.CAN_ID_CANAL";
                Preparando = Sql.getCon().prepareStatement("SELECT CL.CLI_ID_CLIENTE, CL.CLI_RUT, CL.CLI_NOMBRE, CL.CLI_APELLIDO"
                        + ", CL.CLI_DIRECCION, CL.CLI_CORREO, CL.CLI_TELEFONO, CL.CLI_ESTADO, CA.CAN_ID_CANAL, CA.CAN_NOMBRE"
                        + ", CA.CAN_ESTADO FROM cliente CL INNER JOIN canal CA ON CL.CAN_ID_CANAL = CA.CAN_ID_CANAL WHERE CL.CLI_RUT = ?");
                Preparando.setString(1, this.getRut());
                Resultado = Preparando.executeQuery();

                while (Resultado.next()) {
                    OCanales canal = new OCanales(Resultado.getInt(9), Resultado.getString(10), Resultado.getBoolean(11));
                    cliente = new OCliente(Resultado.getInt(1), Resultado.getString(2), Resultado.getString(3), Resultado.getString(4),
                            Resultado.getString(5), Resultado.getString(6), Resultado.getInt(7), Resultado.getBoolean(8), canal);
                    encuentra = true;
                }
                if(encuentra){
                    if(cliente.isEstado()){
                        Error = new OError(String.format(TagCodigoClase, 10), "Cliente Existe y esta Activo", cliente, true);
                    }
                    else{
                        Error = new OError(String.format(TagCodigoClase, 10), "Cliente Existe y esta Desactivado. Desea Activarlo?", cliente, false);
                    }
                }
                else{
                    Error = new OError(String.format(TagCodigoClase, 10), "Cliente NO Existe. Desea Agregarlo?", cliente, false);
                }
                Resultado.close();
                Preparando.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                Error = new OError(String.format(TagCodigoClase, 11), String.format("<html>%s (Codigo %s)</html>", ex, String.format(TagCodigoClase, 11)), null, false);
            } finally {
                Sql.Desconectar();
            }
        }
        return Error;
    }
}
