package src.Practica1.Ejercicio8;

import java.util.LinkedList;
import java.util.List;

/*a. Implemente en JAVA la clase Queue de acuerdo con la especificación dada en el
diagrama de clases. Defina esta clase dentro del paquete tp1.ejercicio8.
● Queue() Constructor de la clase
● enqueue(dato: T): Inserta el elemento al final de la cola
● dequeue():T Elimina el elemento del frente de la cola y lo retorna. Si la cola
está vacía se produce un error.
● head(): T Retorna  el elemento del frente de la cola. Si la cola está vacía se
produce un error.
● isEmpty(): boolean Retorna verdadero si la cola no tiene elementos y falso en
caso contrario
● size():int Retorna la cantidad de elementos de la cola.
● toString(): String Retorna los elementos de la cola en un String*/
public class Queue<T> implements Sequence{
    private List<T> lista;

    public Queue() {
        lista = new LinkedList<T>();
    }

    public void enqueue(T dato) {
        lista.add(dato);
    }

    public T dequeue(){
        if (isEmpty()){
            throw new RuntimeException("La cola está vacía");
        }else{
            return lista.remove(0);
        }   
    }

    public T head(){
        if (isEmpty()){
            throw new RuntimeException("La cola está vacía");
        }else{
            return lista.get(0);
        } 
    }

    public boolean isEmpty(){
        if (lista.isEmpty()) {
            return true;
        }else{
            return false;
        }
    }

    public int size(){
        return lista.size();
    }

    public String toString(){
        return lista.toString();
    }
}
