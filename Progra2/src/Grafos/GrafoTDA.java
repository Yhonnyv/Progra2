package Grafos;


import Estaticas.Conjuntos.ConjuntoTDA;

public interface GrafoTDA {
    void InicializarGrafo(); // Sin precondiciones
    void AgregarVertice(int v); // Grafo inicializado y no existe nodo v
    void EliminarVertice(int v); // Grafo inicializado y existe nodo v
    void AgregarArista(int v1, int v2, int p); // Grafo inicializado y no existe arista (v1, v2)
    void EliminarArista(int v1, int v2); // Grafo inicializado y existe arista (v1, v2)
    int PesoArista(int v1, int v2); // Grafo inicializado y existe arista (v1, v2)
    ConjuntoTDA Vertices(); // Grafo inicializado
    boolean ExisteArista(int v1, int v2); // Grafo inicializado y existen nodos v1, v2
}

