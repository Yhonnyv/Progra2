package Estaticas.Colas;


import Estaticas.Pilas.PilaTDA;
import Estaticas.Pilas.PilaTI;

public class mainCola {
    public static void main(String[] args) {
        ColaTDA colita= new ColaPI();
        colita.InicializarCola();
        colita.Acolar(9);
        colita.Acolar(2);
        colita.Acolar(3);
        colita.Acolar(4);
        MetodosPractica.mostrarCola(colita);
        System.out.println("Ahora pasaremos a una pila con resultado:");
        PilaTDA pila= new PilaTI();
        pila=MetodosPractica.pasarColaPila(colita);
        Estaticas.Pilas.MetodosPractica.mostrarPila(pila);



    }






    }

