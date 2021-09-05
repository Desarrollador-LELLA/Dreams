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
 * @author TOULON-NOTE
 */
public class Tester implements ComboBoxModel<OCatArticulos> {
    
    private List<OCatArticulos> catArticulos;
    private OCatArticulos selectCatArticulos;
    
    public Tester(List<OCatArticulos> catArticulos) {
        this.catArticulos = catArticulos;
        setSelectedItem(this.catArticulos.get(2));
    }

    public List<OCatArticulos> getCatArticulos() {
        return this.catArticulos;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.selectCatArticulos = (OCatArticulos) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return this.selectCatArticulos;
    }

    @Override
    public int getSize() {
        return this.catArticulos.size();
    }

    @Override
    public OCatArticulos getElementAt(int index) {
        return this.catArticulos.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
