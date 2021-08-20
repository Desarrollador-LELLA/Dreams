/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JTextField;

/**
 *
 * @author TOULON-NOTE
 */
public class CAnimacion {
    
    private Timer Tiempo = new Timer();
    private javax.swing.JTextField txt;
    private int valor = 1;
    
    private TimerTask Tarea = new TimerTask() {
        @Override
        public void run() {
            //Implmentacion
            if (valor == 1) {
                txt.setBackground(Color.red);
                valor = 2;
            } else {
                txt.setBackground(Color.WHITE);
                valor = 1;
            }
            //System.out.print("Hola");
        }
    };

    public CAnimacion(JTextField txt) {
        this.txt = txt;
    }    

    public void Ejecutar(){
        Tiempo.scheduleAtFixedRate(Tarea, 0, 500);
        //run();
    }
    
    public void Detener(){
        txt.setBackground(Color.WHITE);
        Tiempo.cancel();
    }
}
