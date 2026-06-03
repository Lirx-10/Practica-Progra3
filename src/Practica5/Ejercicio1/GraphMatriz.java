package Practica5.Ejercicio1;

import java.util.List;

public class GraphMatriz<T> implements Graph<T>{
    private List<Vertex<T>> vertices;
    private int[][] matrizAdyacente;


    @Override
    public Vertex<T> createVertex(T data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createVertex'");
    }

    @Override
    public void removeVertex(Vertex<T> vertex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeVertex'");
    }

    @Override
    public Vertex<T> search(T data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public void connect(Vertex<T> origin, Vertex<T> destination) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'connect'");
    }

    @Override
    public void connect(Vertex<T> origin, Vertex<T> destination, int weight) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'connect'");
    }

    @Override
    public void disconnect(Vertex<T> origin, Vertex<T> destination) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'disconnect'");
    }

    @Override
    public boolean existsEdge(Vertex<T> origin, Vertex<T> destination) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsEdge'");
    }

    @Override
    public boolean isEmpty() {
        if(vertices.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Vertex<T>> getVertices() {
        return this.vertices;
    }

    @Override
    public int weight(Vertex<T> origin, Vertex<T> destination) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'weight'");
    }

    @Override
    public List<Edge<T>> getEdges(Vertex<T> v) {
        
    }

    @Override
    public Vertex<T> getVertex(int position) {
        return this.vertices.get(position);
    }

    @Override
    public int getSize() {
        return this.vertices.size();
    }
    
}
