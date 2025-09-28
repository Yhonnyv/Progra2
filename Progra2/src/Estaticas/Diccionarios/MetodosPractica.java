package Estaticas.Diccionarios;

import Estaticas.Conjuntos.ConjuntoTDA;
import Estaticas.Pilas.PilaTDA;

public class MetodosPractica {
    public void PasaraPila (DiccionarioSimpleTDA dic, PilaTDA valores){
        ConjuntoTDA conjvalores= dic.Claves();
        while (!conjvalores.ConjuntoVacio()){
            int x=conjvalores.Elegir();
            conjvalores.Sacar(x);
            int y= dic.Recuperar(x);
            dic.Eliminar(x);
            valores.Apilar(y);
        }

    }
}
