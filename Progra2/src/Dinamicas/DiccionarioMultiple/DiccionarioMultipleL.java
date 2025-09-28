package Dinamicas.DiccionarioMultiple;

import Estaticas.Conjuntos.ConjuntoA;
import Estaticas.Conjuntos.ConjuntoTDA;
import Estaticas.DiccionariosMultiples.DiccionarioMultipleTDA;


/////ejercicio modificar valores de NodoClave por ConjuntoTDA

public class DiccionarioMultipleL implements DiccionarioMultipleTDA {
    private class NodoValor {
        int valor;
        NodoValor sigValor;
    }

    private class NodoClave {
        int clave;
        NodoValor valores;   // inicio de la lista de valores de esta clave
        NodoClave sigClave;
    }

    private NodoClave origen;

    public void InicializarDiccionario() {
        origen = null;
    }

    public void Agregar(int clave, int valor) {
        NodoClave nc = Clave2Nodo(clave);
        if (nc == null) {   // no existe la clave → la creo
            nc = new NodoClave();
            nc.clave = clave;
            nc.valores = null;
            nc.sigClave = origen;
            origen = nc;
        }
        // inserto valor al principio de la lista de esa clave
        NodoValor nv = new NodoValor();
        nv.valor = valor;
        nv.sigValor = nc.valores;
        nc.valores = nv;
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

    public void EliminarValor(int clave, int valor) {
        NodoClave nc = Clave2Nodo(clave);
        if (nc != null && nc.valores != null) {
            if (nc.valores.valor == valor) {
                nc.valores = nc.valores.sigValor;
            } else {
                NodoValor aux = nc.valores;
                while (aux.sigValor != null && aux.sigValor.valor != valor) {
                    aux = aux.sigValor;
                }
                if (aux.sigValor != null) {
                    aux.sigValor = aux.sigValor.sigValor;
                }
            }
            // si la lista de valores queda vacía, elimino la clave
            if (nc.valores == null) {
                Eliminar(clave);
            }
        }
    }

    public ConjuntoTDA Recuperar(int clave) {
        ConjuntoTDA c = new ConjuntoA();
        c.InicializarConjunto();
        NodoClave nc = Clave2Nodo(clave);
        if (nc != null) {
            NodoValor nv = nc.valores;
            while (nv != null) {
                c.Agregar(nv.valor);
                nv = nv.sigValor;
            }
        }
        return c;
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
