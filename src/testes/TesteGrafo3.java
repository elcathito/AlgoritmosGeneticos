package testes;

import Avaliacao2.AlgoritmoGenetico.Parametos;
import Avaliacao2.AlgoritmoGenetico.individuo.IndividuoAd;
import Avaliacao2.AlgoritmoGenetico.individuo.IndividuoAbs;
import Avaliacao2.AlgoritmoGenetico.selecao.Selecao;
import Avaliacao2.Grafo3.Aresta;
import Avaliacao2.Grafo3.Grafo;

import java.util.*;

import static Avaliacao2.AlgoritmoGenetico.Prints.informacoesInicais;

public class TesteGrafo3 {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(9, 15);
        System.out.println(grafo);

        System.out.println();

        System.out.println(grafo.getAresta(1, 8));


        ArrayList<IndividuoAbs> populacaoInicial = new ArrayList<>();

        int tamanhoPopulacao = 100;
        double porcentagemMutacao = 5;
        int nrGeracoes = 10;

        informacoesInicais(nrGeracoes, tamanhoPopulacao, porcentagemMutacao);

        int verticeOrigem = 1;
        int verticeDestino = 15;

        System.out.println("START...");

        for (int index = 0; index < tamanhoPopulacao; index++) {
            populacaoInicial.add(new IndividuoAd(grafo, verticeOrigem, verticeDestino));
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
            novaPop = Selecao.newSelecao().selecaoPorTorneio(novaPop, parametros, false);
        }
        printPop(novaPop);
        System.out.println("\n>> -------------------------------------------------------------------------------------------------- <<\n");

    }
    private static void printPop(List<? extends IndividuoAbs> pop) {
        for (IndividuoAbs ind : pop) {
            List<Aresta> cromossomo = ((IndividuoAd)ind).getCromossomo();
            System.out.print("Individo > ");
            System.out.println(Arrays.toString(cromossomo.toArray()));
            System.out.print(" Aptidão "+ind.getAptidao());
            System.out.println();
        }
    }
}

