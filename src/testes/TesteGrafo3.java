package testes;

import Avaliacao2.AlgoritmoGenetico.AlgoritmoGenetico;
import Avaliacao2.Grafo3.Grafo;

public class TesteGrafo3 {
    public static void main(String[] args) {

        Grafo grafo = new Grafo(25, 50);
        System.out.println(grafo);
        System.out.println(grafo.getAresta(5, 24));
        System.out.println();
        AlgoritmoGenetico algoritmoGenetico = new AlgoritmoGenetico(1000,5,100,25,17);
        new Thread(new Runnable() {
            @Override
            public void run() {
                algoritmoGenetico.start(5,24,10,15,3);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                algoritmoGenetico.start(24,4,10,15,3);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                algoritmoGenetico.start(5,24,10,15,3);
            }
        }).start();


        System.out.println("-------------------------------------------------------------------------------------------------------");

        System.out.println("-------------------------------------------------------------------------------------------------------");
        algoritmoGenetico.start(5,10,10,15,3);
        System.out.println("-------------------------------------------------------------------------------------------------------");
        algoritmoGenetico.start(5,7,10,15,3);


    }

}

