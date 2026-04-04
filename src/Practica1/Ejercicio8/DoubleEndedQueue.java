package src.Practica1.Ejercicio8;


import java.util.List;

public class DoubleEndedQueue <T> extends Queue <T>{
    private List<T> lista;

    public DoubleEndedQueue(){
        super();
    }

    public void enqueueFirst(T dato){
        lista.add(0, dato);
    }

}
