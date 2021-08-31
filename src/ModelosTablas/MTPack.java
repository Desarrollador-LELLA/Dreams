/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosTablas;

import Objetos.OPack;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Usuario
 */
public class MTPack implements TableModel{
    private final List<OPack> Pack;
    
     public MTPack (List<OPack> pack){
        Pack = pack;
    }

    public List<OPack> getPack() {
        return Pack;
    }

    @Override
    public int getRowCount() {
        return Pack.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String NombreColumna = null;
        switch(columnIndex){
            /* case 0:
            NombreColumna = "ID";
            break;*/
            case 0:
                NombreColumna = "Nombre";
                break;
            case 1:
                NombreColumna = "Costo";
                break;
            case 2:
                NombreColumna = "Stock";
                break;
            case 3:
                NombreColumna = "Estado";
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
                Valor = Pack.get(rowIndex).getNombre();
                break;
            case 1:
                Valor = Pack.get(rowIndex).getCosto();
                break;
            case 2:
                Valor = toString(Pack.get(rowIndex).getStock());;
                break;
            case 3:
                Valor = Pack.get(rowIndex).isEstado()? "Activado" : "Desactivado";
                break;    
        }
        
        return Valor;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String toString(int stock) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
