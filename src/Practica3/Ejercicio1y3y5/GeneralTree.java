package src.Practica3.Ejercicio1y3y5;

import java.util.*;
import src.Practica1.Ejercicio8.Queue;

public class GeneralTree<T> {
    private T data;
    private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();
    
    public GeneralTree(){}

    public GeneralTree(T data){
        this.data = data;
    }
    public GeneralTree(T data, List<GeneralTree<T>> hijos){
        this(data);
        this.children = hijos;
    }

    public void setData(T data){
        this.data = data;
    }
    public T getData(){
        return this.data;
    }

    public void setChildren(List<GeneralTree<T>> wachines){
        if(children != null){
            this.children = wachines;
        }
    }
    public List<GeneralTree<T>> getChildren(){
        return this.children;
    }

    public void addChild(GeneralTree<T> wachin){
        this.children.add(wachin);
    }
    public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren()) {
			List<GeneralTree<T>> children = this.getChildren();
			if (children.contains(child))
				children.remove(child);
		}
	}

    public boolean hasChildren(){
        if((!this.children.isEmpty()) & (this.children != null)){
            return true;
        }else{
            return false;
        }
    }

    public boolean isEmpty(){
        if(this.data == null & hasChildren()==false){
            return true;
        }else{
            return false;
        }
    }

    public boolean isLeaf(){
        if(hasChildren()==false){
            return true;
        }else{
            return false;
        }
    }

    //Ejercicio 3
    public int altura(){
        if (this.isLeaf()){
            return 0;
        }
        int maxAltura = 0;
        for(GeneralTree<T> child : this.getChildren()){
            int Altura = child.altura();
            if(Altura > maxAltura){
                maxAltura = Altura;
            }
        }
        return maxAltura + 1;
    }

    public int nivel(T dato){
        int nivel = 0;
        GeneralTree<T> aux;
        Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
        queue.enqueue(this);
        queue.enqueue(null);
        while (!queue.isEmpty()) {
            aux = queue.dequeue();
            if (aux != null) {
                if (aux.getData() == dato) {
                    return nivel;
                }
                for (GeneralTree<T> child : aux.getChildren()) {
                    queue.enqueue(child);
                }
            } else {
                if (!queue.isEmpty()) {
                    queue.enqueue(null);
                    nivel++;
                }
            }
        }
        return -1;
    }

    public int ancho(){

        return 0;
    }

    //Ejercicio 5
    public GeneralTree<T> buscarNodo(GeneralTree<T> arbol,T dato){
        if(arbol.getData() == dato){
            return arbol;
        }
        
        for(GeneralTree<T>child : arbol.getChildren()){
            GeneralTree<T> aux = buscarNodo(child, dato);
            if(aux != null){
                return aux;
            }
        }
        return null;
    }

    public boolean esAncestro(T a, T b){
        GeneralTree<T> nodoA = this.buscarNodo(this,a);
        
        return false;
    }
}
