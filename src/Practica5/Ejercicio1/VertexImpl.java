package Practica5.Ejercicio1;

public class VertexImpl<T> implements Vertex<T>{
    private T data;
    private int position;

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
    
}
