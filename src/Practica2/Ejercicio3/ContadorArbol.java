package src.Practica2.Ejercicio3;

import java.util.LinkedList;

import src.Practica2.Ejercicio1y2.BinaryTree;

public class ContadorArbol {
    private BinaryTree<Integer> arbol;


    public LinkedList numerosParesInOrden(BinaryTree<Integer> arbol){
        if (arbol.hasLeftChild()) {
            numerosParesInOrden(arbol.getLeftChild());   
        }
        if (arbol.getData()%2 == 0) {
            
        }
        if (arbol.hasRighChild()) {
            numerosParesInOrden(arbol.getRightChild());
        }
        return null;
    }

        public LinkedList numerosParesPostOrden(){
        if (true) {
            
        }
        if (true) {
            
        }
        return null;
    }
}
