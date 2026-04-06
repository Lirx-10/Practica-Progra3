package src.Practica2.Ejercicio1y2;
import src.Practica1.Ejercicio8.Queue;

public class BinaryTree<T> {
    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;


    public BinaryTree(T data){
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void setData(T data){
        this.data = data;
    }
    public T getData(){
        return this.data;
    }

    public BinaryTree<T> getRightChild(){
        if (this.hasRighChild()){
            return rightChild;
        }else{
            throw new RuntimeException("No existe hijo derecho");
        }
    }
    public BinaryTree<T> getLeftChild(){
        if (this.hasLeftChild()){
            return leftChild;
        }else{
            throw new RuntimeException("No existe hijo izquierdo");
        }
    }

    public void addRightChild(BinaryTree<T> derecho){
        this.rightChild = derecho;
    }
    public void addLeftChild(BinaryTree<T> zurdo){
        this.leftChild = zurdo;
    }

    public boolean hasRighChild(){
        return this.rightChild != null;
    }
    public boolean hasLeftChild(){
        return this.leftChild != null;
    }

    public void removeRightChild(){
        if(this.hasRighChild()){
            this.rightChild = null;
        }
    }
    public void removeLeftChild(){
        if(this.hasLeftChild()){
            this.leftChild = null;
        }
    }

    public boolean isEmpty(){
        return (this.isLeaf() && this.getData() == null);
    }
    public boolean isLeaf(){
        return !this.hasLeftChild() && !this.hasRighChild();
    }

    // Ejercicio 2
    // inciso a-
    public int contarHojas(){
        if (isLeaf()){
            return 1;   
        }else{
            int cont = 0;
            if(hasLeftChild()){
                cont = cont + this.leftChild.contarHojas();
            }
            if(hasRighChild()){
                cont = cont + this.rightChild.contarHojas();
            }
            return cont;
        }
    }

    // inciso b-
    public BinaryTree<T> espejo(){
        BinaryTree<T> nuevo = new BinaryTree<>(this.getData());
        if (this.hasLeftChild()){
            nuevo.addRightChild(this.leftChild.espejo());
        }
        if (this.hasRighChild()){
            nuevo.addLeftChild(this.rightChild.espejo());
        }
        return nuevo;
    }

    // inciso c-
    public void entreNiveles(int n,int m){

        BinaryTree<T> ab = null;
        Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
        cola.enqueue(this);
        cola.enqueue(null);
        int cont = 1;
        while(!cola.isEmpty()){
            ab = cola.dequeue();
            if((ab != null) && (cont<=n) && (cont<=m)){
                System.out.print(ab.getData());
                if(ab.hasLeftChild()){
                    cola.enqueue(ab.getLeftChild());
                }
                if(ab.hasRighChild()){
                    cola.enqueue(ab.getRightChild());
                }
            }else if (!cola.isEmpty()){
                System.out.println();
                cola.enqueue(null);
            }
        }



    }

}
