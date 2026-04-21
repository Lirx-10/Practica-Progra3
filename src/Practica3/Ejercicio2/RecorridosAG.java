package src.Practica3.Ejercicio2;

import java.util.*;
import src.Practica1.Ejercicio8.Queue;
import src.Practica3.Ejercicio1y3y5.GeneralTree;

public class RecorridosAG {
    
    // CON RECORRIDO PREORDEN
    public void preOrden(GeneralTree<Integer> a, Integer n, List<Integer> lista){
        if(a.isEmpty() || a == null){
            return;
        }
        if(a.getData()%2 != 0 & a.getData() > n){
            lista.add(a.getData());
        }
        List<GeneralTree<Integer>> children = a.getChildren();
        for(GeneralTree<Integer> child : children){
            preOrden(child, n, lista);
        }
    }
    public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n){
        List<Integer> lista = new ArrayList<>();
        preOrden(a, n, lista);
        return lista;
    }

    // CON RECORRIDO INORDEN
    public void inOrden(GeneralTree<Integer> a, Integer n, List<Integer> lista){
        if(a.isEmpty() || a == null){
            return;
        }
        // tengo que procesar el primer hijo, la raiz y despues recorrer el resto
        List<GeneralTree<Integer>> children = a.getChildren();
        if(!children.isEmpty()){
            inOrden(children.get(0), n, lista);
        }
        if(a.getData()%2 != 0 & a.getData() > n){
            lista.add(a.getData());
        }
        for(int i = 1 ; i < children.size() ; i++){
            inOrden(children.get(i), n, lista);
        }
    }
    public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree <Integer> a, Integer n){
        List<Integer> lista = new ArrayList<>();
        inOrden(a, n, lista);
        return lista;
    }

    // CON RECORRIDO POSTORDEN
    public void postOrden(GeneralTree<Integer> a, Integer n, List<Integer> lista){
        if(a.isEmpty() || a == null){
            return;
        }
        List<GeneralTree<Integer>> children = a.getChildren();
        for(GeneralTree<Integer> child : children){
            postOrden(child, n, lista);
        }
        if(a.getData()%2 != 0 & a.getData() > n){
            lista.add(a.getData());
        }
    }
    public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n){
        List<Integer> lista = new ArrayList<>();
        postOrden(a, n, lista);
        return lista;
    }

    // RECORRIDO POR NIVELES
    public void porNiveles(GeneralTree<Integer> a, Integer n, List<Integer> lista){
        GeneralTree<Integer> aux;
        Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
        queue.enqueue(a);
        while(!queue.isEmpty()){
            aux = queue.dequeue();
            if(aux.getData()%2 != 0 & aux.getData() > n){
                lista.add(aux.getData());
            }   
            List<GeneralTree<Integer>> children = aux.getChildren();
            for(GeneralTree<Integer> child : children){
                queue.enqueue(child);
            }
        }
    }
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n){
        List<Integer> lista = new ArrayList<>();
        porNiveles(a, n, lista);
        return lista;
    }

    // Ejercicio 2b-
    /*El cambio que haría sería cambiar todos los Integer en los arboles y listas por un T genérico? 
      ni idea
     */

}
