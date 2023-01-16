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

                if (r.nextInt(10)<2) valor = 0;//ALMENTA EM 20% A CHANCE DE VIR PESO 0
                grafo[i][j] = valor;
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
        return new Aresta(verticeOrigem,verticeDestino,grafo[verticeOrigem][verticeDestino]);
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder("\n                                             Matriz de adjacência\n");
        for (int[] content : grafo) {
            builder.append("[");
            for (int value :
                    content) {
                builder.append(String.format("%3d, ", value));
            }
            builder.append("]\n");

        }
        return builder.toString();
    }
}
