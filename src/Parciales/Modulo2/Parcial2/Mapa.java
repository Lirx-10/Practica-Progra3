/* 
Francesca johnson quiere poner en marcha un emprendimiento de turismo que permita visitar los 
puentes cubiertos de Madison, Iowa. Francesca posee un mapa de las localidades y la interconexión
a través de los puentes, esto se encuentra modelado a través de un grafo. Los puentes (conexiones)
poseen los siguientes valores: 0 = la visita es opcional, 1 = la visita es imperdible. 
  Escriba un algoritmo que le permita a francesca ofrecer el siguiente recorrido: a partir de 
la localidad "Cedar Creek" hasta la localidad "Joshua", obtener el camino completo que le 
permita transitar por la mayor cantidad de puentes imperdibles, sin pasar 2 veces por la misma
localidad. En caso de existir más de un camino posible, devolver el que transita la menor 
cantidad de puentes opcionales.
*/

package Parciales.Modulo2.Parcial2;

import java.util.ArrayList;
import java.util.List;
import Practica5.Ejercicio1.*;

public class Mapa {
    
    private Graph<String> grafo;

    public Mapa(Graph<String> grafo){
        this.grafo = grafo;
    }

    public List<String> recorridoTuristico(String ciudadOrigen, String ciudadDestino){
        List<String> recorrido = new ArrayList<>();
        List<String> caminoActual = new ArrayList<>();
        Vertex<String> origen = grafo.search(ciudadOrigen);
        Vertex<String> destino = grafo.search(ciudadDestino);
        if(origen == null || destino == null){
            return recorrido;
        }
        boolean[] visitados = new boolean[grafo.getSize()];
        Resultados res = new Resultados(-1, Integer.MAX_VALUE);
        dfs(origen, destino,recorrido,caminoActual,visitados,res,0,0);
        return recorrido;
    }
    
    private void dfs(Vertex<String> actual, Vertex<String> destino, List<String> mejorCamino, List<String> caminoActual, boolean[] visitados, Resultados res,int imperdibles, int opcionales){
        visitados[actual.getPosition()] = true;
        caminoActual.add(actual.getData());
        if(actual == destino){
            if(imperdibles > res.getMaxImperdible() || (imperdibles == res.getMaxImperdible() && opcionales < res.getMinOpcionales())){
                res.setMaxImperdible(imperdibles);
                res.setMinOpcionales(opcionales);
                mejorCamino.clear();
                mejorCamino.addAll(caminoActual);
            }
        }else{ //Si no llegué a destino sigo recorriendo
            List<Edge<String>> aristas = grafo.getEdges(actual);
            for(Edge<String> e : aristas){
                Vertex<String> siguiente = e.getTarget();
                if(visitados[siguiente.getPosition()]==false){
                    if(e.getWeight() == 1){
                        dfs(siguiente, destino, mejorCamino, caminoActual, visitados, res, imperdibles+1, opcionales);
                    }else{
                        dfs(siguiente, destino, mejorCamino, caminoActual, visitados, res, imperdibles, opcionales+1);
                    }
                }
            }
        }
        visitados[actual.getPosition()] = false;
        caminoActual.remove(caminoActual.size()-1);
    }

}
