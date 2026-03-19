package src.Practica1.Ejercicio1;

public class Ejercicio1 {
    
    public static void conFor(int a, int b){
        for(int i = a; i<=b; i++){
            System.out.println(i);
        }
    }

    public static void conWhile(int a, int b){
        while(a<=b){
            System.out.println(a);
            a++;
        }
    }

    public static void conRecursion(int a, int b){
        if(a<=b){
            System.out.println(a);
            conRecursion(a+1, b);
        }
    }

    public static void main(String[] args) {
        System.out.println("Usando el for:");
        conFor(1,8);
        System.out.println("Usando el while:");
        conWhile(1,8);
        System.out.println("Usando recursión:");
        conRecursion(1, 8);
    }


}
