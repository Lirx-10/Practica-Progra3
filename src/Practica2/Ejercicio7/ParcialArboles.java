package src.Practica2.Ejercicio7;

import src.Practica2.Ejercicio1y2.BinaryTree;

public class ParcialArboles {
    BinaryTree<Integer> arbol;

    class Resultado{
        boolean encontrado;
        boolean cumple;

        public Resultado(){}

        public Resultado( boolean encontrado, boolean cumple){
            this.encontrado = encontrado;
            this.cumple = cumple;
        }

        public boolean getEncontrado() {
            return encontrado;
        }
        public void setEncontrado(boolean encontrado) {
            this.encontrado = encontrado;
        }
        public boolean getCumple() {
            return cumple;
        }
        public void setCumple(boolean cumple) {
            this.cumple = cumple;
        }
    }

    private int contarUnicoHijo(BinaryTree<Integer> a){

        return 0;
    }

    private Resultado buscarArbol(BinaryTree<Integer> a, int num){
        // Primero debería de encontrar el arbol con el valor num
        if(a.getData() == num){
            int ramaIzq = -1;
            int ramaDer = -1;
            //Cuando lo encuentra cuenta la cantidad de arboles con hijos unicos en cada rama
            if(a.hasLeftChild()){
                ramaIzq = contarUnicoHijo(a.getLeftChild());
            }
            if(a.hasRightChild()){
                ramaDer = contarUnicoHijo(a.getRightChild());
            }
            boolean cumple = ramaIzq > ramaDer;
            // Retorna la condición que pide el ejercicio
            return new Resultado(true,cumple);
        }else{
            //Si no es, sigo buscando
            if (a.hasLeftChild()) {
                // Creo un resultado para buscar el izq
                Resultado res = buscarArbol(a.getLeftChild(), num);
                // Si encuentro corto de una
                if(res.getEncontrado()) return res;
            }
            if(a.hasRightChild()){
                Resultado res = buscarArbol(a.getRightChild(), num);
                if(res.getEncontrado()) return res;
            }
            return new Resultado(false, false);
        }
    }

    public boolean isLeftTree(int num){
        Resultado res = buscarArbol(arbol, num);
        return res.getEncontrado() && res.getCumple();
    }
}
