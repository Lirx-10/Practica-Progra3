package Practica5.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class GraphMatriz<T> implements Graph<T>{
    private List<Vertex<T>> vertices;
    private int[][] matrizAdyacente;

    public GraphMatriz() {
        this.vertices = new ArrayList<>();
        this.matrizAdyacente = new int[0][0];
    }

    @Override
    public Vertex<T> createVertex(T data) {
        // Creo el nuevo vertice a agregar, y la nueva matriz(que reemplazará a la anterior)
        Vertex<T> nuevo = new VertexImpl<T>(data);
        int sizeViejo = vertices.size();
        int [][] matrizNueva = new int[sizeViejo + 1][sizeViejo + 1];
        //Copio en la matriz nueva lo que ya había en la anterior
        for(int i = 0; i < sizeViejo; i++){
            for(int j = 0; j < sizeViejo; j++){
                matrizNueva[i][j] = matrizAdyacente[i][j];
            }
        }
        // Agrego el nuevo valor a la lista, y actualizo la matriz
        vertices.add(nuevo);
        matrizAdyacente = matrizNueva;
        
        return nuevo;
    }

    @Override
    public void removeVertex(Vertex<T> vertex) {
        int sizeViejo = vertices.size();
        int [][] matrizNueva = new int[sizeViejo - 1][sizeViejo - 1];
        for(int i=0; i < sizeViejo; i++){
            for(int j=0; i < sizeViejo - 1; j++){
                matrizNueva[i][j] = matrizAdyacente[i][j];
            }
        }
        matrizAdyacente = matrizNueva;
        vertices.remove(sizeViejo);
    }

    @Override
    public Vertex<T> search(T data) {
        for(Vertex<T> vertice: this.vertices){
            if(vertice.getData().equals(data)){
                return vertice;
            }
        }
        return null;
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
        return null;
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
