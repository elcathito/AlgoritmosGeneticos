package testes;

import Avaliacao2.Grafo3.Grafo;

import java.util.Arrays;

public class TesteGrafo3 {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(100,15);
        System.out.println(grafo);

        System.out.println();

        System.out.println(grafo.getAresta(1,95));
    }
}
