package Estaticas.DiccionariosMultiples;

import Estaticas.Conjuntos.ConjuntoA;
import Estaticas.Conjuntos.ConjuntoTDA;
import Estaticas.Diccionarios.DiccionarioSimpleTDA;

public class MetodosExternos {
    public void pasaraMultiple (DiccionarioSimpleTDA origen, DiccionarioMultipleA destino){
        ConjuntoTDA claves= origen.Claves();
        while (!claves.ConjuntoVacio()){
            int x=claves.Elegir();
            claves.Sacar(x);
            int y=origen.Recuperar(x);
            origen.Eliminar(x);
            destino.Agregar(x,y);
        }
    }
}
