package src.Practica1.Ejercicio7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import src.Practica1.Ejercicio3.*;

public class TestArrayList{
    // Inciso d-
    public static ArrayList<Estudiante> crearLista(){
        ArrayList <Estudiante> Estudiantes = new ArrayList<>();
        Estudiante e;
        for(int i= 0; i < 3; i++){
            e = new Estudiante("Leonel","Reynaga", "hola"+i, "email xd", "que mierda te importa");             
            Estudiantes.add(e);
        }
        return Estudiantes;   
    }
    // Inciso f-
    public static boolean esCapicua(ArrayList<Integer> lista){
        //Recorre la mitad del vector
        for (int i= 0; i < (lista.size())/2; i++){
            // Compara el primero con el ultimo, así hasta llegar a la mitad.
            if (!(lista.get(i) == lista.get(lista.size()-i-1))) {
                return false;
            }
        }
        return true;
    }
    // Inciso g-
    public static boolean esPar(int n){
        if (n%2 == 1) {
            return false;
        }else{
            return true;
        }
    }
    public static List<Integer> calcularSucesion(int n){
        List<Integer> lista = new ArrayList<>();
        lista.add(n);
        if(n != 1){
            if (esPar(n)){
                List<Integer> resto = calcularSucesion(n/2);
                lista.addAll(resto);
                return lista;
            }else{ 
                List<Integer> resto = calcularSucesion(3*n+1);
                lista.addAll(resto);
                return lista;
            }
        }
        return lista;
    }
    // Inciso h-
    public void invertirArray(ArrayList<Integer> lista){
        
    }

    public static void main(String[] args) {
        // Inciso b--
        /* 
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
        b- Si se usa LinkedList funciona exactamente
        No hay diferencias significativas en la implementación del programa, 
        ya que tanto ArrayList como LinkedList implementan la interfaz List, 
        por lo que los métodos utilizados (add, get, iteración, etc.) son los mismos. 
        */
        // Inciso d-
        /*
        ArrayList<Estudiante> Estudiantes = crearLista();
        for(int i = 0; i < Estudiantes.size(); i++){
            System.out.print(Estudiantes.get(i).tusDatos());
            System.out.println("----------------------------------------------------------");
        }
        List<Estudiante> Estudiantes2 = new ArrayList<>(Estudiantes);
        // Inciso e-
        Estudiante e = new Estudiante("Leonel","Reynaga", "hola"+1, "email d", "que mierda te importa");             
        if (!Estudiantes2.contains(e)){
            Estudiantes2.add(e);
            System.out.println("Agrego el estudiante");
        }
        
        for(int i = 0; i < Estudiantes2.size(); i++){
            System.out.print(Estudiantes2.get(i).tusDatos());
            System.out.println("----------------------------------------------------------");
        }
         */
        // Inciso f- 
        /*
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(2);
        numeros.add(1);
        if (esCapicua(numeros)==true){
            System.out.println("Es capicua");
        }else{
            System.out.println("No es capicua");
        }
        */
        // Inciso g-
        /*
        List<Integer> lista = calcularSucesion(6);
        System.out.println(lista);
        */
        // Inciso h- 
        
    }
}