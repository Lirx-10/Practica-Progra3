package src.Practica3.Ejercicio1;

import java.util.*;

public class GeneralTree<T> {
    private T data;
    private List<GeneralTree<T>> children;
    
    public GeneralTree(){}

    public GeneralTree(T data){
        this.data = data;
    }
    public GeneralTree(T data, List<GeneralTree<T>> hijos){
        this.data = data;
        this.children = hijos;
    }

    public void setData(T data){
        this.data = data;
    }
}
