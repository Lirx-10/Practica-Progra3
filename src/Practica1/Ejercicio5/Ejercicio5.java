/*
5. Dado un arreglo de valores tipo entero se desea calcular el valor 
máximo, mínimo, y promedio en un único método. Escriba tres métodos 
de clase, donde respectivamente:
a. Devuelva lo pedido por el mecanismo de retorno de un método en 
Java ("return").
b. Devuelva lo pedido interactuando con algún parámetro 
(el parámetro no puede ser de tipo arreglo).
c. Devuelva lo pedido sin usar parámetros ni la sentencia "return".
 */
package src.Practica1.Ejercicio5;

public class Ejercicio5 {
    private static int maximo;
    private static int minimo;
    private static double promedio;
    
    public static int getMaximo() {
        return maximo;
    }
    public static void setMaximo(int maximo) {
        Ejercicio5.maximo = maximo;
    }
    public static int getMinimo() {
        return minimo;
    }
    public static void setMinimo(int minimo) {
        Ejercicio5.minimo = minimo;
    }
    public static double getPromedio() {
        return promedio;
    }
    public static void setPromedio(double promedio) {
        Ejercicio5.promedio = promedio;
    }
    
    // Inciso a-
    public static double[] calcular1(int[] v){
        double[] resultado = new double[3];
        resultado[0] = -1;
        resultado[1] = 9999;
        resultado[2] = 0;
        int total = 0;
        for(int i = 0; i < v.length ; i++ ){
            if(v[i]>resultado[0]){
                resultado[0]=v[i];
            }
            if (v[i]<resultado[1]) {
                resultado[1]=v[i];
            }
            total = total + v[i];
        }
        resultado[2]= (double) total / v.length;
        return resultado;
    }
    // Inciso b-
    public static void calcular2(int[]v, Resultado r){
        int total = 0;
        for(int i = 0; i< v.length ; i++){
            if(v[i]>r.getMaximo()){
                r.setMaximo(v[i]);
            }
            if (v[i]<r.getMinimo()) {
                r.setMinimo(v[i]);
            }
            total = total + v[i];
        }
        r.setPromedio((double) total / v.length);
    }
    // Inciso c-
    public static void calcular3(int[] v){
        int total = 0;
        setMaximo(-1);
        setMinimo(9999);
        setPromedio(0);
        for(int i= 0; i<v.length; i++){
            if (v[i]>getMaximo()) {
                setMaximo(v[i]);
            }
            if(v[i]<getMinimo()){
                setMinimo(v[i]);
            }
            total = total + v[i];
        }
        setPromedio((double)total/v.length);
    }


    public static void main(String[] args) {
        int[] v = new int[10];
        for(int i=0; i<v.length; i++){
            v[i] = i+1;
            System.out.println(v[i]);
        }
        // Inciso a-
        double[] resultado = calcular1(v);
        System.out.println("Maximo: "+resultado[0]+" Minimo: "+resultado[1]+" Promedio: "+resultado[2]);
        // Inciso b-
        Resultado r = new Resultado(-1,9999,0);
        calcular2(v, r);
        System.out.println("Maximo: "+r.getMaximo()+" Minimo: "+r.getMinimo()+" Promedio: "+r.getPromedio());
        // Inciso c- 
        calcular3(v);
        System.out.println("Maximo: "+getMaximo()+" Minimo: "+getMinimo()+" Promedio: "+getPromedio());
    }
}