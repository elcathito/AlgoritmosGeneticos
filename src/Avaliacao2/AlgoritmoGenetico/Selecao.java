package Avaliacao2.AlgoritmoGenetico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Selecao {

    private final Random random;
    private static Selecao instance;

    public static Selecao newSelecao() {
        if (instance == null) instance = new Selecao();
        return instance;
    }

    private Selecao() {
        random = new Random();
    }

    public  List<Individuo> selecaoPorTorneio(List<Individuo> pop, Map<Parametos, Integer> parametros, boolean vencedorMaiorValor){
        List<Individuo> novaPop = new ArrayList<>();
        int nrComp = parametros.get(Parametos.NrDeCompetidore);
        for (int i = 0; i < parametros.get(Parametos.NrDeRodadas); i++) {
            novaPop.add(torneio(pop,vencedorMaiorValor,nrComp));
        }
        return novaPop;
    }

    private Individuo torneio(List<Individuo> pop,boolean vencedorMaiorValor, int nrComp){
        List<Individuo> competidores = selecaoDeIndividosAleatorios(pop, nrComp);
        Collections.sort(competidores);
        Individuo vencedor;
        if (vencedorMaiorValor) vencedor = competidores.get(nrComp - 1);
        else vencedor = competidores.get(0);
        return vencedor;
    }

    private List<Individuo> selecaoDeIndividosAleatorios(List<Individuo> fonte, int qtdIndividos) {
        List<Individuo> resultado = new ArrayList<>();
        int nrVoltas = qtdIndividos;
        while (nrVoltas-- >= 0) {
            resultado.add(fonte.get(random.nextInt(qtdIndividos)));
        }
        return resultado;
    }
}
