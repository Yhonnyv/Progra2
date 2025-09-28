package Estaticas.DiccionariosMultiples;

import Estaticas.Conjuntos.ConjuntoTDA;

public interface DiccionarioMultipleTDA {
    void InicializarDiccionario(); // pre: no aplica.
    void Agregar(int clave, int valor); // pre: dic. inicializado.
    void Eliminar(int clave); // pre: dic. inicializado.
    void EliminarValor(int clave, int valor); // pre: dic. inicializado.
    ConjuntoTDA Recuperar(int clave); // pre: diccionario inicializado y clave existente.
    ConjuntoTDA Claves(); // pre: dic. inicializado.
}
