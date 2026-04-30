package src.Practica3.Ejercicio9;

import src.Practica3.Ejercicio1y3y5.*;
import java.util.*;

public class Parcial {
    
    /* esto está mal
    // Primero recorro la lista de hijos comparando con la raiz para ver si se cumple la condición
        List<GeneralTree<Integer>> children = a.getChildren();
        for(GeneralTree<Integer> child : children){
            if(child.getData() < a.getData()){
                return false;
            }
            if(a.getData() == child.getData()){
                continuo = true;
            }
        }
        // Si se cumple hago lo mismo con los hijos
        if(continuo == true){
            for(GeneralTree<Integer> child : children){  
                if(continuo == false){
                    return false;
                }
                continuo = cumple(child, continuo);
            }
        }
        return continuo;
        */
        public static boolean esDeSeleccion(GeneralTree<Integer> a){
        // Si es hoja, no hay nada que comparar, entonces se cumple la condición
        if(a.isLeaf()){
            return true;
        }
        // Busco el mínimo entre los hijos y lo comparo con la raíz, si no se cumple la condición devuelvo false
        int minimo = Integer.MAX_VALUE;
        List<GeneralTree<Integer>> children = a.getChildren();
        for(GeneralTree<Integer> child : children){
            if(child.getData()<minimo){
                minimo = child.getData();
            }
        }
        // Si el mínimo es distinto a la raíz, entonces no se cumple la condición
        if(minimo != a.getData()){
            return false;
        }
        // Si se cumple la condición, entonces hago lo mismo con los hijos
        for(GeneralTree<Integer> child : children){
            if(!esDeSeleccion(child)){
                return false;
            }
        }
        return true;
    }

}
