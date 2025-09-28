package Estaticas.ColasPrioridad;

import Estaticas.Colas.ColaPI;
import Estaticas.Colas.ColaTDA;

public class MetodosPractica {

    // Ejercicio: pasar los valores de una cola con prioridad origen a una cola normal
    //valores y de las prioridades correspondientes a una cola normal prioridades.

    public ColaTDA pasarPrioridad (ColaPrioridadTDA cola){
        ColaTDA resultado= new ColaPI();
        resultado.InicializarCola();

        while (!cola.ColaVacia()){
            int x= cola.Prioridad();
            resultado.Acolar(x);
            cola.Desacolar();
        }
    return resultado;

    }

    public ColaTDA pasarValores (ColaPrioridadTDA cola){
        ColaTDA resultado= new ColaPI();
        resultado.InicializarCola();

        while (!cola.ColaVacia()){
            int x= cola.Primero();
            resultado.Acolar(x);
            cola.Desacolar();
        }
        return resultado;

    }


}
