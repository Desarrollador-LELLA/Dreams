/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author TOULON-NOTE
 */
public class OError {
    //ATRIBUTOS
    private String codigo = "";
    private String mensaje = "";
    private Object retorno = null;
    private boolean confirma = false;
    
    //CONSTRUCTORES
    public OError() {
    }
    
    public OError(String _codigo, String _mensaje, Object _retorno, boolean _confirma){
        codigo = _codigo;
        mensaje = _mensaje;
        retorno = _retorno;
        confirma = _confirma;
    }
    
    //PROPIEDADES
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getRetorno() {
        return retorno;
    }

    public void setRetorno(Object retorno) {
        this.retorno = retorno;
    }

    public boolean isConfirma() {
        return confirma;
    }

    public void setConfirma(boolean confirma) {
        this.confirma = confirma;
    }
    
    //METODOS
    
}
