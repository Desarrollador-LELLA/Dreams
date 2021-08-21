
package Objetos;

/**
 *
 * @author rodka
 */
public class OEstadoVenta {
    private int id;
    private String nombre;
    private Boolean estado;   

    public OEstadoVenta() {
    }

    public OEstadoVenta(int id, String nombre, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
