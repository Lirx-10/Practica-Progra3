package Parciales.Modulo2.Parcial2;

public class Resultados {
    int maxImperdible;
    int minOpcionales; 

    public Resultados(int maxImperdible, int minOpcionales){
        this.maxImperdible = maxImperdible;
        this.minOpcionales = minOpcionales;
    }

    public void setMaxImperdible(int maxImperdible){
        this.maxImperdible = maxImperdible;
    }
    public int getMaxImperdible(){
        return this.maxImperdible;
    }

    public void setMinOpcionales(int minOpcionales){
        this.minOpcionales = minOpcionales;
    }
    public int getMinOpcionales(){
        return this.minOpcionales;
    }
}
