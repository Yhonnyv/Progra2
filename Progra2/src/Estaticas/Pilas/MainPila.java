package Estaticas.Pilas;

public class MainPila {
    public static void main(String[] args) {


        PilaTI pili= new PilaTI();
        pili.InicializarPila();
        pili.Apilar(5);
        pili.Apilar(6);
        pili.Apilar(3);
        pili.Apilar(9);
        pili.Apilar(7);
        System.out.println("Primera pila");
        MetodosPractica.mostrarPila(pili);
        System.out.println("Pila ordenada");
        PilaTDA pilaOrdenada= MetodosPractica.pilaDesc(pili);
        System.out.println(MetodosPractica.sumarPila(pilaOrdenada));




    }
}
