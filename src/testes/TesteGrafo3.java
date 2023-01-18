package testes;

import Avaliacao2.AlgoritmoGenetico.Parametos;
import Avaliacao2.AlgoritmoGenetico.individuo.IndividuoAd;
import Avaliacao2.AlgoritmoGenetico.individuo.IndividuoAbs;
import Avaliacao2.Grafo3.Aresta;
import Avaliacao2.Grafo3.Grafo;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static Avaliacao2.AlgoritmoGenetico.Prints.informacoesInicais;
import static Avaliacao2.AlgoritmoGenetico.selecao.Selecao.newSelecao;

public class TesteGrafo3 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Grafo grafo = new Grafo(25, 25);
        System.out.println(grafo);
        System.out.println(grafo.getAresta(5, 24));
        System.out.println();

        Random random = new Random();


        ArrayList<IndividuoAbs> populacaoInicial = new ArrayList<>();

        int tamanhoPopulacao = 1000;
        double porcentagemMutacao = 5;
        int nrGeracoes = 100;

        informacoesInicais(nrGeracoes, tamanhoPopulacao, porcentagemMutacao);

        int verticeOrigem = 5;
        int verticeDestino = 70;

        System.out.println("START...");

        for (int index = 0; index < tamanhoPopulacao; index++) {
            populacaoInicial.add(new IndividuoAd(grafo, verticeOrigem, verticeDestino));
        }
        System.out.println("POPULACAO INICIAL ADICIONADA...");
        /*printPop(populacaoInicial);*/
        System.out.println("\n>> -------------------------------------------------------------------------------------------------- <<\n");

        System.out.println("PROCESSANDO AS GERACOES...");
        List<IndividuoAbs> novaPop = populacaoInicial;
        for (int geracao = 0; geracao < nrGeracoes; geracao++) {
            Map<Parametos, Integer> parametros = new HashMap<>();
            parametros.put(Parametos.NrDeRodadas, 10);
            parametros.put(Parametos.NrDeCompetidore, 15);
            List<IndividuoAbs> elite = newSelecao().elitismo(novaPop, 3);
            List<IndividuoAbs> torneio = newSelecao().selecaoPorTorneio(novaPop, parametros, false);
            novaPop.clear();
            novaPop.addAll(elite);
            novaPop.addAll(torneio);

            List<IndividuoAbs> novaPopFilho = new ArrayList<>();
            int sizeNovaPop = novaPop.size();
            for (int i = 0; i < sizeNovaPop; i++) {
                IndividuoAd pai1 = (IndividuoAd) novaPop.get(random.nextInt(sizeNovaPop));
                IndividuoAd pai2 = (IndividuoAd) novaPop.get(random.nextInt(sizeNovaPop));
                crossover(pai1.getCromossomo(), pai2.getCromossomo(), novaPopFilho);
            }
            novaPop.addAll(novaPopFilho);

//            System.out.println("Geração nr" + geracao);
//            printPop(novaPop);
        }

        System.out.println("\n>> -------------------------------------------------------------------------------------------------- <<\n");
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;

        System.out.println("Execution time in milliseconds: " + timeElapsed);
    }

    private static void printPop(List<? extends IndividuoAbs> pop) {
        for (IndividuoAbs ind : pop) {
            List<Aresta> cromossomo = ((IndividuoAd) ind).getCromossomo();
            System.out.print("Individo > ");
            System.out.println(Arrays.toString(cromossomo.toArray()));
            System.out.print(" Aptidão " + ind.getAptidao());
            System.out.println();
        }
    }

    private static void crossover(List<Aresta> cromossomoP1, List<Aresta> cromossomoP2, List<IndividuoAbs> novaPopFilho) {
        boolean stop = false;
        int verticeIntercecaoPai1 = -1;
        int verticeIntercecaoPai2 = -1;

        for (Aresta aresta : cromossomoP1) {
            for (Aresta arestas : cromossomoP2) {
                if (aresta.getVerticeOrigem() == arestas.getVerticeOrigem()) {
                    verticeIntercecaoPai1 = cromossomoP1.indexOf(aresta);
                    verticeIntercecaoPai2 = cromossomoP2.indexOf(arestas);
                    stop = true;
                    break;
                }
            }
            if (stop) {
                break;
            }
        }

        if (verticeIntercecaoPai2 == -1) {
            verticeIntercecaoPai1 = new Random().nextInt(cromossomoP1.size());
            verticeIntercecaoPai2 = new Random().nextInt(cromossomoP2.size());
        }


        List<Aresta> cromossoFilho1 = new ArrayList<>();
        List<Aresta> cromossoFilho2 = new ArrayList<>();

        for (int i = 0; i < verticeIntercecaoPai1; i++) {
            cromossoFilho1.add(cromossomoP1.get(i));
        }
        for (int i = verticeIntercecaoPai2; i < cromossomoP2.size(); i++) {
            cromossoFilho1.add(cromossomoP2.get(i));
        }


        for (int i = 0; i < verticeIntercecaoPai2; i++) {
            cromossoFilho2.add(cromossomoP2.get(i));
        }
        for (int i = verticeIntercecaoPai1; i < cromossomoP1.size(); i++) {
            cromossoFilho2.add(cromossomoP1.get(i));
        }

        AtomicInteger aptidaoFilho1 = new AtomicInteger();
        cromossoFilho1.forEach(
                aresta -> {
                    aptidaoFilho1.addAndGet(aresta.getPeso());
                }
        );

        AtomicInteger aptidaoFilho2 = new AtomicInteger();
        cromossoFilho2.forEach(
                aresta -> {
                    aptidaoFilho2.addAndGet(aresta.getPeso());
                }
        );

        IndividuoAd indFilho1 = new IndividuoAd(cromossoFilho1, aptidaoFilho1.get());
        IndividuoAd indFilho2 = new IndividuoAd(cromossoFilho1, aptidaoFilho1.get());
        novaPopFilho.add(indFilho1);
        novaPopFilho.add(indFilho2);
    }

}

