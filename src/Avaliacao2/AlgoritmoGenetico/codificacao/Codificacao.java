package Avaliacao2.AlgoritmoGenetico.codificacao;

import Avaliacao2.AlgoritmoGenetico.MapVerticeAresta;
import Avaliacao2.AlgoritmoGenetico.individuo.ControleApitidao;
import Avaliacao2.Grafo3.Grafo;
import Avaliacao2.GrafoExemplo01.Aresta;
import Avaliacao2.GrafoExemplo01.Vertice;

import java.util.*;

public class Codificacao {
    private final Random random;
    private static Codificacao instance;

    public static Codificacao newCodificacao() {
        if (instance == null) instance = new Codificacao();
        return instance;
    }

    private Codificacao() {
        random = new Random();
    }

    public List<MapVerticeAresta> getCromossomoList(Vertice origem, Vertice destino, ControleApitidao controleApi) {
        List<MapVerticeAresta> cromossomo = new ArrayList<>();
        buscaDoDestino(destino, cromossomo, origem, controleApi);
        return cromossomo;
    }

    public List<Avaliacao2.Grafo3.Aresta> getCromossomo(int origem, int destino, Grafo grafo, ControleApitidao controleApi) {
        List<Avaliacao2.Grafo3.Aresta> cromossomo = new ArrayList<>();

        buscaDoDestino(origem, destino, grafo, cromossomo, controleApi);
        return cromossomo;
    }

    private void buscaDoDestino(int origem, int destino, Grafo grafo, List<Avaliacao2.Grafo3.Aresta> cromossomo, ControleApitidao controleApi) {
        int proximoPonto = new Random().nextInt(grafo.length());//Se o proximo ponto não tiver conexão tudo bem a apitidão deste inddivido será pessima
        Avaliacao2.Grafo3.Aresta aresta = grafo.getAresta(origem, proximoPonto);
        controleApi.incremente(aresta.getPeso());
        cromossomo.add(aresta);
        if (proximoPonto != destino && controleApi.get() < 21474836) {
            buscaDoDestino(proximoPonto, destino, grafo, cromossomo, controleApi);
        }
    }

    private void buscaDoDestino(Vertice destino, List<MapVerticeAresta> rota, Vertice origem, ControleApitidao controleApi) {
        List<Aresta> arestasOri = origem.arestas;
        Aresta caminhoEscolhido = arestasOri.get(random.nextInt(arestasOri.size()));
        controleApi.incremente(caminhoEscolhido.peso);
        rota.add(new MapVerticeAresta(origem, caminhoEscolhido));
        if (!caminhoEscolhido.destino.equals(destino) && controleApi.get() < 200)
            buscaDoDestino(destino, rota, caminhoEscolhido.destino, controleApi);
    }
}
