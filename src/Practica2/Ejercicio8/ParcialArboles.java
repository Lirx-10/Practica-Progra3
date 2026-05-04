package src.Practica2.Ejercicio8;

import src.util.Practica2.ArbolUtils;
import src.Practica2.Ejercicio1y2.*;

public class ParcialArboles {
    

    // La parte inicial de arbol2 tiene que ser igual a la del arbol1, basicamente como que arbol2 contiene a arbol1
    /* Debería de recorrer ambos arboles al mismo tiempo? e ir comparando sus nodos?
    Pero eso no quedaría extraño? NO, estaría correcto, se asume que siempre el arbol1 es más "chico" que el arbol2
    entonces el recorrido tiene que hacerse mientras el arbol1 exista y tenga nodos.
    además, el arbol2 tiene que tener si o si los mismos nodos que el 1, entonces si en algún momento no coincide
    corta y devuelve false, en el mientras tanto debería de continuar
    Ahora, puedo recorrer ambos arboles al mismo tiempo e ir comparandolos? gran pregunta que no tiene respuesta(mentira)

     */
    public static boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        boolean resultado = false;
        if(arbol1.getData().equals(arbol2.getData())){
            resultado = true;
        }
        
        if(arbol1.hasLeftChild() && resultado){
            if(arbol2.hasLeftChild()){
                resultado = esPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild());
            }else{
                resultado = false;
            }
        }
        if(arbol1.hasRightChild() && resultado){
            if(arbol2.hasRightChild()){
                resultado = esPrefijo(arbol1.getRightChild(), arbol2.getRightChild());
            }else{
                resultado = false;
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> arbol2 = ArbolUtils.generarArbol(4);

        BinaryTree<Integer> prefijo = ArbolUtils.generarPrefijo(arbol2);
        BinaryTree<Integer> noPrefijoValor = ArbolUtils.generarNoPrefijoPorValor(arbol2);
        BinaryTree<Integer> noPrefijoEstructura = ArbolUtils.generarNoPrefijoPorEstructura(arbol2);

        System.out.println("Arbol 2: ");
        ArbolUtils.imprimirArbolConEtiquetas(arbol2);
        //System.out.println("Prefijo: ");
        //ArbolUtils.imprimirArbolConEtiquetas(prefijo);
        //System.out.println("no prefijo por valor: ");
        //ArbolUtils.imprimirArbolConEtiquetas(noPrefijoValor);
        System.err.println("No prefijo por estructura: ");
        ArbolUtils.imprimirArbolConEtiquetas(noPrefijoEstructura);

        System.out.println(esPrefijo(noPrefijoEstructura, arbol2));
    }
}
