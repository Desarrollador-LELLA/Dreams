/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosTablas;

import Objetos.OProveedor;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author rodka
 */
public class MTProveedor implements TableModel {
    
    private final List<OProveedor> Proveedor;
    
    public MTProveedor(List<OProveedor> proveedor){
        Proveedor = proveedor;
    }

    public List<OProveedor> getUsuarios() {
        return Proveedor;
    }
    
    @Override
    public int getRowCount() {
        return Proveedor.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String NombreColumna = null;
        switch(columnIndex){
            /* case 0:
            NombreColumna = "ID";
            break;*/
            case 0:
                NombreColumna = "Razon Social";
                break;
            case 1:
                NombreColumna = "Nombre";
                break;
            case 2:
                NombreColumna = "Telefono";
                break;
            case 3:
                NombreColumna = "E-Mail";
                break;
            case 4:
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
                Valor = Proveedor.get(rowIndex).getRsocial();
                break;
            case 1:
                Valor = Proveedor.get(rowIndex).getNombre();
                break;
            case 2:
                Valor = String.valueOf(Proveedor.get(rowIndex).getTelefono());
                break;
            case 3:
                Valor = Proveedor.get(rowIndex).getCorreo();
                break;    
            case 4:
                Valor = Proveedor.get(rowIndex).isEstado()? "Activado" : "Desactivado";
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
