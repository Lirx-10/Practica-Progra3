package Practica5.Ejercicio3;

import Practica5.Ejercicio1.*;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
    Graph<String> mapaCiudades;


    public List<String> devolverCamino(String ciudad1, String ciudad2){
        List<String> camino = new ArrayList<>();
        boolean [] visitados = new boolean[mapaCiudades.getSize()];
        Vertex<String> origen = mapaCiudades.search(ciudad1);
        Vertex<String> destino = mapaCiudades.search(ciudad2);
        if(mapaCiudades.isEmpty()){
            return camino;
        }
        if(origen == null || destino == null){
            return camino;
        }
        devolverCaminoDfs(origen, destino, visitados, camino);
        return camino;
    }
    public boolean devolverCaminoDfs(Vertex<String> actual, Vertex<String> destino, boolean [] visitados, List<String> camino){
        visitados[actual.getPosition()] = true;
        camino.add(actual.getData());
        // Realizando el recorrido recursivo encontré el destino
        if(actual == destino){
            return true;
        }
        // Debería de agarrar los adyacentes y meterme con cada uno.
        List<Edge<String>> adyacentes = mapaCiudades.getEdges(actual);
        // Ahora que tengo los adyacentes debería de meterme con cada uno y hacer el recorrido recursivo
        for(Edge<String> e : adyacentes){
            Vertex<String> siguiente = e.getTarget();
            if(visitados[siguiente.getPosition()] == false){
                if(devolverCaminoDfs(siguiente,destino,visitados,camino)){
                    return true;
                }
            }
        }
        // Si por algun camino no encontré, elimino el dato actual y voy regresando en la recursión,
        // luego seguiría recorriendo otros caminos para ver si lo encuentro.
        camino.remove(camino.size()-1);
        return false;
    }

    public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades){
        List<String> camino = new ArrayList<>();
        Vertex<String> origen = mapaCiudades.search(ciudad1);
        Vertex<String> destino = mapaCiudades.search(ciudad2);

        return camino;
    }
    public boolean devolverCaminosExceptuandoDfs(Vertex<String> actual, Vertex<String> destino, List<String> ciudades, List<String> camino, boolean[] visitados){
        visitados[actual.getPosition()]=true;
        if(true){
            
        }
        return false;
    }

}
