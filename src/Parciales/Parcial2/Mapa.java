/* 
Francesca johnson quiere poner en marcha un emprendimiento de turismo que permita visitar los 
puentes cubiertos de Madison, Iowa. Francesca posee un mapa de las localidades y la interonexión
a través de los puentes, esto se enuentra modelado a través de un grafo. Los puentes (conexiones)
poseen los siguientes valores: 0 = la visita es opcional, 1 = la visita es imperdible. 
  Escriba un algoritmo que le permita a francesca ofrecer el siguiente recorrido: a partir de 
la localidad "Cedar Creek" hasta la localidad "Joshua", obtener el camino completo que le 
permita transitar por la mayor cantidad de puentes imperdibles, sin pasar 2 veces por la misma
localidad. En caso de existir más de un camino posible, devolver el que transita la menor 
cantidad de puentes opcionales.
*/

package Parciales.Parcial2;

import java.util.ArrayList;
import java.util.List;
import Practica5.Ejercicio1.*;

public class Mapa {
    
    private Graph<String> grafo;

    public Mapa(Graph<String> grafo){
        this.grafo = grafo;
    }

    public List<String> recorridoTuristico(String origen, String destino){
        List<String> recorrido = new ArrayList<>();
        boolean[] visitados = new boolean[grafo.getSize()];
        Vertex<String> origin = grafo.search(origen);
        Vertex<String> destination = grafo.search(destino);
        dfs(origin, destination, recorrido, visitados);

        return recorrido;
    }
    
    public void dfs(Vertex<String> origen, Vertex<String> destino, List<String> mejorCamino, boolean[] visitados){
        List<String> caminoActual = new ArrayList<>();

    }

}
