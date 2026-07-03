package Practica5.Ejercicio3;

import Practica5.Ejercicio1.*;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
    Graph<String> mapaCiudades;
    int mejorDistancia;


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
    private boolean devolverCaminoDfs(Vertex<String> actual, Vertex<String> destino, boolean [] visitados, List<String> camino){
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
        boolean[] visitados = new boolean[mapaCiudades.getSize()];
        if(mapaCiudades.isEmpty()){
            return camino;
        }
        if(origen == null || destino == null){
            return camino;
        }
        devolverCaminosExceptuandoDfs(origen, destino, ciudades, camino, visitados);
        return camino;
    }
    private boolean devolverCaminosExceptuandoDfs(Vertex<String> actual, Vertex<String> destino, List<String> ciudades, List<String> camino, boolean[] visitados){
        visitados[actual.getPosition()]=true;
        camino.add(actual.getData());
        if(actual == destino){
            return true;
        }
        List<Edge<String>> aristas = mapaCiudades.getEdges(actual);
        for(Edge<String> e : aristas){
            if((visitados[e.getTarget().getPosition()]==false) && (ciudades.contains(e.getTarget().getData()) == false)){
                return devolverCaminosExceptuandoDfs(actual, destino, ciudades, camino, visitados);
            }
        }
        camino.remove(camino.size()-1);
        return false;
    }

    public List<String> caminoMasCorto(String ciudad1, String ciudad2){
        List<String> camino = new ArrayList<>();
        Vertex<String> origen = mapaCiudades.search(ciudad1);
        Vertex<String> destino = mapaCiudades.search(ciudad2);
        boolean[] visitados = new boolean[mapaCiudades.getSize()];
        mejorDistancia = Integer.MAX_VALUE;
        caminoMasCortoDfs(origen, destino, visitados, camino, 0);
        return camino;
    }
    //TENGO QUE HACER UNA CLASE QUE ME ALMACENE LA MEJOR DISTANCIA, EN ESTE CASO LA MÁS CHICA
    private void caminoMasCortoDfs(Vertex<String> actual, Vertex<String> destino, boolean[] visitados, List<String> mejorCamino, int distanciaActual){
        List<String> caminoActual = new ArrayList<>();
        visitados[actual.getPosition()]= true;
        if(actual == destino){
            // Comparo mi camino actual con el mejor camino que tengo, ¿como?
            if(distanciaActual < mejorDistancia){
                // Si es mejor cambio mi mejor camino
                mejorCamino.clear();
                mejorCamino.addAll(caminoActual);
            }
        }
        List<Edge<String>> aristas = mapaCiudades.getEdges(actual);
        for(Edge<String> e : aristas){
            if(visitados[e.getTarget().getPosition()]==false){
                caminoMasCortoDfs(actual, destino, visitados, mejorCamino, distanciaActual + e.getWeight());
            }
        }
        caminoActual.remove(caminoActual.size()-1);
        visitados[actual.getPosition()] = false;
    }

    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
        List<String> camino = new ArrayList<>();
        Vertex<String> origen = mapaCiudades.search(ciudad1);
        Vertex<String> destino = mapaCiudades.search(ciudad2);
        boolean[] visitados = new boolean[mapaCiudades.getSize()];

        return camino;
    }
    private boolean caminoSinCargarCombustibleDfs(){

        return false;
    }

}
