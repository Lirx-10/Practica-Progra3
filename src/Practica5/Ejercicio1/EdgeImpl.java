package Practica5.Ejercicio1;

public class EdgeImpl<T> implements Edge<T>{
    private Vertex<T> destino;
    private int peso;

    public EdgeImpl(Vertex<T> destino, int peso){
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public Vertex<T> getTarget() {
        return this.destino;
    }

    @Override
    public int getWeight() {
        return this.peso;
    }
    
}
