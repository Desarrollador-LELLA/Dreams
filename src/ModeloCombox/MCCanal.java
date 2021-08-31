/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloCombox;

import Objetos.OCanales;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author TOULON-NOTE
 */
public class MCCanal implements ComboBoxModel {
    private List<OCanales> canales;
    private String Nombre = "Seleccione Canal";

    public MCCanal(List<OCanales> canales) {
        this.canales = canales;
    }

    public List<OCanales> getCanales() {
        return canales;
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
        return canales.size();
    }

    @Override
    public Object getElementAt(int index) {
        return canales.get(index).getNombre();
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
