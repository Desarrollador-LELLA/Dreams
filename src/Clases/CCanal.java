/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Objetos.OCanales;
import Objetos.OError;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class CCanal extends OCanales{
    private OError Error = new OError();
    private String TagCodigoClase = "CCanal - %s";

    public CCanal() {
    super();
    }

    public CCanal(int id, String nombre, Boolean estado) {
        super(id, nombre, estado);
    }
    
    public OError Agregar(){
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("INSERT INTO Canal(BAN_DESCRIPCION, BAN_ESTADO) VALUES(?,?)");
                Preparando.setString(1, this.getNombre());
                Preparando.setBoolean(2, this.getEstado());
        
                
                if(!Preparando.execute()){
                    Error = new OError(String.format(TagCodigoClase, 1), "Banco Agregado Correctamente", null, true);
                }
                else{
                    Error = new OError(String.format(TagCodigoClase, 2), "El Banco no fue Agregado", null, false);
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
