package src.Practica3.Ejercicio1y3;

import java.util.*;

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

    

}
