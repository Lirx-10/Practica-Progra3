package src.Parciales.Parcial1;

import java.util.*;

public class Respuesta {
    private double minimo;
    private List<String> caminos;

    public Respuesta(double minimo, List<String> caminos) {
        this.minimo = minimo;
        this.caminos = caminos;
    }

    public double getMinimo() {
        return minimo;
    }   

    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }

    public List<String> getCaminos() {
        return caminos;
    }

    public void setCaminos(List<String> caminos) {
        this.caminos = caminos;
    }

}
