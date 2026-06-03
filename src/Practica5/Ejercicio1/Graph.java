package Practica5.Ejercicio1;

import java.util.List;

public interface Graph<T>{

    // Crea un vértice con un dato y lo retorna
    public Vertex<T> createVertex(T data);

    //Elimina el vértice del grafo, si está relacionado con otros tambien los elimina
    public void removeVertex(Vertex<T> vertex);

    //Busca y devuelve el primer vértice que concuerda con el dato, si no existe retorna null
    public Vertex<T> search(T data);

    //Conecta el vértice origen con el vertice destino(verificar que existen ambos)
    public void connect(Vertex<T> origin, Vertex<T> destination);

    //Lo mismo pero con peso en las aristas
    public void connect(Vertex<T> origin, Vertex<T> destination,int weight);

    // Desconecta el vértice origen con el destino, si no existen no se hace nada. Si Destino->Origen quedan como están
    public void disconnect(Vertex<T> origin, Vertex<T> destination);

    //Retorna si existe una arista entre 2 vértices
    public boolean existsEdge(Vertex<T> origin, Vertex<T> destination);

    //Retornar si el vértice no tiene datos
    public boolean isEmpty();

    //Retorna la lista de vértices
    public List<Vertex<T>> getVertices();

    //Retorna el peso de la arista entre dos vértices, en caso de no tener arista retorna 0
    public int weight(Vertex<T> origin, Vertex<T> destination);

    //Retorna la lista de aristas adyacentes al vértice recibido.
    public List<Edge<T>> getEdges(Vertex<T> v);

    //Retorna el vértice de la posición recibida
    public Vertex<T> getVertex(int position);

    //Retorna la cantidad de vértices del grafo
    public int getSize();
}
