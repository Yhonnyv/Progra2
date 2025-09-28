package Estaticas.Diccionarios;


import Estaticas.Conjuntos.ConjuntoA;
import Estaticas.Conjuntos.ConjuntoTDA;

public class DiccionarioSimpleA implements DiccionarioSimpleTDA{
    private Elemento [] elementos;
    private static int cant;
    @Override
    public void InicializarDiccionario() {
        elementos= new Elemento[100];
        cant=0;
    }

    @Override
    public void Agregar(int clave, int valor) {
        int pos= Clave2Ind(clave);
        if (pos==-1){
            pos=cant;
            elementos[pos]= new Elemento();
            elementos[pos].Clave= clave;
            cant++;
        }
        elementos[pos].Valor= valor;

    }

    @Override
    public void Eliminar(int clave) {
        int pos= Clave2Ind(clave);
        if (pos!=-1){
            elementos[pos]= elementos[cant-1];
            cant--;
        }
    }

    @Override
    public int Recuperar(int clave) {
        int pos= Clave2Ind(clave);
        return elementos[pos].Valor;
    }

    @Override
    public ConjuntoTDA Claves() {
        ConjuntoTDA c= new ConjuntoA();
        c.InicializarConjunto();
        for (int i=0; i<cant; i++){
            c.Agregar(elementos[i].Clave);
        }
        return c;
    }

    private int Clave2Ind (int clave){
        int i= cant-1;
        while (i>=0&&elementos[i].Clave!=clave) i--;
        return i;
    }

}
