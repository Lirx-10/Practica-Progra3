package Practica5.Ejercicio2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import Practica1.Ejercicio8.*;

import Practica5.Ejercicio1.*;

public class Recorridos {
    
    public <T> List<T> dfs(Graph<T> grafo){
        List<T> recorrido = new ArrayList<T>();
        boolean[] visitados = new boolean[grafo.getSize()];
        for(int i = 0; i < grafo.getSize(); i++){
            if(!visitados[i]){
                dfsRecursivo(i, grafo, visitados, recorrido);
            }
        }
        return recorrido;
    }
    private <T> void dfsRecursivo(int i, Graph<T> grafo, boolean[] visitados, List<T> recorrido){
        visitados[i] = true;
        Vertex<T> v = grafo.getVertex(i);
        recorrido.add(v.getData());
        List<Edge<T>> adyacentes = grafo.getEdges(v);
        for(Edge<T> e : adyacentes){
            int j = e.getTarget().getPosition();
            if(!visitados[j]){
                dfsRecursivo(j, grafo, visitados, recorrido);
            }
        }
    }

    public <T> List<T> bfs(Graph<T> grafo){
        List<T> recorrido = new ArrayList<T>();
        boolean[] visitados = new boolean[grafo.getSize()];
        for(int i = 0; i < grafo.getSize(); i++){
            if(!visitados[i]){
                bfsNiveles(i, grafo, visitados, recorrido);
            }
        }
        return recorrido;
    }
    private <T> void bfsNiveles(int i, Graph<T> grafo, boolean[] visitados, List<T> recorrido){
        Queue<Vertex<T>> queue = new Queue<Vertex<T>>();
        queue.enqueue(grafo.getVertex(i));
        visitados[i] = true;
        while(queue.isEmpty() == false){
            Vertex<T> v = queue.dequeue();
            recorrido.add(v.getData());
            for(Edge<T> e : grafo.getEdges(v)){
                int j = e.getTarget().getPosition();
                if(visitados[j] == false){
                    visitados[j] = true;
                    queue.enqueue(e.getTarget());
                }
            }
        }
    }


}
