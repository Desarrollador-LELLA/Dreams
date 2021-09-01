/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloCombox;

import Objetos.OCatArticulos;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Usuario
 */
public class MCCatArticulos implements ComboBoxModel {

    private List<OCatArticulos> catArticulos;
    private String Nombre = "Seleccione Categoria";

    public MCCatArticulos(List<OCatArticulos> catArticulos) {
        this.catArticulos = catArticulos;
    }

    public List<OCatArticulos> getCatArticulos() {
        return catArticulos;
    }
    
    
    
    @Override
    public void setSelectedItem(Object anItem) {
        Nombre = String.valueOf(anItem);
    }

    @Override
    public Object getSelectedItem() {
        return Nombre;
    }

    @Override
    public int getSize() {
        return catArticulos.size();
    }

    @Override
    public Object getElementAt(int index) {
        return catArticulos.get(index).getNombre();
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
