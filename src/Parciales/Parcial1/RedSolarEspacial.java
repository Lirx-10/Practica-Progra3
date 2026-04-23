package src.Parciales.Parcial1;

import src.Practica3.Ejercicio1y3y5.*;

public class RedSolarEspacial {
    
    private GeneralTree<Dato> arbol;

    public GeneralTree<Dato> getArbol() {
        return arbol;
    }
    public void setArbol(GeneralTree<Dato> arbol) {
        this.arbol = arbol;
    }

    private GeneralTree<Dato> findNode(GeneralTree<Dato> a, String nombre){
        if(a.getData().getNombre().equals(nombre)){
            return a;
        }
        GeneralTree<Dato> aux = null;
        for(GeneralTree<Dato> child : a.getChildren()){
            aux = findNode(child, nombre);
            if(aux != null){
                return aux;
            }
        }
        return aux;
    }

    private double calcularMinimo(GeneralTree<Dato> a, double energiaTotal){
      double rta = energiaTotal;
        int cantActivos = 0;
        for(GeneralTree<Dato> child : a.getChildren()){
            if(child.getData().getEstado()==true){
                cantActivos++;
            }
        }
        if (cantActivos == 0) {
            return rta;
        }
        for(GeneralTree<Dato> child : a.getChildren()){
            if(child.getData().getEstado()==true){
                double aux = calcularMinimo(child, energiaTotal/cantActivos);
                if(aux < rta){
                    rta = aux;
                }
            }
        }
        return rta;   
    }

    public double minimoSuministroEnergia(double energiaTotal, String panelInicial){
        if(this.arbol == null || this.arbol.isEmpty()){
            return -1; 
        }
        GeneralTree<Dato> aux = findNode(this.arbol, panelInicial);
        if(aux != null && aux.getData().getEstado()){
            return calcularMinimo(aux, energiaTotal);
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        
    }
}
