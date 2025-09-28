package Dinamicas.Listas;

public class MetodosExternos {
    public static void mostrarLista (Nodo u){
        Nodo aux= new Nodo();
        aux=u;

        System.out.println("[");
        while(aux!=null){
            System.out.println(aux.info);
            aux=aux.sig;
            if (aux!=null){
                System.out.println(",");
            }
        }
        System.out.println("]");
    }

    public static void mostrarLista2 (Nodo u){
        System.out.println("[");
        if (u!=null){
            System.out.println(u.info+"]----->");
            mostrarLista2(u.sig);
        }
        else {
            System.out.println("]");
        }
    }
    public static Nodo insertarNodoPrincipio (Nodo u, int x){
        Nodo aux= new Nodo();
        aux.info=x;
        aux.sig=u;
        return aux;
    }
    public static Nodo inserNodoFinal (Nodo u, int x){
        Nodo nuevo=new Nodo();
        nuevo.info=x;
        if (u==null){
            return nuevo;
        }
        else{
            Nodo aux= u;
            while (aux.sig!=null){
                aux=aux.sig;
            }
            aux.sig=nuevo;
            return u;

        }}
    public static Nodo AgregarO (Nodo u, int x){
        Nodo nuevo= new Nodo();
        nuevo.info=x;
        if (u==null||u.info>x){
            nuevo.sig=u;
            return nuevo;
        }
        else{
            Nodo aux= u;
            while (aux.sig!=null&&aux.sig.info<x){
                aux=aux.sig;
            }
            nuevo.sig=aux.sig;
            aux.sig=nuevo;
            return u;
        }
    }
    public class Nodo {
        int info;
        Nodo sig;
    }
    public int sumaNodos (Nodo u){
        if (u==null) return 0;
        else{
            return (sumaNodos(u.sig)+u.info);
        }
    }


}
