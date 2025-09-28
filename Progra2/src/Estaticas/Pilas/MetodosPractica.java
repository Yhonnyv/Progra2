package Estaticas.Pilas;

import Estaticas.ColasPrioridad.ColaPrioridadDA;
import Estaticas.ColasPrioridad.ColaPrioridadTDA;
import Estaticas.Conjuntos.ConjuntoA;
import Estaticas.Conjuntos.ConjuntoTDA;

public class MetodosPractica {
    public static PilaTDA copiarPila(PilaTDA pila){
        PilaTDA aux= new PilaTI();
        aux.InicializarPila();
        while (!pila.PilaVacia()){
            aux.Apilar(pila.Tope());
            pila.Desapilar();
        }
        PilaTDA copia= new PilaTI();
        copia.InicializarPila();
        while (!aux.PilaVacia()){
            copia.Apilar(aux.Tope());
            pila.Apilar(aux.Tope());
            aux.Desapilar();
        }
        return copia;
    }
    public static PilaTDA pilaAsc (PilaTDA pila){
        PilaTDA aux= new PilaTI();
        aux.InicializarPila();
        while (!pila.PilaVacia()){
            int x= pila.Tope();
            pila.Desapilar();
            while (!aux.PilaVacia()&& aux.Tope()>x){
                pila.Apilar(aux.Tope());
                aux.Desapilar();
            }
            aux.Apilar(x);
        }
        return aux;

}
public static void mostrarPila (PilaTDA pila){
        PilaTDA aux= copiarPila(pila);
        while (!aux.PilaVacia()){
            int x=aux.Tope();
            aux.Desapilar();
            System.out.println(x);
        }
        }
public static PilaTDA pilaDesc (PilaTDA pila){
        PilaTDA aux= new PilaTI();
        aux.InicializarPila();
        while (!pila.PilaVacia()){
            int x= pila.Tope();
            pila.Desapilar();
            while (!aux.PilaVacia()&&aux.Tope()<x){
                pila.Apilar(aux.Tope());
                aux.Desapilar();
            }
            aux.Apilar(x);
        }return aux;
}
public static int contarPila (PilaTDA pila){
        PilaTDA aux= copiarPila(pila);
        int inx=0;
        while (!aux.PilaVacia()){
            inx++;
            aux.Desapilar();
        }
        return inx;
}
public static int sumarPila (PilaTDA pila){
        PilaTDA aux= copiarPila(pila);
        int total=0;
        while (!aux.PilaVacia()){
            total+=aux.Tope();
            aux.Desapilar();
        }
        return total;
}
public static int[] eliminarRepetidos (PilaTDA pila){
        int [] resultado= new int[10];
        ConjuntoTDA sinRepetidos= new ConjuntoA();
        sinRepetidos.InicializarConjunto();
        while (!pila.PilaVacia()){
            int x= pila.Tope();
            pila.Desapilar();
            sinRepetidos.Agregar(x);
        }
    ColaPrioridadTDA cola= new ColaPrioridadDA();
        cola.InicializarCola();
        while (!sinRepetidos.ConjuntoVacio()){
            int x= sinRepetidos.Elegir();
            sinRepetidos.Sacar(x);
            cola.AcolarPrioridad(x,x);

        }
        int i=0;
        while (!cola.ColaVacia()&&i<resultado.length){
            resultado[i++]=cola.Primero();
            cola.Desacolar();
        }
        return resultado;




}
}
