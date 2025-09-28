package Estaticas.Conjuntos;

public class MetodosExternos {
    public static ConjuntoTDA copiaConjunto(ConjuntoTDA conj){
        ConjuntoTDA resultado= new ConjuntoA();
        resultado.InicializarConjunto();
        ConjuntoTDA aux= new ConjuntoA();
        aux.InicializarConjunto();
        while (!conj.ConjuntoVacio()){
            int x= conj.Elegir();
            resultado.Agregar(x);
            aux.Agregar(x);
            conj.Sacar(x);
        }
        while (!aux.ConjuntoVacio()){
            int y= aux.Elegir();
            aux.Sacar(y);
            conj.Agregar(y);
        }
        return  resultado;
    }
    public void SacarTodos(ConjuntoTDA origen, ConjuntoTDA x){
        ConjuntoTDA aux= new ConjuntoA();
        aux.InicializarConjunto();
        while (!origen.ConjuntoVacio()){
            int y= origen.Elegir();
            origen.Sacar(y);
            if (!x.Pertenece(y)){
                aux.Agregar(y);
            }
        }
        while (!aux.ConjuntoVacio()){
            int y= aux.Elegir();
            aux.Sacar(y);
            origen.Agregar(y);
        }
         }


}
