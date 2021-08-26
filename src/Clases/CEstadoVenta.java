
package Clases;

import Objetos.OError;
import Objetos.OEstadoVenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodka
 */
public class CEstadoVenta extends OEstadoVenta {
    
    private final String TagCodigoClase = "CComuna - %s";
    private OError Error = new OError();

    public CEstadoVenta() {
        super();
    }

    public CEstadoVenta(int id, String nombre, boolean estado) {
        super(id, nombre, estado);
    }
    
    
    public List<OEstadoVenta> Listar(){
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        List<OEstadoVenta> Listado = new ArrayList();
        CMysqlHelp Sql = new CMysqlHelp();
        OError Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("SELECT * FROM estado_venta");
                Resultado = Preparando.executeQuery();
                
                while(Resultado.next()){
                    Listado.add(new OEstadoVenta(Resultado.getInt(1), Resultado.getString(2), Resultado.getBoolean(3)));
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
                Preparando = Sql.getCon().prepareStatement("INSERT INTO estado_venta(EST_DESCRIPCION, EST_ESTADO) VALUES(?,?)");
                Preparando.setString(1, this.getNombre());
                Preparando.setBoolean(2, this.getEstado());
        
                
                if(!Preparando.execute()){
                    Error = new OError(String.format(TagCodigoClase, 1), "Estado de venta Agregado Correctamente", null, true);
                }
                else{
                    Error = new OError(String.format(TagCodigoClase, 2), "El Estado de venta no fue Agregado", null, false);
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
                Preparando = Sql.getCon().prepareStatement("UPDATE estado_venta SET EST_ESTADO = ? WHERE EST_ID_ESTADO = ?");
                Preparando.setBoolean (1,this.getEstado());
                Preparando.setInt(2, this.getId());
                
                if(!Preparando.execute()){
                    Error = new OError(String.format(TagCodigoClase, 1), "Estado de Venta Desactivada Correctamente", null, true);
                }
                else{
                    Error = new OError(String.format(TagCodigoClase, 2), "LEstado de Venta no fue Agregado", null, false);
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
    
    public OError Editar() {
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if (Error.isConfirma()) {
            try {
                Preparando = Sql.getCon().prepareStatement("UPDATE estado_venta SET EST_DESCRIPCION = ?, EST_ESTADO = ? WHERE EST_ID_ESTADO  = ?");
                Preparando.setString(1, this.getNombre());
                Preparando.setInt(2, this.getId());

                if (!Preparando.execute()) {
                    Error = new OError(String.format(TagCodigoClase, 4), "Estado de Venta Editado Correctamente", null, true);
                } else {
                    Error = new OError(String.format(TagCodigoClase, 5), "El Estado de Venta no fue Editado", null, false);
                }
                Preparando.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                Error = new OError(String.format(TagCodigoClase, 6), String.format("<html>%s (Codigo %s)</html>", ex, String.format(TagCodigoClase, 6)), null, false);
            } finally {
                Sql.Desconectar();
            }
        }
        return Error;
    }
}
