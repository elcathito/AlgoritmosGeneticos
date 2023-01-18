package Avaliacao2.AlgoritmoGenetico;

import Avaliacao2.AlgoritmoGenetico.individuo.IndividuoAbs;
import Avaliacao2.AlgoritmoGenetico.individuo.IndividuoAd;
import Avaliacao2.Grafo3.Grafo;

import java.util.*;

import static Avaliacao2.AlgoritmoGenetico.recombinacao.Recombinacao.newRecombinacao;
import static Avaliacao2.AlgoritmoGenetico.selecao.Selecao.newSelecao;

public class AlgoritmoGenetico {
    private final ArrayList<IndividuoAbs> populacao;
    private final Grafo grafo;
    private final Random random;

    public AlgoritmoGenetico(Grafo grafo) {
        this.populacao = new ArrayList<>();
        this.grafo = grafo;
        this.random = new Random();
    }

    public String start(int verticeOrigem, int verticeDestino, int nrDeCompetidore, double pocentElite, int tamanhoPopulacao, double porcentagemMutacao, int nrGeracoes) {
        StringBuilder builder = new StringBuilder();
        long startTime = System.currentTimeMillis();
        populacao.clear();
//        informacoesInicais(nrGeracoes, tamanhoPopulacao, porcentagemMutacao);
//        System.out.println("START...");
        for (int index = 0; index < tamanhoPopulacao; index++) {
            populacao.add(new IndividuoAd(grafo, verticeOrigem, verticeDestino));
        }
        /*System.out.println("POPULACAO INICIAL ADICIONADA...");
        populacao.forEach(System.out::println);
        System.out.println("\n>> -------------------------------------------------------------------------------------------------- <<\n");
        System.out.println("PROCESSANDO AS GERACOES...");*/
        List<IndividuoAbs> novaPop = populacao;
        for (int geracao = 0; geracao < nrGeracoes; geracao++) {
            List<IndividuoAbs> elite = newSelecao().elitismo(tamanhoPopulacao, novaPop, pocentElite);
            List<IndividuoAbs> torneio = newSelecao().selecaoPorTorneio(tamanhoPopulacao, novaPop, nrDeCompetidore, false);
            novaPop.clear();
            novaPop.addAll(elite);
            novaPop.addAll(torneio);
            List<IndividuoAbs> novaPopFilho = new ArrayList<>();
            int sizeNovaPop = novaPop.size();

            for (int i = 0; i < sizeNovaPop; i++) {
                IndividuoAd pai1 = (IndividuoAd) novaPop.get(random.nextInt(sizeNovaPop));
                IndividuoAd pai2 = (IndividuoAd) novaPop.get(random.nextInt(sizeNovaPop));
                newRecombinacao().umPonto(pai1.getCromossomo(), pai2.getCromossomo(), novaPopFilho);
            }
            novaPop.addAll(novaPopFilho);
            /*System.out.println("Geração nr" + geracao);
            System.out.println("Melhor individo da geração");
            System.out.println(novaPop.get(0));*/
        }

//        System.out.println("\n>> -------------------------------------------------------------------------------------------------- <<\n");
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        return builder.append("Resultado\n")
                .append("Nr de gerações: ").append(nrGeracoes).append("\n")
                .append("Taxa de mutação: ").append(porcentagemMutacao).append("%\n")
                .append("Porcentagem da elite: ").append(pocentElite).append("%\n")
                .append("Nr de competidores: ").append(nrDeCompetidore).append(" individos\n")
                .append("Tamanho da População: ").append(tamanhoPopulacao).append(" individos\n")
                .append("Vertice de origem: ").append(verticeOrigem).append("\n")
                .append("Vertice de destino: ").append(verticeDestino).append("\n")
                .append("Tempo de execução: ").append(timeElapsed).append("mile segundos\n")
                .append("Melhor Individo: ").append(novaPop.get(0)).append("\n")
                .append("Nr de gerações até a convergencia: ").append(nrGeracoes).append("\n").toString();
//        System.out.println("Execution time in milliseconds: " + timeElapsed);
    }


}
