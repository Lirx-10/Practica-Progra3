package src.util.Practica2;

import java.util.Random;
import src.Practica2.Ejercicio1y2.BinaryTree;

public class ArbolUtils {
    private static Random rand = new Random();

    // =========================
    // GENERADORES
    // =========================

    // Genera un árbol chico aleatorio
    public static BinaryTree<Integer> generarArbol(int profundidadMax) {
        return generarArbolRec(profundidadMax, 0);
    }

    private static BinaryTree<Integer> generarArbolRec(int max, int nivel) {
        if (nivel >= max) return null;

        if (nivel > 0 && rand.nextDouble() < 0.3) return null;

        BinaryTree<Integer> nodo = new BinaryTree<>(rand.nextInt(100));

        BinaryTree<Integer> izq = generarArbolRec(max, nivel + 1);
        BinaryTree<Integer> der = generarArbolRec(max, nivel + 1);

        if (izq != null) nodo.addLeftChild(izq);
        if (der != null) nodo.addRightChild(der);

        return nodo;
    }

    public static BinaryTree<Integer>[] generarDosArboles() {
        BinaryTree<Integer>[] arr = new BinaryTree[2];
        arr[0] = generarArbol(3);
        arr[1] = generarArbol(3);
        return arr;
    }

    // =========================
    // IMPRESIÓN (más clara)
    // =========================

    // Árbol girado (recomendado para debug)
    public static void imprimirArbol(BinaryTree<Integer> a) {
        imprimirArbolRec(a, 0);
    }

    private static void imprimirArbolRec(BinaryTree<Integer> a, int nivel) {
        if (a == null) return;

        imprimirArbolRec(a.getRightChild(), nivel + 1);

        for (int i = 0; i < nivel; i++) {
            System.out.print("   ");
        }
        System.out.println(a.getData());

        imprimirArbolRec(a.getLeftChild(), nivel + 1);
    }

    // Versión tipo árbol (mejorada)
    public static void imprimirArbolConEtiquetas(BinaryTree<Integer> a) {
        imprimirConEtiquetas(a, "", true);
    }

    private static void imprimirConEtiquetas(BinaryTree<Integer> a, String prefijo, boolean esUltimo) {
        if (a == null) return;

        System.out.println(prefijo + (esUltimo ? "└── " : "├── ") + a.getData());

        if (a.hasLeftChild() || a.hasRightChild()) {
            if (a.hasLeftChild()) {
                imprimirConEtiquetas(a.getLeftChild(), prefijo + (esUltimo ? "    " : "│   "), false);
            }
            if (a.hasRightChild()) {
                imprimirConEtiquetas(a.getRightChild(), prefijo + (esUltimo ? "    " : "│   "), true);
            }
        }
    }

    // =========================
    // PREFIJOS
    // =========================

    // Copia parcial válida (prefijo)
    public static BinaryTree<Integer> generarPrefijo(BinaryTree<Integer> original) {
        if (original == null) return null;

        BinaryTree<Integer> copia = new BinaryTree<>(original.getData());

        if (original.hasLeftChild() && rand.nextDouble() < 0.7) {
            copia.addLeftChild(generarPrefijo(original.getLeftChild()));
        }

        if (original.hasRightChild() && rand.nextDouble() < 0.7) {
            copia.addRightChild(generarPrefijo(original.getRightChild()));
        }

        return copia;
    }

    // Rompe por valor (seguro)
    public static BinaryTree<Integer> generarNoPrefijoPorValor(BinaryTree<Integer> original) {
        BinaryTree<Integer> copia = generarPrefijo(original);
        if (copia != null) {
            copia.setData(copia.getData() + 1);
        }
        return copia;
    }

    // Rompe por estructura (BIEN hecho)
    public static BinaryTree<Integer> generarNoPrefijoPorEstructura(BinaryTree<Integer> original) {
        if (original == null) return null;

        BinaryTree<Integer> copia = clonarCompleto(original);

        // Forzamos diferencia estructural REAL
        romperEstructura(copia);

        return copia;
    }

    // Clon completo del árbol
    private static BinaryTree<Integer> clonarCompleto(BinaryTree<Integer> a) {
        if (a == null) return null;

        BinaryTree<Integer> nuevo = new BinaryTree<>(a.getData());

        if (a.hasLeftChild()) {
            nuevo.addLeftChild(clonarCompleto(a.getLeftChild()));
        }

        if (a.hasRightChild()) {
            nuevo.addRightChild(clonarCompleto(a.getRightChild()));
        }

        return nuevo;
    }

    // Acá rompemos estructura posta
    private static void romperEstructura(BinaryTree<Integer> a) {
        if (a == null) return;

        // Caso 1: eliminar un hijo existente
        if (a.hasLeftChild()) {
            a.addLeftChild(null); // esto rompe seguro
            return;
        }

        if (a.hasRightChild()) {
            a.addRightChild(null);
            return;
        }

        // Caso 2: si es hoja, le agregamos un hijo
        a.addLeftChild(new BinaryTree<>(999));
    }
}

/*COMO USARLO
import util.ArbolUtils;
import src.Practica2.Ejercicio1y2.BinaryTree;

public class Test {
    public static void main(String[] args) {

        BinaryTree<Integer>[] arboles = ArbolUtils.generarDosArboles();

        System.out.println("Árbol 1:");
        ArbolUtils.imprimirArbolConEtiquetas(arboles[0]);

        System.out.println("\nÁrbol 2:");
        ArbolUtils.imprimirArbolConEtiquetas(arboles[1]);
    }
} */

/*EJEMPLO DE USO METODOS PREFIJOS
import util.ArbolUtils;
import src.Practica2.Ejercicio1y2.BinaryTree;

public class TestPrefijo {
    public static void main(String[] args) {

        BinaryTree<Integer> arbol2 = ArbolUtils.generarArbol(4);

        BinaryTree<Integer> prefijo = ArbolUtils.generarPrefijo(arbol2);
        BinaryTree<Integer> noPrefijoValor = ArbolUtils.generarNoPrefijoPorValor(arbol2);
        BinaryTree<Integer> noPrefijoEstructura = ArbolUtils.generarNoPrefijoPorEstructura(arbol2);

        System.out.println("Árbol 2:");
        ArbolUtils.imprimirArbolConEtiquetas(arbol2);

        System.out.println("\nPrefijo válido:");
        ArbolUtils.imprimirArbolConEtiquetas(prefijo);

        System.out.println("\nNo prefijo (valor):");
        ArbolUtils.imprimirArbolConEtiquetas(noPrefijoValor);

        System.out.println("\nNo prefijo (estructura):");
        ArbolUtils.imprimirArbolConEtiquetas(noPrefijoEstructura);
    }
} */