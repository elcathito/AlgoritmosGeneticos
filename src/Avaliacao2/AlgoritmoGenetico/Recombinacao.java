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


    public Map<Vertice, Aresta> newCromossomo(Vertice origem, Vertice destino, ControleApitidao controleApi) {
        Map<Vertice, Aresta> rota = new HashMap<>();
        buscaDoDestino(destino, rota, origem,controleApi);

        return rota;
    }

    private void buscaDoDestino(Vertice destino, Map<Vertice, Aresta> rota, Vertice origem,ControleApitidao controleApi) {
        Vertice proximoPonto = incersaoDePontosNaRota(rota, origem,controleApi);
        if (!proximoPonto.equals(destino)&& controleApi.get()<200)
            buscaDoDestino(destino, rota, proximoPonto,controleApi);
    }

    private Vertice incersaoDePontosNaRota(Map<Vertice, Aresta> rota, Vertice origem,ControleApitidao controleApi) {
        List<Aresta> arestasOri = origem.arestas;
        Aresta caminhoEscolhido = arestasOri.get(random.nextInt(arestasOri.size()));
        controleApi.incremente(caminhoEscolhido.peso);
        rota.put(origem, caminhoEscolhido);
        return caminhoEscolhido.destino;
    }
}
