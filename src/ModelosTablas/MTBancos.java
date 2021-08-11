/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosTablas;

import Objetos.OBanco;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Usuario
 */
public class MTBancos implements TableModel {
    
    private List<OBanco> Bancos;

    public MTBancos(List<OBanco> Bancos) {
        this.Bancos = Bancos;
    }

    public List<OBanco> getBancos() {
        return Bancos;
    }
    
    
    
    @Override
    public int getRowCount() {
        return Bancos.size();
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
                NombreColumna = "Nombre Banco";
                break;
            case 1:
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
                Valor = Bancos.get(rowIndex).getNombre();
                break;
            case 1:
                Valor = Bancos.get(rowIndex).getEstado() ? "Activado" : "Desactivado";
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
