package Practica5.Ejercicio1;

public interface Graph<T>{

    // Crea un vértice con un dato y lo retorna
    public Vertex<T> createVertex(T data);

    //Elimina el vértice del grafo, si está relacionado con otros tambien los elimina
    public void removeVertex(Vertex<T> vertex);

    //
    public Vertex<T> search(T data);
}
