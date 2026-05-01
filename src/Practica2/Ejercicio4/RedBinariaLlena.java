package src.Practica2.Ejercicio4;

import src.Practica2.Ejercicio1y2.BinaryTree;

public class RedBinariaLlena {

    public int maximo(int izq, int der){
        if(izq > der){
            return izq;
        }else{
            return der;
        }
    }

    public int retardoReenvio(BinaryTree<Integer> arbol) {
        int izq = 0;
        int der = 0;
        // Cuando llego al final, devuelvo el dato de la hoja
        if(arbol.isLeaf()){
            return arbol.getData();
        }
        // Hago el recorrido hasta el final
        if(arbol.hasLeftChild()){
            izq = retardoReenvio(arbol.getLeftChild());
        }
        if(arbol.hasRightChild()){
            der = retardoReenvio(arbol.getRightChild());
        }
        return arbol.getData() + maximo(izq, der);
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
        RedBinariaLlena red = new RedBinariaLlena();

        System.out.println(red.retardoReenvio(arbol));
    }
}
