package Avaliacao2.AlgoritmoGenetico;

import Avaliacao2.AlimentarGrafo;
import Avaliacao2.GrafoExemplo01.Grafo;
import Avaliacao2.GrafoExemplo01.Vertice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class AlgoritmoGeneticoMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        AlimentarGrafo alimentarGrafo = new AlimentarGrafo();
        Grafo grafo = alimentarGrafo.padrao_25_vertices();

        ArrayList<Individuo> populacaoInicial = new ArrayList<>();

        int tamanhoPopulacao = 100;
        double porcentagemMutacao = 5;
        int nrGeracoes = 10;

        Individuo maisApto = null;
        int geracaoAlcancouMaisApto = -1;


        System.out.println("                                         >> RESUMO - PARAMETROS <<");
        System.out.println("      >> NUMERO DE GERACOES: " + nrGeracoes );
        System.out.println("      >> POPULACAO INICIAL: " + tamanhoPopulacao );
        System.out.println("      >> PERCENTAL MUTACOES: " + porcentagemMutacao + "%");

        System.out.println(">> -------------------------------------------------------------------------------------------------- <<\n");

        /*System.out.println("Origem >> ");
        String origem = input.next();

        System.out.println("Destino >> ");
        String destino = input.next();*/

        Vertice verticeOrigem = grafo.buscarVertice("A");
        Vertice verticeDestino = grafo.buscarVertice("O");

        System.out.println("START...");

        for (int index = 0; index < tamanhoPopulacao; index++) {
            populacaoInicial.add(new Individuo(grafo, verticeOrigem, verticeDestino));
        }
        System.out.println("POPULACAO INICIAL ADICIONADA...");

        System.out.println("\n>> -------------------------------------------------------------------------------------------------- <<\n");

        System.out.println("PROCESSANDO AS GERACOES...");
        for (int geracao = 0; geracao < nrGeracoes; geracao++) {

        }
        System.out.println(Arrays.toString(populacaoInicial.toArray()));
        Collections.sort(populacaoInicial);//Metodo de ordenação de listas do tipo individo.
        System.out.println(Arrays.toString(populacaoInicial.toArray()));
        System.out.println("\n>> -------------------------------------------------------------------------------------------------- <<\n");

    }

}
