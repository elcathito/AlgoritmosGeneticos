package testes;

import Avaliacao2.AlgoritmoGenetico.*;
import Avaliacao2.AlimentarGrafo;
import Avaliacao2.GrafoExemplo01.Aresta;
import Avaliacao2.GrafoExemplo01.Grafo;
import Avaliacao2.GrafoExemplo01.Vertice;

import java.util.*;


public class Teste {
    public static void main(String[] args) {
        AlimentarGrafo alimentarGrafo = new AlimentarGrafo();
        Grafo grafo = alimentarGrafo.padrao_25_vertices();

        ArrayList<IndividuoMap> populacaoInicial = new ArrayList<>();

        int tamanhoPopulacao = 100;
        double porcentagemMutacao = 5;
        int nrGeracoes = 10;

        System.out.println("                                         >> RESUMO - PARAMETROS <<");
        System.out.println("      >> NUMERO DE GERACOES: " + nrGeracoes);
        System.out.println("      >> POPULACAO INICIAL: " + tamanhoPopulacao);
        System.out.println("      >> PERCENTAL MUTACOES: " + porcentagemMutacao + "%");

        System.out.println(">> -------------------------------------------------------------------------------------------------- <<\n");
        Vertice verticeOrigem = grafo.buscarVertice("A");
        Vertice verticeDestino = grafo.buscarVertice("O");

        System.out.println("START...");

        for (int index = 0; index < tamanhoPopulacao; index++) {
            populacaoInicial.add(new IndividuoMap(verticeOrigem, verticeDestino));
        }
        System.out.println("POPULACAO INICIAL ADICIONADA...");
        printPop(populacaoInicial,verticeOrigem,verticeDestino);
        System.out.println("\n>> -------------------------------------------------------------------------------------------------- <<\n");

        System.out.println("PROCESSANDO AS GERACOES...");
        List<? extends IndividuoAbs> novaPop = populacaoInicial;
        for (int geracao = 0; geracao < nrGeracoes; geracao++) {
            Map<Parametos, Integer> parametros = new HashMap<>();
            parametros.put(Parametos.NrDeRodadas, 10);
            parametros.put(Parametos.NrDeCompetidore, 15);
            novaPop =  Selecao.newSelecao().selecaoPorTorneio( novaPop, parametros, false);
        }
        printPop(novaPop,verticeOrigem,verticeDestino);
        System.out.println("\n>> -------------------------------------------------------------------------------------------------- <<\n");

    }

    private static Vertice printInd(Map<Vertice, Aresta> rota, Vertice vertice,Vertice destino) {
        Aresta aresta = rota.get(vertice);
        if (vertice.equals(destino)){
            System.out.print("{" + vertice +"}");
            return null;
        }else {
            System.out.print("{" + vertice + " , " + aresta + "}, ");
        }
        return aresta.destino;
    }
    private static void printPop(List<? extends IndividuoAbs> pop,Vertice verticeOrigem,Vertice verticeDestino) {
        for (IndividuoAbs ind : pop) {
            Map<Vertice, Aresta> rota = ((IndividuoMap)ind).getCromossomo();
            int size = rota.size();
            Vertice vertice = verticeOrigem;
            System.out.print("Individo > ");
            while (size-- >= 0) {
                vertice = printInd(rota, vertice,verticeDestino);
            }
            System.out.print(" Aptidão "+ind.getAptidao());
            System.out.println();
        }
    }
}
