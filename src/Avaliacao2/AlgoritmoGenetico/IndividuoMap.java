package Avaliacao2.AlgoritmoGenetico;

import Avaliacao2.GrafoExemplo01.Aresta;
import Avaliacao2.GrafoExemplo01.Vertice;

import java.util.Map;

import static Avaliacao2.AlgoritmoGenetico.Recombinacao.newRecombinacao;

/**
 * @author Gustavo A. Gama
 */
public class IndividuoMap extends IndividuoAbs {

    /**
     * Rota a ser percorrida.
     */
    private final Map<Vertice, Aresta> cromossomo;


    public IndividuoMap(Vertice inicio, Vertice destino) {
        ControleApitidao controle = new ControleApitidao();
        this.cromossomo = newRecombinacao().newCromossomo(inicio, destino,controle);
        aptidao = controle.get();
    }

    public Map<Vertice, Aresta> getCromossomo() {
        return cromossomo;
    }

    @Override
    public String toString() {
        return "IndividuoMap{" +
                "cromossomo=" + cromossomo +
                ", aptidao=" + aptidao +
                '}';
    }
}
