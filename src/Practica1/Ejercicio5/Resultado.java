package src.Practica1.Ejercicio5;

public class Resultado {
    private int maximo;
    private int minimo;
    private double promedio;

    public Resultado(){}

    public Resultado(int maximo,int minimo, double promedio){
        this.maximo = maximo;
        this.minimo = minimo;
        this.promedio = promedio;
    }

    public int getMaximo() {
        return maximo;
    }
    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }   
    public int getMinimo() {
        return minimo;
    }
    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }
    public double getPromedio() {
        return promedio;
    }
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

}
