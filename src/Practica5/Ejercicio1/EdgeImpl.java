package Practica5.Ejercicio1;

public class EdgeImpl<T> implements Edge<T>{
    private Vertex<T> destino;
    private int peso;


    @Override
    public Vertex<T> getTarget() {
        return this.destino;
    }

    @Override
    public int getWeight() {
        return this.peso;
    }
    
}
