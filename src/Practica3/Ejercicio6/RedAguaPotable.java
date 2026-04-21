package src.Practica3.Ejercicio6;

import java.util.*;
import src.Practica3.Ejercicio1y3y5.*;

public class RedAguaPotable {
    private GeneralTree<Double> arbol;

    public GeneralTree<Double> getArbol() {
        return arbol;
    }
    public void setArbol(GeneralTree<Double> arbol) {
        this.arbol = arbol;
    }

    public double calcularMinimo(GeneralTree<Double> a, double caudal){
        if (a.isLeaf()) {
            return caudal;
        }
        List<GeneralTree<Double>> children = a.getChildren();
        caudal = caudal/children.size();
        double minimo = Double.MAX_VALUE;
        for(GeneralTree<Double> child : children){
            double aux = calcularMinimo(child, caudal);
            if(aux < minimo){
                minimo = aux;
            }
        }
        return minimo;
    }

    public double minimoCaudal(double caudal){
        return calcularMinimo(this.arbol, caudal);
    }



    
}
