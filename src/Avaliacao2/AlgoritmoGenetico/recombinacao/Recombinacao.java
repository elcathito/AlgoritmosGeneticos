package Avaliacao2.AlgoritmoGenetico.recombinacao;

import Avaliacao2.AlgoritmoGenetico.individuo.ControleApitidao;
import Avaliacao2.AlgoritmoGenetico.individuo.IndividuoAbs;
import Avaliacao2.AlgoritmoGenetico.individuo.IndividuoAd;
import Avaliacao2.Grafo3.Aresta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Recombinacao {
    private static Recombinacao instance;
    private final Random random;

    public static Recombinacao newRecombinacao() {
        if (instance == null) instance = new Recombinacao();
        return instance;
    }
    private Recombinacao() {
        this.random = new Random();
    }


    public void umPonto(List<Aresta> cromossomoP1, List<Aresta> cromossomoP2, List<IndividuoAbs> novaPopFilho) {
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
            verticeIntercecaoPai1 = random.nextInt(cromossomoP1.size());
            verticeIntercecaoPai2 = random.nextInt(cromossomoP2.size());
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


        ControleApitidao controleApitidao = new ControleApitidao();
        cromossoFilho1.forEach(
                aresta -> {
                    controleApitidao.incremente(aresta.getPeso());
                }
        );

        ControleApitidao controleApitidao2 = new ControleApitidao();
        cromossoFilho2.forEach(
                aresta -> {
                    controleApitidao2.incremente(aresta.getPeso());
                }
        );

        IndividuoAd indFilho1 = new IndividuoAd(cromossoFilho1, controleApitidao.get());
        IndividuoAd indFilho2 = new IndividuoAd(cromossoFilho1, controleApitidao2.get());
        novaPopFilho.add(indFilho1);
        novaPopFilho.add(indFilho2);
    }
}
