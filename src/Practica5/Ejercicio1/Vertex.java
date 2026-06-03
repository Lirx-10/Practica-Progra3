package Practica5.Ejercicio1;

public interface Vertex<T> {
    
    //Retorna el dato del vértice
    public T getData();

    //Reemplaza el dato del vértice
    public void setData(T data);

    //Retorna la posición del vértice en el grafo
    public int getPosition();

}
