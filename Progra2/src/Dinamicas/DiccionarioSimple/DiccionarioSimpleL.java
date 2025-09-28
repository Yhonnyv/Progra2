package Dinamicas.DiccionarioSimple;


import Estaticas.Conjuntos.ConjuntoA;
import Estaticas.Conjuntos.ConjuntoTDA;
import Estaticas.Diccionarios.DiccionarioSimpleTDA;

public class DiccionarioSimpleL implements DiccionarioSimpleTDA {
    private class NodoClave {
        int clave;
        int valor;
        NodoClave sigClave;
    }

    private NodoClave origen;

    public void InicializarDiccionario() {
        origen = null;
    }

    public void Agregar(int clave, int valor) {
        NodoClave nc = Clave2Nodo(clave);
        if (nc == null) {   // clave no existe → la creo
            nc = new NodoClave();
            nc.clave = clave;
            nc.valor = valor;
            nc.sigClave = origen;
            origen = nc;
        } else {            // clave ya existe → sobreescribo el valor
            nc.valor = valor;
        }
    }

    public void Eliminar(int clave) {
        if (origen != null) {
            if (origen.clave == clave) {
                origen = origen.sigClave;
            } else {
                NodoClave aux = origen;
                while (aux.sigClave != null && aux.sigClave.clave != clave) {
                    aux = aux.sigClave;
                }
                if (aux.sigClave != null) {
                    aux.sigClave = aux.sigClave.sigClave;
                }
            }
        }
    }

    public int Recuperar(int clave) {
        NodoClave nc = Clave2Nodo(clave);
        return nc.valor;
    }

    public ConjuntoTDA Claves() {
        ConjuntoTDA c = new ConjuntoA();
        c.InicializarConjunto();
        NodoClave aux = origen;
        while (aux != null) {
            c.Agregar(aux.clave);
            aux = aux.sigClave;
        }
        return c;
    }

    private NodoClave Clave2Nodo(int clave) {
        NodoClave aux = origen;
        while (aux != null && aux.clave != clave) {
            aux = aux.sigClave;
        }
        return aux;
    }
}
