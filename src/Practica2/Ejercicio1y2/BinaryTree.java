package src.Practica2.Ejercicio1y2;

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
        if(!this.hasRighChild()){
            this.rightChild = null;
        }
    }
    public void removeLeftChild(){
        if(!this.hasLeftChild()){
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
        int cont = 0;
        if (isLeaf()){
            cont++;   
        }else{
            if(hasLeftChild()){
                cont = cont + contarHojas();
            }
            if(hasRighChild()){
                cont = cont + contarHojas();
            }
        }
        return cont;
    }

    // inciso b-
    public BinaryTree<T> espejo(){
        if (!isEmpty()) {
            
        }
        
        return null;
    }

}
