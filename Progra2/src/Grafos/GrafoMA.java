package Grafos;

import Estaticas.Conjuntos.ConjuntoA;
import Estaticas.Conjuntos.ConjuntoTDA;

public class GrafoMA implements GrafoTDA {

    static int n = 100;
    int [][] MAdy;                 // Matriz de adyacencia
    int [] Etiqs;                    // Vector para mapeo a índices
    int cantNodos;

    public void InicializarGrafo() {
        MAdy = new int [n][n];
        Etiqs = new int [n];
        cantNodos = 0;
    }

    public void AgregarVertice(int v) {
        Etiqs[cantNodos] = v;
        for (int i = 0; i <= cantNodos; i++) {   // Nueva fila en 0
            MAdy[cantNodos][i] = 0;             // Nueva columna en 0
            MAdy[i][cantNodos] = 0;
        }
        cantNodos++;
    }

    private int Vert2Indice(int v) {            // Mapeamos vértice a índice
        int i = cantNodos - 1;
        while (i >= 0 && Etiqs[i] != v)
            i--;
        return i;
    }
    public void EliminarVertice(int v) {             // "se pisa" la columna...
        int ind = Vert2Indice(v);
        for (int i = 0; i < cantNodos; i++)
            MAdy[i][ind] = MAdy[i][cantNodos - 1];
        for (int i = 0; i < cantNodos; i++)
            MAdy[ind][i] = MAdy[cantNodos - 1][i];  // ...y la fila
        Etiqs[ind] = Etiqs[cantNodos - 1];
        cantNodos--;
    }

    @Override
    public void AgregarArista(int v1, int v2, int p) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        MAdy[o][d] = p;
    }

    @Override
    public void EliminarArista(int v1, int v2) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        MAdy[o][d] = 0;
    }

    @Override
    public int PesoArista(int v1, int v2) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        return MAdy[o][d];
    }

    @Override
    public ConjuntoTDA Vertices() {
        ConjuntoTDA c = new ConjuntoA(); // o ConjuntoLD si es dinámica
        c.InicializarConjunto();
        for (int i = 0; i < cantNodos; i++) {
            c.Agregar(Etiqs[i]);
        }
        return c;
    }

    @Override
    public boolean ExisteArista(int v1, int v2) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        return MAdy[o][d] != 0;
    }
}

