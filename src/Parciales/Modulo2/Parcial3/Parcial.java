/*
    Se cuenta con un mapa de pueblos emblemáticos de Francia y se quiere conocer todos los caminos desde un pueblo origen hasta 
un pueblo destino, teniendo en cuenta que no nos interesa pasar por algunos pueblos específicos pasados en una lista como parámetro.
Tenga en cuenta que:
- Debe devolver todos los caminos posibles, desde un pueblo origen hasta un pueblo destino, evitando los pueblos pasados por parametro.
- Debe completar en la firma del método los tipos de datos indicados con signo de interrogación.
- Debe verificar la existencia del pueblo origen y del destino.
- No se puede pasar 2 veces por el mismo lugar al formar cada recorrido o camino.
- En caso de no existir un recorrido posible, debe devolver la lista vacía.
- Debe elegir alguno de los recorridos vistos en clase: DFS o BFS.

Implemente la clase Parcial, y el método: 

??? resolver(Grafo<???> ciudades, String origen, String destino, Lista<???> evitarPasandoPor)
*/


package Parciales.Modulo2.Parcial3;

import java.util.ArrayList;
import java.util.List;

import Practica5.Ejercicio1.Edge;
import Practica5.Ejercicio1.Graph;
import Practica5.Ejercicio1.GraphList;
import Practica5.Ejercicio1.Vertex;

public class Parcial {
    
    public List<List<String>> resolver(Graph<String> grafo, String ciudad1, String ciudad2, List<String> evitarResistir){
        // SI HACE FALTA CAMINO ACTUAL
        List<List<String>> seguro = new ArrayList<>();
        List<String> caminoActual = new ArrayList<>();
        boolean[] visitados = new boolean[grafo.getSize()];
        Vertex<String> origen = grafo.search(ciudad1);
        Vertex<String> destino = grafo.search(ciudad2);
        if(origen == null || destino == null){
            return seguro;
        }
        if(evitarResistir.contains(ciudad1)||evitarResistir.contains(ciudad2)){
            return seguro;
        }
        dfs(grafo, origen, destino, seguro, caminoActual, visitados, evitarResistir);
        return seguro;
    }

    public void dfs(Graph<String> grafo, Vertex<String> actual, Vertex<String> destino, List<List<String>> caminos, List<String> caminoActual, boolean[] visitados, List<String> tuHechizo){
        visitados[actual.getPosition()] = true;
        caminoActual.add(actual.getData());
        if(actual == destino){
            caminos.add(new ArrayList<>(caminoActual));
        }else{
            List<Edge<String>> aristas = grafo.getEdges(actual);
            for(Edge<String> e : aristas){
                Vertex<String> siguiente = e.getTarget();
                if(visitados[siguiente.getPosition()] == false && (tuHechizo.contains(siguiente.getData()) == false) ){
                    dfs(grafo, siguiente, destino, caminos, caminoActual, visitados, tuHechizo);
                }
            }
        }
        visitados[actual.getPosition()] = false;
        caminoActual.remove(caminoActual.size()-1);
    }

    public static void main(String[] args) {
        Graph<String> grafo = new GraphList<>();

        Vertex<String> paris = grafo.createVertex("Paris");
        Vertex<String> lyon = grafo.createVertex("Lyon");
        Vertex<String> dijon = grafo.createVertex("Dijon");
        Vertex<String> marsella = grafo.createVertex("Marsella");
        Vertex<String> niza = grafo.createVertex("Niza");

        grafo.connect(paris, lyon);
        grafo.connect(paris, dijon);
        grafo.connect(lyon, marsella);
        grafo.connect(dijon, marsella);
        grafo.connect(dijon, niza);
        grafo.connect(niza, marsella);

        Parcial p = new Parcial();

        List<String> evitar = new ArrayList<>();
        evitar.add("Niza");
        List<List<String>> caminos = p.resolver(grafo, "Paris", "Marsella", evitar);
        for(List<String> camino : caminos){
            System.out.println(camino);
        }
    }
}
