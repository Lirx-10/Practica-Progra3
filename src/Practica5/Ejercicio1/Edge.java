package Practica5.Ejercicio1;

public interface Edge<T> {
    
    //Retorna el vértice destino de la arista
    public Vertex<T> getTarget();

    //Retorna el peso de la arista
    public int getWeight();
    
}
