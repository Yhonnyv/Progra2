package Dinamicas.ColasPrioridad;

import Estaticas.ColasPrioridad.ColaPrioridadTDA;

public class ColasPrioridadLD implements ColaPrioridadTDA{
    class NodoPrioridad{
        int info;
        int Prioridad;
        NodoPrioridad sig;
    }

    NodoPrioridad primero;
    @Override
    public void InicializarCola() {
        primero=null;

    }

    @Override
    public void AcolarPrioridad(int x, int prioridad) {
        NodoPrioridad nuevo=new NodoPrioridad();
        nuevo.info=x;
        nuevo.Prioridad=prioridad;
        if (primero==null|| primero.Prioridad<prioridad){
            nuevo.sig=primero;
            primero=nuevo;
        }
        else{
            NodoPrioridad aux=primero;
            while (aux.sig!=null&&aux.sig.Prioridad>prioridad){
                aux=aux.sig;
            }
            nuevo.sig=aux.sig;
            aux.sig=nuevo;
        }

    }

    @Override
    public void Desacolar() {
        primero=primero.sig;
    }

    @Override
    public boolean ColaVacia() {
        return false;
    }

    @Override
    public int Primero() {
        return 0;
    }

    @Override
    public int Prioridad() {
        return 0;
    }
}
