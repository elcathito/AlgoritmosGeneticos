package testes;

import Avaliacao2.AlgoritmoGenetico.*;
import Avaliacao2.AlimentarGrafo;
import Avaliacao2.GrafoExemplo01.Aresta;
import Avaliacao2.GrafoExemplo01.Grafo;
import Avaliacao2.GrafoExemplo01.Vertice;

import java.util.*;

import static Avaliacao2.AlgoritmoGenetico.Prints.informacoesInicais;


public class Teste {
    public static void main(String[] args) {
        AlimentarGrafo alimentarGrafo = new AlimentarGrafo();
        Grafo grafo = alimentarGrafo.padrao_25_vertices();

        ArrayList<IndividuoCroList> populacaoInicial = new ArrayList<>();

        int tamanhoPopulacao = 100;
        double porcentagemMutacao = 5;
        int nrGeracoes = 10;

        informacoesInicais(nrGeracoes,tamanhoPopulacao,porcentagemMutacao);

        Vertice verticeOrigem = grafo.buscarVertice("A");
        Vertice verticeDestino = grafo.buscarVertice("O");

        System.out.println("START...");

        for (int index = 0; index < tamanhoPopulacao; index++) {
            populacaoInicial.add(new IndividuoCroList(verticeOrigem, verticeDestino));
        }
        System.out.println("POPULACAO INICIAL ADICIONADA...");
        printPop(populacaoInicial);
        System.out.println("\n>> -------------------------------------------------------------------------------------------------- <<\n");

        System.out.println("PROCESSANDO AS GERACOES...");
        List<? extends IndividuoAbs> novaPop = populacaoInicial;
        for (int geracao = 0; geracao < nrGeracoes; geracao++) {
            Map<Parametos, Integer> parametros = new HashMap<>();
            parametros.put(Parametos.NrDeRodadas, 10);
            parametros.put(Parametos.NrDeCompetidore, 15);
            novaPop =  Selecao.newSelecao().selecaoPorTorneio( novaPop, parametros, false);
        }
        printPop(novaPop);
        System.out.println("\n>> -------------------------------------------------------------------------------------------------- <<\n");

    }
    private static void printPop(List<? extends IndividuoAbs> pop) {
        for (IndividuoAbs ind : pop) {
            List<MapVerticeAresta> cromossomo = ((IndividuoCroList)ind).getCromossomo();
            System.out.print("Individo > ");
            System.out.println(Arrays.toString(cromossomo.toArray()));
            System.out.print(" Aptidão "+ind.getAptidao());
            System.out.println();
        }
    }
}
