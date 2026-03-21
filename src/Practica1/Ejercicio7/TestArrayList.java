package src.Practica1.Ejercicio7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import src.Practica1.Ejercicio3.*;

public class TestArrayList{

    public static void incisoB(){
        System.out.println("Usando ArrayList");
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        for(int i=0; i < numeros.size(); i++){
            System.out.println(numeros.get(i));
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("Usando LinkedList");
        LinkedList<Integer> nums = new LinkedList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        for (int i = 0; i < nums.size(); i++){
            System.out.println(nums.get(i));
        }
    }

    public static ArrayList<Estudiante> crearLista(){
        ArrayList <Estudiante> Estudiantes = new ArrayList<>();
        Estudiante e;
        for(int i= 0; i < 3; i++){
            e = new Estudiante("Leonel","Reynaga", "hola"+i, "email xd", "que mierda te importa");             
            Estudiantes.add(e);
        }
        return Estudiantes;
    }

    public static void main(String[] args) {
        // Inciso b--
        incisoB();
        /*
        b- Si se usa LinkedList funciona exactamente
        No hay diferencias significativas en la implementación del programa, 
        ya que tanto ArrayList como LinkedList implementan la interfaz List, 
        por lo que los métodos utilizados (add, get, iteración, etc.) son los mismos. 
        */

        // Inciso d-
        ArrayList<Estudiante> Estudiantes = crearLista();
        for(int i = 0; i < Estudiantes.size(); i++){
            System.out.print(Estudiantes.get(i).tusDatos());
            System.out.println("----------------------------------------------------------");
        }
    }
}