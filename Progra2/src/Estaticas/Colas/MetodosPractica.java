package Estaticas.Colas;

import Estaticas.Pilas.PilaTDA;
import Estaticas.Pilas.PilaTI;

public class MetodosPractica {
    public static ColaTDA copiarCola (ColaTDA cola) {
        ColaTDA aux = new ColaPI();
        aux.InicializarCola();

        while (!cola.ColaVacia()){
            aux.Acolar(cola.Primero());
            cola.Desacolar();
        }
        ColaTDA copia= new ColaPI();
        copia.InicializarCola();
        while (!aux.ColaVacia()){
            copia.Acolar(aux.Primero());
            cola.Acolar(aux.Primero());
            aux.Desacolar();
        }
        return copia;
    }
    public static PilaTDA pasarCola (ColaTDA cola){
        PilaTDA resultado= new PilaTI();
        resultado.InicializarPila();
        while (!cola.ColaVacia()){
            resultado.Apilar(cola.Primero());
            cola.Desacolar();
        }
        return resultado;

    }

    public static void mostrarCola (ColaTDA cola){
        ColaTDA aux= copiarCola(cola);
        while (!aux.ColaVacia()){
            System.out.println(aux.Primero());
            aux.Desacolar();
        }
    }
    public static PilaTDA pasarColaPila (ColaTDA cola){
        PilaTDA resultado= new PilaTI();
        resultado.InicializarPila();
        ColaTDA aux= copiarCola(cola);
        while (!aux.ColaVacia()){
            resultado.Apilar(aux.Primero());
            aux.Desacolar();
        }
        return resultado;
    }
    public static boolean esCapicua (ColaTDA cola){
        ColaTDA inicio= copiarCola(cola);
        PilaTDA pila= pasarColaPila(cola);
        while (!inicio.ColaVacia()){
            if (inicio.Primero()!=pila.Tope()){
                return false;
            }
            inicio.Desacolar();
            pila.Desapilar();
        }
        return true;
    }

}
