package Dinamicas.pilas;

import Estaticas.Pilas.PilaTDA;

public class PilaLD implements PilaTDA {
    class Nodo { //la celula de la estructura
        int info; // el valor almacenado
        Nodo sig; // la referencia al siguiente nodo
    }

    Nodo primero; // la referencia a la estructura
    @Override
    public void InicializarPila() {
        primero=null;

    }

    @Override
    public void Apilar(int x) {
        Nodo nuevo= new Nodo();
        nuevo.info=x;
        nuevo.sig=primero;
        primero=nuevo; // nueva referencia a la estructura

    }

    @Override
    public void Desapilar() {
        primero = primero.sig;

    }

    @Override
    public boolean PilaVacia() {
        return (primero== null);
    }

    @Override
    public int Tope() {
        return (primero.info);
    }
}
