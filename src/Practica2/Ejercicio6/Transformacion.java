package src.Practica2.Ejercicio6;

import src.Practica2.Ejercicio1y2.BinaryTree;

public class Transformacion {
    BinaryTree<Integer> arbol;

    public Transformacion(BinaryTree<Integer> arbol){
        this.arbol = arbol;
    }

    public int Transformar(BinaryTree<Integer> nodo){
        int original = 0;
        if(nodo.isLeaf()){
            original = nodo.getData();
            nodo.setData(0);
            return original;
        }
        int aux = 0;
        if(nodo.hasLeftChild()){
            aux = aux + Transformar(nodo.getLeftChild());
        }
        if(nodo.hasRighChild()){
            aux = aux + Transformar(nodo.getRightChild());
        }
        original = nodo.getData();
        nodo.setData(aux);
        return aux + original;
    }

    public BinaryTree<Integer> suma(){
        int meChupa = Transformar(this.arbol);
        System.out.println(meChupa);
        return this.arbol;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(12);
        arbol.crearArbol(arbol);
        arbol.imprimirDetalle(arbol);

        System.out.println("Ahora lo transformo!!!!");
        Transformacion t = new Transformacion(arbol);
        t.Transformar(arbol);
        arbol.imprimirDetalle(arbol);
    }


}
