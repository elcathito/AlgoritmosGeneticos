package Avaliacao2.Grafo3;

import java.util.*;

public class Grafo {

    private final int[][] grafo;
    private final int distMax;

    public Grafo(int nrVertices, int distMax) {
        this.distMax = distMax;
        this.grafo = new int[nrVertices][nrVertices];
        Random r = new Random();
        for (int i = 0; i < nrVertices; i++) {
            for (int j = 0; j < nrVertices; j++) {
                int valor;
                if (i == j) valor = 0;
                else if (i > j) valor = grafo[j][i];
                else valor = r.nextInt(distMax);


                grafo[i][j] = valor==0?Integer.MAX_VALUE:valor;
            }
        }
    }

    public int[][] getGrafo() {
        return grafo;
    }

    public int getDistMax() {
        return distMax;
    }

    public Aresta getAresta(int verticeOrigem, int verticeDestino) {

        return new Aresta(verticeOrigem, verticeDestino, grafo[verticeOrigem][verticeDestino]);
    }

    public int length() {
        return grafo.length;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder("\n                                             Matriz de adjacência\n");
        for (int[] content : grafo) {
            builder.append("[");
            for (int value :
                    content) {
                builder.append(String.format("%10d, ", value));
            }
            builder.append("]\n");

        }
        return builder.toString();
    }
}
