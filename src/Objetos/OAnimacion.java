/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author TOULON-NOTE
 */
public class OAnimacion {
    private Timer Tiempo = new Timer();
    private JTextField txt;
    private JComboBox<String> cbox;
    private JDateChooser datebox;
    private int valor = 1;
    
    private TimerTask TareaTxt = new TimerTask() {
        @Override
        public void run() {
            if (valor == 1) {
                txt.setBackground(Color.red);
                valor = 2;
            } else {
                txt.setBackground(Color.WHITE);
                valor = 1;
            }
        }
    };
    
    private TimerTask TareaCbox = new TimerTask() {
        @Override
        public void run() {
            if (valor == 1) {
                cbox.setBackground(Color.red);
                valor = 2;
            } else {
                cbox.setBackground(Color.WHITE);
                valor = 1;
            }
        }
    };
    
    private TimerTask TareaDateBox = new TimerTask() {
        @Override
        public void run() {
            if (valor == 1) {
                datebox.setBackground(Color.red);
                valor = 2;
            } else {
                datebox.setBackground(Color.getHSBColor(240, 240, 240));
                valor = 1;
            }
        }
    };

    public OAnimacion(JTextField txt) {
        this.txt = txt;
    }
    
    public OAnimacion(JComboBox<String> cbox) {
        this.cbox = cbox;
    }
    
    public OAnimacion(JDateChooser datebox) {
        this.datebox = datebox;
    }

    public void EjecutarTxt(){
        Tiempo.scheduleAtFixedRate(TareaTxt, 0, 500);
    }
    
    public void EjecutarCbox(){
        Tiempo.scheduleAtFixedRate(TareaCbox, 0, 500);
    }
    
    public void EjecutarDateBox(){
        Tiempo.scheduleAtFixedRate(TareaDateBox, 0, 500);
    }
    
    public void DetenerTxt(){
        txt.setBackground(Color.WHITE);
        Tiempo.cancel();
    }
    
    public void DetenerCbox(){
        cbox.setBackground(Color.WHITE);
        Tiempo.cancel();
    }
    
    public void DetenerDateBox(){
        datebox.setBackground(Color.getHSBColor(240, 240, 240));
        Tiempo.cancel();
    }
}
