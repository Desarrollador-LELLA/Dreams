/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosTablas;

import Objetos.OIVentaPack;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author TOULON-NOTE
 */
public class MTIVentaPack implements TableModel {
    
    private final List<OIVentaPack> iventapack;
    
    public MTIVentaPack(List<OIVentaPack> iventapack){
        this.iventapack = iventapack;
    }

    public List<OIVentaPack> getIVentaPack() {
        return iventapack;
    }
    
    @Override
    public int getRowCount() {
        return iventapack.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String NombreColumna = null;
        switch(columnIndex){
            /* case 0:
            NombreColumna = "ID";
            break;*/
            case 0:
                NombreColumna = "Nombre Pack";
                break;
            case 1:
                NombreColumna = "Cantidad";
                break;
            case 2:
                NombreColumna = "Valor";
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
                Valor = iventapack.get(rowIndex).getNombre();
                break;
            case 1:
                Valor = String.valueOf(iventapack.get(rowIndex).getCantidad());
                break;
                case 2:
                Valor = String.format("$%s", String.valueOf(iventapack.get(rowIndex).getValor()));
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
