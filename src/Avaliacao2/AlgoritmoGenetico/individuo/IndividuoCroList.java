package Avaliacao2.AlgoritmoGenetico.individuo;

import Avaliacao2.AlgoritmoGenetico.MapVerticeAresta;
import Avaliacao2.GrafoExemplo01.Vertice;

import java.util.List;

import static Avaliacao2.AlgoritmoGenetico.codificacao.Codificacao.newRecombinacao;

/**
 * @author Gustavo A. Gama
 */
public class IndividuoCroList extends IndividuoAbs {

    /**
     * Rota a ser percorrida.
     */
    private final List<MapVerticeAresta> cromossomo;


    public IndividuoCroList(Vertice inicio, Vertice destino) {
        ControleApitidao controle = new ControleApitidao();
        this.cromossomo = newRecombinacao().getCromossomoList(inicio, destino,controle);
        aptidao = controle.get();
    }

    public List<MapVerticeAresta> getCromossomo() {
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
