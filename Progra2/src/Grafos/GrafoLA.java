package Grafos;

import Dinamicas.Conjuntos.ConjuntoLD;
import Estaticas.Conjuntos.ConjuntoTDA;

public class GrafoLA {
    class NodoGrafo {              // nodo verde
        int nodo;
        NodoArista arista;         // flecha roja
        NodoGrafo sigNodo;         // flecha verde
    }

    class NodoArista {             // nodo rojo
        int etiqueta;
        NodoGrafo nodoDestino;     // flecha verde de trazos
        NodoArista sigArista;      // flecha roja de trazos
    }
        NodoGrafo origen;

        public void InicializarGrafo() {
            origen = null;
        }

        public void AgregarVertice(int v) {      // El vértice se inserta al inicio de la lista de nodos
            NodoGrafo aux = new NodoGrafo();
            aux.nodo = v;
            aux.arista = null;
            aux.sigNodo = origen;
            origen = aux;
        }

        private NodoGrafo Vert2Nodo(int v) {     // Dado un valor, busca el nodo correspondiente
            NodoGrafo aux = origen;
            while (aux != null && aux.nodo != v)
                aux = aux.sigNodo;
            return aux;
        }

        public void AgregarArista(int v1, int v2, int peso) {
            // Buscamos el nodo origen...
            NodoGrafo n1 = Vert2Nodo(v1);
            // ...y el nodo destino
            NodoGrafo n2 = Vert2Nodo(v2);

            // La arista va al inicio de la lista de aristas salientes de v1
            NodoArista aux = new NodoArista();
            aux.etiqueta = peso;
            aux.nodoDestino = n2;
            aux.sigArista = n1.arista;
            n1.arista = aux;
        }

        private void EliminarAristaNodo(NodoGrafo nodo, int v) {
            NodoArista aux = nodo.arista;
            if (aux != null) {
                if (aux.nodoDestino.nodo == v) {             // Hay que eliminar la primera arista
                    nodo.arista = aux.sigArista;
                } else {
                    while (aux.sigArista != null && aux.sigArista.nodoDestino.nodo != v)
                        aux = aux.sigArista;
                    if (aux.sigArista != null)               // Eliminamos la arista
                        aux.sigArista = aux.sigArista.sigArista;
                }
            }
        }

        public void EliminarVertice(int v) {
            if (origen.nodo == v) {                          // Es el origen
                origen = origen.sigNodo;                     // Chau origen
            } else {
                NodoGrafo aux = origen;
                while (aux != null) {
                    this.EliminarAristaNodo(aux, v);          // Eliminamos aristas hacia v
                    if (aux.sigNodo != null && aux.sigNodo.nodo == v)
                        aux.sigNodo = aux.sigNodo.sigNodo;    // Si es el nodo, chau nodo
                    aux = aux.sigNodo;                        // Sigue eliminando aristas
                }
            }
        }

        public void EliminarArista(int v1, int v2) {
            NodoGrafo n1 = Vert2Nodo(v1);
            EliminarAristaNodo(n1, v2);                       // Listo
        }

    public int PesoArista(int v1, int v2) {
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoArista aux = n1.arista;
        while (aux.nodoDestino.nodo != v2)
            aux = aux.sigArista;
        return aux.etiqueta;                              // Buscamos la arista
    }
    public boolean ExisteArista(int v1, int v2) {
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoArista aux = n1.arista;
        while (aux != null && aux.nodoDestino.nodo != v2)
            aux = aux.sigArista;                // Buscamos la arista
        return (aux != null);
    }

    public ConjuntoTDA Vertices() {
        ConjuntoTDA c = new ConjuntoLD();
        c.InicializarConjunto();
        NodoGrafo aux = origen;
        while (aux != null) {
            c.Agregar(aux.nodo);
            aux = aux.sigNodo;
        }
        return c;
    }



}

////Ejercicio comun almacenar en vez de estructura enlazada pasarlo a conjunto
