/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Objetos.OError;
import Objetos.OVerificar;

/**
 *
 * @author rodka
 */
public class CVerificar extends OVerificar{

    private OError Error = new OError();
    private String TagCodigoClase = "CVerificar - %s";

    public CVerificar() {
        super();
    }

    public CVerificar(String Rut) {
        super(Rut);
    }
    
    public OError Validar() {

        int Ult = this.getRut().length();
        int Largo = this.getRut().length() - 3;//19068257-4
        int Constante = 2;
        int Suma = 0;
        int Digito = 0;

        for (int i = Largo; i >= 0; i--) {

            Suma = Suma + Integer.parseInt(this.getRut().substring(i, i + 1)) * Constante;
            Constante = Constante + 1;
            if (Constante == 8) {
                Constante = 2;
            }
        }
        String Ultimo = this.getRut().substring(Ult - 1).toUpperCase();
        Digito = 11 - (Suma % 11);
        if (Digito == 10 && Ultimo.equals("K")) {
            Error = new OError(String.format(TagCodigoClase, 1), "Rut Correcto", null, true);
            
        } else {

            if (Digito == 11 && Ultimo.equals("0")) {
                Error = new OError(String.format(TagCodigoClase, 1), "Rut Correcto", null, true);
            } else {
                
                if (Digito == Integer.parseInt(Ultimo)) {
                   Error = new OError(String.format(TagCodigoClase, 1), "Rut Correcto", null, true);
                }else{
                    Error = new OError(String.format(TagCodigoClase, 1), "Rut incorrecto", null, false);
                }
            }
            
        }
        return Error;
    }
}
