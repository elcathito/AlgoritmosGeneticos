package Avaliacao2.AlgoritmoGenetico.individuo;

import Avaliacao2.Grafo3.Aresta;
import Avaliacao2.Grafo3.Grafo;
import java.util.List;

import static Avaliacao2.AlgoritmoGenetico.codificacao.Codificacao.newCodificacao;

public class IndividuoAd extends IndividuoAbs{
    private final List<Aresta> cromossomo;

    public List<Aresta> getCromossomo() {
        return cromossomo;
    }


    public IndividuoAd(Grafo grafo, int origem, int destino) {
        ControleApitidao controle = new ControleApitidao();
        cromossomo = newCodificacao().getCromossomo(origem,destino,grafo,controle);
        aptidao = controle.get();
    }
}
