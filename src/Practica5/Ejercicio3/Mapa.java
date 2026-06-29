package Practica5.Ejercicio3;

import Practica5.Ejercicio1.*;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
    Graph<String> mapaCiudades;


    public List<String> devolverCaminos(String ciudad1, String ciudad2){
        List<String> camino = new ArrayList<>();
        boolean [] visitados = new boolean[mapaCiudades.getSize()];
        Vertex<String> origen = mapaCiudades.search(ciudad1);
        Vertex<String> destino = mapaCiudades.search(ciudad2);
        if(origen == null || destino == null){
            return camino;
        465}
        dfs(visitados, origen, destino, camino);

        return camino;
    }

    public void dfs(boolean [] visitados, Vertex<String> origen, Vertex<String> destino, List<String> camino){
        visitados[]
        if (true) {
            
        }
    }

}
