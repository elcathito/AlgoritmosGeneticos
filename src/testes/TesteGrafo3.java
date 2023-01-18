package testes;

import Avaliacao2.AlgoritmoGenetico.AlgoritmoGenetico;
import Avaliacao2.Grafo3.Grafo;

public class TesteGrafo3 {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(25, 17);
        StringBuilder builder = new StringBuilder();
        builder.append("Grafo\n").append(grafo);
        AlgoritmoGenetico algoritmoGenetico = new AlgoritmoGenetico(grafo);
        String resultado1 = algoritmoGenetico.start(5, 24, 20, 10, 100, 5, 100);
        String resultado2 = algoritmoGenetico.start(5, 24, 20, 5, 100, 5, 100);
        String resultado3 = algoritmoGenetico.start(5, 24, 10, 10, 100, 5, 100);
        String resultado4 = algoritmoGenetico.start(5, 24, 10, 5, 100, 5, 100);

        builder.append(resultado1).append("\n");
        builder.append(resultado2).append("\n");
        builder.append(resultado3).append("\n");
        builder.append(resultado4).append("\n");

        System.out.println(builder);
    }

}

