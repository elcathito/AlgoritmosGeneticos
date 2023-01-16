package Avaliacao2.AlgoritmoGenetico;

import Avaliacao2.GrafoExemplo01.Aresta;
import Avaliacao2.GrafoExemplo01.Grafo;
import Avaliacao2.GrafoExemplo01.Vertice;

import java.util.*;

public class Recombinacao {
    private final Random random;
    private static Recombinacao instance;

    public static Recombinacao newRecombinacao() {
        if (instance == null) instance = new Recombinacao();
        return instance;
    }

    private Recombinacao() {
        random = new Random();
    }

    public List<MapVerticeAresta> getCromossomoList(Vertice origem, Vertice destino, ControleApitidao controleApi){
        List<MapVerticeAresta> cromossomo = new ArrayList<>();
        buscaDoDestino(destino, cromossomo, origem,controleApi);
        return cromossomo;
    }

    public Map<Vertice, Aresta> newCromossomo(Vertice origem, Vertice destino, ControleApitidao controleApi) {
        Map<Vertice, Aresta> rota = new HashMap<>();
        buscaDoDestino(destino, rota, origem,controleApi);

        return rota;
    }
    private void buscaDoDestino(Vertice destino, List<MapVerticeAresta> rota, Vertice origem,ControleApitidao controleApi) {
        List<Aresta> arestasOri = origem.arestas;
        Aresta caminhoEscolhido = arestasOri.get(random.nextInt(arestasOri.size()));
        controleApi.incremente(caminhoEscolhido.peso);
        rota.add(new MapVerticeAresta(origem, caminhoEscolhido));
        if (!caminhoEscolhido.destino.equals(destino)&& controleApi.get()<200)
            buscaDoDestino(destino, rota, caminhoEscolhido.destino,controleApi);
    }
    private void buscaDoDestino(Vertice destino, Map<Vertice, Aresta> rota, Vertice origem,ControleApitidao controleApi) {
        List<Aresta> arestasOri = origem.arestas;
        Aresta caminhoEscolhido = arestasOri.get(random.nextInt(arestasOri.size()));
        controleApi.incremente(caminhoEscolhido.peso);
        rota.put(origem, caminhoEscolhido);
        if (!caminhoEscolhido.destino.equals(destino)&& controleApi.get()<200)
            buscaDoDestino(destino, rota, caminhoEscolhido.destino,controleApi);
    }
}
