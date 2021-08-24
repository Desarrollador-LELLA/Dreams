/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosTablas;

import Objetos.OCanales;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Usuario
 */
public class MTCanales implements TableModel{
    private final List<OCanales> Canal;

    public MTCanales(List<OCanales> Canal) {
        this.Canal = Canal;
    }

    public List<OCanales> getCanal() {
        return Canal;
    }

    @Override
    public int getRowCount() {
        return Canal.size();
    }

    @Override
    public int getColumnCount() {
        return 3;      
    }

    @Override
    public String getColumnName(int columnIndex) {
        String NombreColumna = null;
        switch(columnIndex){
            case 0:
                NombreColumna = "ID";
                break;
            case 1:
                NombreColumna = "Nombre";
                break;
            case 2:
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
            
            case 0:
                Valor =  String.valueOf(Canal.get(rowIndex).getId());
                break;
            case 1:
                Valor = Canal.get(rowIndex).getNombre(); 
                break; 
            case 2:
                Valor = Canal.get(rowIndex).getEstado() ? "Activado" : "Desactivado";
                break;
        }
        
        return Valor;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        
    }
    
    
}

