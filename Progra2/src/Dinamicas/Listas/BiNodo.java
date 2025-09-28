package Dinamicas.Listas;

public class BiNodo {
    int info;
    BiNodo sig;
    BiNodo ant;


    public BiNodo(int info, BiNodo sig, BiNodo ant) {
        this.info = info;
        this.sig = null;
        this.ant = null;
    }


    public static BiNodo AgregarNodo (BiNodo u, int x){
        BiNodo n = new BiNodo(x, null, null);
        if (u==null) return n;
        BiNodo aux= u;
        while (aux.sig!=null){
            aux=aux.sig;
        }
        aux.sig=n;
        n.ant=aux;
        return u;
    }
}
