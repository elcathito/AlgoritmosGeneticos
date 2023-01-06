package Avaliacao2.AlgoritmoGenetico;

import Avaliacao2.AlimentarGrafo;
import Avaliacao2.GrafoExemplo01.Grafo;

import java.util.ArrayList;

public class AlgoritmoGeneticoMain {

    public static void main(String[] args) {

        AlimentarGrafo alimentarGrafo = new AlimentarGrafo();
        Grafo grafo = alimentarGrafo.padrao_25_vertices();

        ArrayList<Individuo> populacaoInicial = new ArrayList<>();

        int tamanhoPopulacao = 500;
        double porcentagemMutacao = 5;
        int nrGeracoes = 10;

        Individuo maisApto = null;
        int geracaoAlcancouMaisApto = -1;


        System.out.println("                                         >> RESUMO - PARAMETROS <<");
        System.out.println("      >> NUMERO DE GERACOES: " + nrGeracoes );
        System.out.println("      >> POPULACAO INICIAL: " + tamanhoPopulacao );
        System.out.println("      >> PERCENTAL MUTACOES: " + porcentagemMutacao + "%");

        System.out.println(">> -------------------------------------------------------------------------------------------------- <<\n");

        System.out.println("START...");
        for (int index = 0; index < tamanhoPopulacao; index++) {
            populacaoInicial.add(new Individuo(grafo));
        }
        System.out.println("POPULACAO INICIAL ADICIONADA...");

        System.out.println("\n>> -------------------------------------------------------------------------------------------------- <<\n");

        System.out.println("PROCESSANDO AS GERACOES...");
        for (int geracao = 0; geracao < nrGeracoes; geracao++) {

        }

        System.out.println("\n>> -------------------------------------------------------------------------------------------------- <<\n");

    }

}
