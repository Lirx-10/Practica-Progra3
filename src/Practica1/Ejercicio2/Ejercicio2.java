package src.Practica1.Ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

    public static int[] devolverArreglo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero entero: ");
        int n = sc.nextInt();
        int[]vector = new int[n];
        for(int i = 0; i < n; i++){
            vector[i] = n*(i+1); 
        }

        return vector;
    }   

    public static void imprimirArreglo(int[]vector){
        for(int i = 0; i < vector.length; i++){
            System.out.println(vector[i]);
        }
    }
    
    public static void main(String[] args) {
        int[]v = devolverArreglo();
        imprimirArreglo(v);
    }
}
