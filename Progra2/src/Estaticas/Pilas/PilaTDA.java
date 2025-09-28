package Estaticas.Pilas;

public interface PilaTDA {
    void InicializarPila(); // pre: no aplica.
    void Apilar (int x); // pre: pila inicializada
    void Desapilar ();// pre: pila inicializada y no vacía.
    boolean PilaVacia(); // pre: pila inicializa
    int Tope();// pre: pila inicializada y no vacía

}
