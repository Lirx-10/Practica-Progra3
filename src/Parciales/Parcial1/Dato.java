package src.Parciales.Parcial1;

public class Dato {
    private String nombre;
    private boolean estado;

    public Dato(String nombre, boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean getEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
