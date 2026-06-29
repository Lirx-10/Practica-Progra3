package Practica5.Ejercicio1;

public class VertexImpl<T> implements Vertex<T>{
    private T data;
    private int position;

    public VertexImpl(T data, int position){
        this.data = data;
        this.position = position;
    }

    @Override
    public T getData() {
        return this.data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position){
        this.position = position;
    }
    
}
