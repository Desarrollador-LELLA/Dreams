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
public class MTPackDetalle implements TableModel {
    
    private final List<OPackDetalle> packdetalles;
    
    public MTPackDetalle(List<OPackDetalle> packdetalles){
        this.packdetalles = packdetalles;
    }

    public List<OPackDetalle> getPackDetalles() {
        return packdetalles;
    }
    
    @Override
    public int getRowCount() {
        return packdetalles.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String NombreColumna = null;
        switch(columnIndex){
            /* case 0:
            NombreColumna = "ID";
            break;*/
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
            /*case 0:
            Valor = Comuna.get(rowIndex).getId();
            break;*/
            case 0:
                Valor = String.valueOf(packdetalles.get(rowIndex).getCantidad());
                break;
            case 1:
                Valor = packdetalles.get(rowIndex).getArticulo().getDescripcion(); //Problemas con Int, no se puede convertir a String
                break;
        }
        
        return Valor;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
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
