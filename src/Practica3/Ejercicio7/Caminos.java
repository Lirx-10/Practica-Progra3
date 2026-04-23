package src.Practica3.Ejercicio7;

import src.Practica3.Ejercicio1y3y5.*;
import java.util.ArrayList;
import java.util.List;

public class Caminos {
    GeneralTree<Integer> arbol;

    public GeneralTree<Integer> getArbol() {
        return arbol;
    }
    public void setArbol(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public void mejorCamino(GeneralTree<Integer> a,List<Integer> actual, List<Integer> mejor){
        actual.add(a.getData());
        if(a.isLeaf()){
            if(actual.size()>mejor.size()){
                mejor.clear();
                mejor.addAll(actual);
            }
        }else{
            List<GeneralTree<Integer>> children = a.getChildren();
            for(GeneralTree<Integer> child : children){ 
                mejorCamino(child, actual,mejor);
            }
        }
        actual.remove(actual.size()-1);
    }

    public List<Integer> caminoAHojaMasLejana(){
        List<Integer> lista = new ArrayList<Integer>();
        List<Integer> mejor = new ArrayList<Integer>();
        mejorCamino(this.arbol, lista, mejor);
        return mejor;
    }   
}
