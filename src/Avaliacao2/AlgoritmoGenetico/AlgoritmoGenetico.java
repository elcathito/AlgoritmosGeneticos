package Avaliacao2.AlgoritmoGenetico;

import Avaliacao2.AlgoritmoGenetico.individuo.IndividuoAbs;
import Avaliacao2.AlgoritmoGenetico.individuo.IndividuoAd;
import Avaliacao2.Grafo3.Grafo;

import java.util.*;

import static Avaliacao2.AlgoritmoGenetico.Prints.informacoesInicais;
import static Avaliacao2.AlgoritmoGenetico.recombinacao.Recombinacao.newRecombinacao;
import static Avaliacao2.AlgoritmoGenetico.selecao.Selecao.newSelecao;

public class AlgoritmoGenetico {
    private final int tamanhoPopulacao;
    private final double porcentagemMutacao;
    private final int nrGeracoes;
    private final ArrayList<IndividuoAbs> populacao;
    private final Grafo grafo;
    private final Random random;

    public AlgoritmoGenetico(int tamanhoPopulacao, double porcentagemMutacao, int nrGeracoes, int nrVertices, int maxDist) {
        this.tamanhoPopulacao = tamanhoPopulacao;
        this.porcentagemMutacao = porcentagemMutacao;
        this.nrGeracoes = nrGeracoes;
        this.populacao = new ArrayList<>();
        this.grafo = new Grafo(nrVertices, maxDist);
        this.random = new Random();
    }

    public void start(int verticeOrigem, int verticeDestino,int nrDeRodadas,int nrDeCompetidore,double pocentElite){
        long startTime = System.currentTimeMillis();
        informacoesInicais(nrGeracoes, tamanhoPopulacao, porcentagemMutacao);

        System.out.println("START...");

        for (int index = 0; index < tamanhoPopulacao; index++) {
            populacao.add(new IndividuoAd(grafo, verticeOrigem, verticeDestino));
        }
        System.out.println("POPULACAO INICIAL ADICIONADA...");
        /*printPop(populacaoInicial);*/
        System.out.println("\n>> -------------------------------------------------------------------------------------------------- <<\n");

        System.out.println("PROCESSANDO AS GERACOES...");
        List<IndividuoAbs> novaPop = populacao;
        for (int geracao = 0; geracao < nrGeracoes; geracao++) {
            Map<Parametos, Integer> parametros = new HashMap<>();
            parametros.put(Parametos.NrDeRodadas, nrDeRodadas);
            parametros.put(Parametos.NrDeCompetidore, nrDeCompetidore);
            List<IndividuoAbs> elite = newSelecao().elitismo(novaPop, pocentElite);
            List<IndividuoAbs> torneio = newSelecao().selecaoPorTorneio(novaPop, parametros, false);
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
            Collections.sort(novaPop);
            System.out.println("Geração nr" + geracao);
            System.out.println("Melhor individo da geração");
            System.out.println(novaPop.get(0));
        }

        System.out.println("\n>> -------------------------------------------------------------------------------------------------- <<\n");
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;

        System.out.println("Execution time in milliseconds: " + timeElapsed);
    }


}
