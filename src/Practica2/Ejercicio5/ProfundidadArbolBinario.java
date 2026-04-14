package src.Practica2.Ejercicio5;

import src.Practica2.Ejercicio1y2.BinaryTree;

public class ProfundidadArbolBinario {
    private BinaryTree<Integer> arbol;

    public BinaryTree<Integer> getArbol() {
        return arbol;
    }
    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public ProfundidadArbolBinario(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public int sumaElementosProfundidad(int p){
        int nivelActual = 0;
        int suma = 0;
        if(nivelActual == p){
            return this.arbol.getData();
        }
        if(this.arbol.hasLeftChild()){
            suma = sumaElementosProfundidad(p-1);
        }
        if(this.arbol.hasRighChild()){
            suma = sumaElementosProfundidad(p-1);
        }

        return suma + sumaElementosProfundidad(p-1);
    }


    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(10);
        // nivel 1
        BinaryTree<Integer> nodo3 = new BinaryTree<Integer>(3);
        BinaryTree<Integer> nodo5 = new BinaryTree<Integer>(5);
        arbol.addLeftChild(nodo3);
        arbol.addRightChild(nodo5);
        // nivel 2
        BinaryTree<Integer> nodo9 = new BinaryTree<Integer>(9);
        BinaryTree<Integer> nodo2 = new BinaryTree<Integer>(2);
        nodo3.addLeftChild(nodo9);
        nodo3.addRightChild(nodo2);
        // nivel 3
        BinaryTree<Integer> nodo12 = new BinaryTree<Integer>(12);
        nodo9.addLeftChild(nodo12);
        // probar

        ProfundidadArbolBinario pb = new ProfundidadArbolBinario(arbol);

        System.out.println(pb.sumaElementosProfundidad(2));
    }

    

}
