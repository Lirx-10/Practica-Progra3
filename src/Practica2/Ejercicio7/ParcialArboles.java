package src.Practica2.Ejercicio7;

import src.Practica2.Ejercicio1y2.BinaryTree;

public class ParcialArboles {
    BinaryTree<Integer> arbol;

    private int contarUnicoHijo(BinaryTree<Integer> a){

        return 0;
    }

    private boolean buscarArbol(BinaryTree<Integer> a, int num){
        // Primero debería de encontrar el arbol con el valor num
        if(a.getData() == num){
            int ramaIzq = -1;
            int ramaDer = -1;
            //Hago lo que tengo que hacer y retorno
            if(a.hasLeftChild()){
                ramaIzq = contarUnicoHijo(a.getLeftChild());
            }
            if(a.hasRightChild()){
                ramaDer = contarUnicoHijo(a.getRightChild());
            }
            return ramaIzq>ramaDer;
        }else{
            if (a.hasLeftChild()) {
                return buscarArbol(a.getLeftChild(), num);
            }
            if(a.hasRightChild()){
                return buscarArbol(a.getRightChild(), num);
            }
        }
        return false;
    }

    public boolean isLeftTree(int num){
        return buscarArbol(this.arbol, num);
    }
}
