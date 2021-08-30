/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosTablas;

import Objetos.OPackDetalle;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author TOULON-NOTE
 */
public class MTVentaPackDeta implements TableModel {
    
    private List<OPackDetalle> PacksDetalle;
    
    public MTVentaPackDeta(List<OPackDetalle> PacksDetalle){
        this.PacksDetalle = PacksDetalle;
    }

    public List<OPackDetalle> getOPackDetalle() {
        return PacksDetalle;
    }
    
    @Override
    public int getRowCount() {
        return PacksDetalle.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String NombreColumna = null;
        switch(columnIndex){
            case 0:
                NombreColumna = "Cantidad";
                break;
            case 1:
                NombreColumna = "Nombre";
                break;
        }
        
        return NombreColumna;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        /**Class Tipo = null;
        switch(columnIndex){
            case 0:
                Tipo = String.class;
                break;
            case 1:
                Tipo = String.class;
                break;
            case 2:
                Tipo = String.class;
                break;
            case 3:
                Tipo = Boolean.class;
                break;
        }**/
        
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String Valor = null;
        switch(columnIndex){
            case 0:
                Valor = String.valueOf(PacksDetalle.get(rowIndex).getCantidad());
                break;
            case 1:
                Valor = PacksDetalle.get(rowIndex).getArticulo().getDescripcion();
                break;
        }
        
        return Valor;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //Usuarios.set(rowIndex, (OUsuario)aValue);
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        //To change body of generated methods, choose Tools | Templates.
    }
}
