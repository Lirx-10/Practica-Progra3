package Practica5.Ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GraphList<T> implements Graph<T> {
    private List<Vertex<T>> vertices = new ArrayList<>();
    private List<List<Edge<T>>> adjList = new ArrayList<>();

    @Override
    public Vertex<T> createVertex(T data) {
        Vertex<T> v = new VertexImpl<T>(data, this.vertices.size());
        this.vertices.add(v);
        adjList.add(new LinkedList<Edge<T>>());
        return v;
    }

    @Override
    public void removeVertex(Vertex<T> vertex) {
        int pos = vertex.getPosition();
        // eliminar todas las aristas que apuntan al vértice
        for(List<Edge<T>> edges : adjList){
            Iterator<Edge<T>> it = edges.iterator();
            while(it.hasNext()){
                Edge<T> e = it.next();
                if(e.getTarget().equals(vertex)){
                    it.remove();
                }
            }
        }
        // Elimino su lista de adyacentes
        this.adjList.remove(pos);
        // Elimino el vertice
        this.vertices.remove(pos);
        // Actualizo las posiciones
        for(int i = pos; i < vertices.size(); i++){
            Vertex<T> v = vertices.get(i);
            v.setPosition(i);
        }
    }

    @Override
    public Vertex<T> search(T data) {
        for (Vertex<T> v : vertices){
            if(v.getData().equals(data)){
                return v;
            }
        }
        return null;
    }

    @Override
    public void connect(Vertex<T> origin, Vertex<T> destination) {
        if(origin == null || destination == null){
            return;
        }
        if(existsEdge(origin, destination)){
            return;
        }
        // Creo la arista que va a estar conectada al destino
        Edge<T> edge = new EdgeImpl<>();
        edge.setTarget(destination);
        // Agrego a la lista de adyacentes
        adjList.get(origin.getPosition()).add(edge);
    }

    @Override
    public void connect(Vertex<T> origin, Vertex<T> destination, int weight) {
        if(origin == null || destination == null){
            return;
        }
        if(existsEdge(origin, destination)){
            return;
        }
        // Creo la arista que va a estar conectada al destino
        Edge<T> edge = new EdgeImpl<>(destination, weight);
        // Agrego a la lista de adyacentes
        adjList.get(origin.getPosition()).add(edge);
    }

    @Override
    public void disconnect(Vertex<T> origin, Vertex<T> destination) {
        if(origin == null || destination == null){
            return;
        }
        List<Edge<T>> e = adjList.get(origin.getPosition());
        for(int i = 0; i < e.size(); i++){
            if(e.get(i).getTarget().equals(destination)){
                e.remove(i);
                return;
            }
        }
    }

    @Override
    public boolean existsEdge(Vertex<T> origin, Vertex<T> destination) {
        if(origin == null || destination == null){
            return false;
        }
        List<Edge<T>> edges = adjList.get(origin.getPosition());
        for(Edge<T> edge : edges){
            if(edge.getTarget().equals(destination)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    @Override
    public List<Vertex<T>> getVertices() {
        if(!vertices.isEmpty()){
            return vertices;
        }
        return null;
    }

    @Override
    public int weight(Vertex<T> origin, Vertex<T> destination) {
        if(origin == null || destination == null){
            return -1;
        }
        List<Edge<T>> edges = adjList.get(origin.getPosition());
        for(Edge<T> edge : edges){
            if(edge.getTarget().equals(destination)){
                return edge.getWeight();
            }
        }
        return -1;
    }

    @Override
    public List<Edge<T>> getEdges(Vertex<T> v) {
        if(v == null){
            return null;
        }
        return adjList.get(v.getPosition());
    }

    @Override
    public Vertex<T> getVertex(int position) {
        if(position < 0 || position > vertices.size()){
            return null;
        }
        return vertices.get(position);
    }

    @Override
    public int getSize() {
        return vertices.size();
    }
    
}
