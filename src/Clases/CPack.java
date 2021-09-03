/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Objetos.OArticulos;
import Objetos.OError;
import Objetos.OPack;
import Objetos.OPackDetalle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CPack extends OPack {

    private OError Error = new OError();
    private final String TagCodigoClase = "CPack - %s";
  
    
    
    public CPack() {
        super();
    }

    public CPack(int id, String nombre, String costo, int stock, boolean estado, List<OPackDetalle> packDetalles) {
        super(id, nombre, costo, stock, estado, packDetalles);
    }

    public CPack(int id, String nombre, int stock, boolean b) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public CPack(int id, String nombre, String costo, int stock, boolean b) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<OPack> Listar() {
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        List<OPack> Listado = new ArrayList();
        CMysqlHelp Sql = new CMysqlHelp();
        OError Error = Sql.Conectar();
        if (Error.isConfirma()) {
            try {
                Preparando = Sql.getCon().prepareStatement("SELECT * FROM Pack");
                Resultado = Preparando.executeQuery();
                PreparedStatement Preparando1 = null;
                ResultSet Resultado1 = null;
                
                
              
                while (Resultado.next()) {
                int packd = Resultado.getInt(1);
                List<OPackDetalle> detalles = new ArrayList();
                Preparando1 = Sql.getCon().prepareStatement("SELECT * FROM Pack_has_Articulo P inner join Articulo A on P.ART_ID_ARTICULO = A.ART_ID_ARTICULO WHERE P.PCK_ID_PACK = ?");
                Preparando1.setInt(1, Resultado.getInt(1));
                Resultado1 = Preparando1.executeQuery();
                    while (Resultado1.next()) {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        String date = sdf.format(Resultado1.getDate(7));
                        OArticulos packArticulo = new OArticulos(Resultado1.getInt(4), Resultado1.getString(5), Resultado1.getInt(6), date, Resultado1.getBoolean(8), null);
                        OPackDetalle packDetalle1 = new OPackDetalle(Resultado1.getInt(3), packArticulo);
                        detalles.add(packDetalle1);
                    }
                    Listado.add(new OPack(Resultado.getInt(1), Resultado.getString(2), Resultado.getString(3), Resultado.getInt(4), Resultado.getBoolean(5), detalles));
                }
                Error = new OError(String.format(TagCodigoClase, 10), "Consulta Realizada Corectamente", null, true);

                Resultado.close();
                Preparando.close();
                if (Preparando1 != null) {
                    Resultado1.close();
                    Preparando1.close();
                    
                }
                
                
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                Error = new OError(String.format(TagCodigoClase, 11), String.format("<html>%s (Codigo %s)</html>", ex, String.format(TagCodigoClase, 11)), null, false);
            } finally {
                Sql.Desconectar();
            }
        }
        return Listado;
    }

    public OError Editar() {
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if (Error.isConfirma()) {
            try {
                Preparando = Sql.getCon().prepareStatement("UPDATE Pack SET PCK_NOMBRE = ?, PCK_COSTO = ?, PCK_STOCK = ?, PCK_ESTADO = ? WHERE PCK_ID_PACK = ?");
                Preparando.setString(1, this.getNombre());
                Preparando.setString(2, this.getCosto());
                Preparando.setInt(3, this.getStock());
                Preparando.setBoolean(4, this.isEstado());
                Preparando.setInt(5, this.getId());

                if (!Preparando.execute()) {
                    Error = new OError(String.format(TagCodigoClase, 4), "Pack editado Correctamente", null, true);
                } else {
                    Error = new OError(String.format(TagCodigoClase, 5), "Pack no Editado", null, false);
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

    public OError Insertar() {
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if (Error.isConfirma()) {
            try {
                Preparando = Sql.getCon().prepareStatement("INSERT INTO Pack(PCK_NOMBRE, PCK_COSTO, PCK_STOCK, PCK_ESTADO) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                Preparando.setString(1, this.getNombre());
                Preparando.setString(2, this.getCosto());
                Preparando.setInt(3, this.getStock());
                Preparando.setBoolean(4, this.isEstado());
                int IdR = Preparando.executeUpdate();
                ResultSet rs = Preparando.getGeneratedKeys();
                PreparedStatement Preparando2 = null;
                if (rs.next()) {
                    
                    for(OPackDetalle det : getPackDetalles()){
                        Preparando2 = Sql.getCon().prepareStatement("INSERT INTO Pack_has_Articulo(PCK_ID_PACK, ART_ID_ARTICULO, CANTIDAD) VALUES(?,?,?)");
                        Preparando2.setInt(1, Integer.valueOf( rs.getString(1)));
                        Preparando2.setInt(2, det.getArticulo().getId());
                        Preparando2.setInt(3, det.getCantidad());
                        Preparando2.execute();
                    }
                }
                Error = new OError(String.format(TagCodigoClase, 1), "Pack Agregado Correctamente", null, true);
                
                rs.close();
                Preparando.close();
                Preparando2.close();
                
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                Error = new OError(String.format(TagCodigoClase, 3), String.format("<html>%s (Codigo %s)</html>", ex, String.format(TagCodigoClase, 3)), null, false);
            } finally {
                Sql.Desconectar();
            }
        }
        return Error;
    }

    public OError Eliminar() {
        PreparedStatement Preparando = null;
        CMysqlHelp Sql = new CMysqlHelp();
        Error = Sql.Conectar();
        if (Error.isConfirma()) {

            try {
                Preparando = Sql.getCon().prepareStatement("UPDATE Pack SET PCK_ESTADO = ? WHERE PCK_ID_PACK = ?");
                Preparando.setBoolean(1, this.isEstado());
                Preparando.setInt(2, this.getId());

                if (!Preparando.execute()) {
                    Error = new OError(String.format(TagCodigoClase, 1), "Pack Desactivado Correctamente", null, true);
                } else {
                    Error = new OError(String.format(TagCodigoClase, 2), "Pack no Agregado", null, false);
                }
                Preparando.close();

            } catch (SQLException e) {
                System.out.println("error" + e);
              //  Error = new OError(String.format(TagCodigoClase, 3), String.format("<html>%s (Codigo %s)</html>", e, String.format(TagCodigoClase, 3)), null, false);

            } finally {
                Sql.Desconectar();
            }
        }
        return Error;
    }

}
