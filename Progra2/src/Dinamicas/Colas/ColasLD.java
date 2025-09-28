package Dinamicas.Colas;

import Estaticas.Colas.ColaTDA;

public class ColasLD implements ColaTDA{
    class Nodo {
        int info;
        Nodo sig;
    }
    Nodo Primero;
    Nodo Ultimo;

    @Override
    public void InicializarCola() {
        Primero= null;
        Ultimo= null;

    }

    @Override
    public void Acolar(int x) {
        Nodo nuevo= new Nodo();
        nuevo.info=x;
        nuevo.sig=null;
        if (Ultimo!=null){
            Ultimo.sig=nuevo;
        }
        Ultimo=nuevo;
        if (Primero==null){
            Primero=Ultimo;
        }
    }

    @Override
    public void Desacolar() {
        Primero= Primero.sig;
        if (Primero==null){
            Ultimo=null;
        }

    }

    @Override
    public boolean ColaVacia() {
        return (Ultimo==null);
    }

    @Override
    public int Primero() {
        return (Primero.info);
    }

    public void PasarElementos (ColaTDA c1, ColaTDA c2) {
        while (!c1.ColaVacia()) {
            c2.Acolar(c1.Primero());
            c1.Desacolar();
        }
    }

}
