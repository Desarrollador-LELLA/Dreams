/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Objetos.OError;
import Objetos.OProveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodka
 */
public class CProveedor extends OProveedor {
    
    private final String TagCodigoClase = "CProveedor - %s";
    private OError Error = new OError();

    public OError getError() {
        return Error;
    }

    public CProveedor() {
        super();
    }

    public CProveedor (int id, String rsocial, String nombre, String apellido, int telefono, String correo, String direccion, String rut, boolean estado) {
        super(id, rsocial, nombre, apellido, telefono, correo, direccion, rut, estado);
    }
    
    
    public List<OProveedor> Listar(){
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        List<OProveedor> Listado = new ArrayList();
        CMysqlHelp Sql = new CMysqlHelp();
        Error  = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("SELECT * FROM Proveedor");
                Resultado = Preparando.executeQuery();
                
                while(Resultado.next()){
                    Listado.add(new OProveedor(Resultado.getInt(1), Resultado.getString(2), Resultado.getString(3),Resultado.getString(4), Resultado.getInt(5), Resultado.getString(6), Resultado.getString(7), Resultado.getString(8),  Resultado.getBoolean(9) ));
                }
                Error = new OError(String.format(TagCodigoClase, 10), "Consulta Realizada Corectamente", null, true);
                
                Resultado.close();
                Preparando.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                Error = new OError(String.format(TagCodigoClase, 11), String.format("<html>%s (Codigo %s)</html>", ex, String.format(TagCodigoClase, 11)), null, false);
            }
            finally{
                Sql.Desconectar();
            }
        }
        return Listado;
    }
    
    
    
    public OError Insertar(){
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("INSERT INTO Proveedor(PRO_RAZON_SOCIAL, PRO_NOMBRE_CONTACTO, PRO_APELLIDO_CONTACTO, PRO_TELEFONO, PRO_CORREO, PRO_DIRECCION, PRO_RUT, PRO_ESTADO) VALUES(?,?,?,?,?,?,?,?)");
                Preparando.setString(1, this.getRsocial());
                Preparando.setString(2, this.getNombre());
                Preparando.setString(3, this.getApellido());
                Preparando.setInt(4, this.getTelefono());
                Preparando.setString(5, this.getCorreo());
                Preparando.setString(6, this.getDireccion());
                Preparando.setString(7, this.getRut());
                Preparando.setBoolean(8, this.isEstado());
        
                
                if(!Preparando.execute()){
                    Error = new OError(String.format(TagCodigoClase, 1), "Proveedor Agregado Correctamente", null, true);
                }
                else{
                    Error = new OError(String.format(TagCodigoClase, 2), "El Proveedor no fue Agregado", null, false);
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
    
    public OError Eliminar(){
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if(Error.isConfirma()){
        
            try{
                Preparando = Sql.getCon().prepareStatement("UPDATE Proveedor SET PRO_ESTADO = ? WHERE PRO_ID_PROVEEDOR = ?");
                Preparando.setBoolean (1,this.isEstado());
                Preparando.setInt(2, this.getId());
                
                if(!Preparando.execute()){
                    Error = new OError(String.format(TagCodigoClase, 1), "Proveedor Desactivada Correctamente", null, true);
                }
                else{
                    Error = new OError(String.format(TagCodigoClase, 2), "La Proveedor no fue Agregado", null, false);
                }
                Preparando.close();
           
            }catch(SQLException e){
                System.out.println("error"+ e);
                //Error = new OError(String.format(TagCodigoClase, 3), String.format("<html>%s (Codigo %s)</html>", e, String.format(TagCodigoClase, 3)), null, false);
      
            }finally{  
                Sql.Desconectar();
            }
        
        }
        return Error;
    }    
    
    public OError Editar(){
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("UPDATE Proveedor SET PRO_RAZON_SOCIAL = ?, PRO_NOMBRE_CONTACTO = ?, PRO_APELLIDO_CONTACTO = ?, PRO_TELEFONO = ?, PRO_CORREO = ?, PRO_DIRECCION = ?,  PRO_ESTADO = ? WHERE PRO_ID_PROVEEDOR = ?");
                Preparando.setString(1, this.getRsocial());
                Preparando.setString(2, this.getNombre());
                Preparando.setString(3, this.getApellido());
                Preparando.setInt(4, this.getTelefono());
                Preparando.setString(5, this.getCorreo());
                Preparando.setString(6, this.getDireccion());
                Preparando.setBoolean(7, this.isEstado());
                Preparando.setInt(8, this.getId());
                
                if(!Preparando.execute()){
                    Error = new OError(String.format(TagCodigoClase, 1), "Comuna Editada Correctamente", null, true);
                    System.out.println(Error.getMensaje());
                }
                else{
                    Error = new OError(String.format(TagCodigoClase, 2), "La Comuna no fue Editado", null, false);
                    System.out.println(Error.getMensaje());
                }
                Preparando.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                Error = new OError(String.format(TagCodigoClase, 6), String.format("<html>%s (Codigo %s)</html>", ex, String.format(TagCodigoClase, 6)), null, false);
            }
            finally{
                Sql.Desconectar();
            }
        }
        return Error;
    }
   
}
