package Parciales.Parcial2;

import java.util.List;
import Practica5.Ejercicio1.*;

public class Recorrido {
    private List<Vertex<String>> camino;
    private int puentesImperdibles;
    private int puentesOpcionales;

    public Recorrido(List<Vertex<String>> camino, int puentesImperdibles, int puentesOpcionales) {
        this.camino = camino;
        this.puentesImperdibles = puentesImperdibles;
        this.puentesOpcionales = puentesOpcionales;
    }

    public List<Vertex<String>> getCamino() {
        return camino;
    }

    public int getPuentesImperdibles() {
        return puentesImperdibles;
    }

    public int getPuentesOpcionales() {
        return puentesOpcionales;
    }

}
