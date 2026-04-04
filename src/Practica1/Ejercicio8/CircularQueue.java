package src.Practica1.Ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class CircularQueue<T> extends Queue<T>{
    private List<T> lista;

    public CircularQueue(){
        lista = new ArrayList<T>();
    }

    public T shift(){
        if (isEmpty()) {
            throw new RuntimeException("La cola está vacía");
        }else{
            T dato = dequeue();
            enqueue(dato);
            return dato;
        }
    }
    
}
