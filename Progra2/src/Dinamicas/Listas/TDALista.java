package Dinamicas.Listas;

public interface TDALista {
    TDALista AgregarI (Nodo x,int num);
    boolean Existe (Nodo x, int num);
    void MostrarLista (Nodo x);
    void Eliminar (Nodo x, int num);

}
