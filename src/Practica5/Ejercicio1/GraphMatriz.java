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
        Vertex<T> nuevo = new VertexImpl<T>(data, vertices.size());
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
        int pos = vertices.indexOf(vertex);
        int sizeViejo = vertices.size();
        int [][] matrizNueva = new int[sizeViejo - 1][sizeViejo - 1];
        int iNueva = 0;
        for(int i = 0; i < sizeViejo; i++){
            int jNueva = 0;
            if(i == pos) continue;
            for(int j = 0; j < sizeViejo; j++){
                if(j == pos) continue;
                matrizNueva[iNueva][jNueva] = matrizAdyacente[i][j];
                jNueva++;        
            }
            iNueva++;
        }
        matrizAdyacente = matrizNueva;
        vertices.remove(pos);
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
        int posOrigin = vertices.indexOf(origin);
        int posDestination = vertices.indexOf(destination);    
        if (posDestination == -1 || posOrigin == -1) {
            System.out.println("Alguno de los 2 vertices no existe, no se realiza la conexión");
            return;
        }
        matrizAdyacente[posOrigin][posDestination] = 1; 
    }

    @Override
    public void connect(Vertex<T> origin, Vertex<T> destination, int weight) {
        int posOrigin = vertices.indexOf(origin);
        int posDestination = vertices.indexOf(destination);    
        if (posDestination == -1 || posOrigin == -1) {
            return;
        }
        matrizAdyacente[posOrigin][posDestination] = weight;
    }

    @Override
    public void disconnect(Vertex<T> origin, Vertex<T> destination) {
        int posOrigin = vertices.indexOf(origin);
        int posDestination = vertices.indexOf(destination);    
        if (posDestination == -1 || posOrigin == -1) {
            return;
        }
        matrizAdyacente[posOrigin][posDestination] = 0;
    }

    @Override
    public boolean existsEdge(Vertex<T> origin, Vertex<T> destination) {
        int posOrigin = vertices.indexOf(origin);
        int posDestination = vertices.indexOf(destination);
        if(posDestination == -1 || posOrigin == -1){
            return false;
        }
        return matrizAdyacente[posOrigin][posDestination] > 0;
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
        int posOrigin = vertices.indexOf(origin);
        int posDestination = vertices.indexOf(destination);    
        if (posDestination == -1 || posOrigin == -1) {
            System.out.println("Alguno de los 2 vertices no existe");
            return 0;
        }
        return matrizAdyacente[posOrigin][posDestination];
    }

    @Override
    public List<Edge<T>> getEdges(Vertex<T> v) {
        List<Edge<T>> aristas = new ArrayList<>();
        int pos = vertices.indexOf(v);
        if(pos == -1){
            return null;
        }
        int size = vertices.size();
        for(int i = 0; i < size; i++){
            if(matrizAdyacente[pos][i] != 0){
                Edge<T> arista = new EdgeImpl<>(vertices.get(i), matrizAdyacente[pos][i]);
                aristas.add(arista);
            }
        }
        return aristas;
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
