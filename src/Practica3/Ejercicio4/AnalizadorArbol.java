package src.Practica3.Ejercicio4;

import src.Practica1.Ejercicio8.*;
import src.Practica3.Ejercicio1y3y5.*;

public class AnalizadorArbol {
    
    public int devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol){
        GeneralTree<AreaEmpresa> aux;
        Queue<GeneralTree<AreaEmpresa>> queue = new Queue<GeneralTree<AreaEmpresa>>();
        queue.enqueue(arbol);
        queue.enqueue(null);
        int max = -1;
        int suma = 0;
        int cont = 0;
        int promedio;
        while(!queue.isEmpty()){
            aux = queue.dequeue();
            if(aux != null){
                suma = suma + aux.getData().getTardanza();
                cont++;
                for(GeneralTree<AreaEmpresa>child : aux.getChildren() ){
                    queue.enqueue(child);
                }
            }else{
                if (!queue.isEmpty()) {
                    queue.enqueue(null);
                    promedio = suma/cont;
                    if(promedio>max){
                        max = promedio;
                    }
                    suma = 0;
                    cont = 0;
                }
            }
        }
        return max;
    }
}
