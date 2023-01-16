package Avaliacao2.AlgoritmoGenetico.selecao;

import Avaliacao2.AlgoritmoGenetico.Parametos;
import Avaliacao2.AlgoritmoGenetico.individuo.IndividuoAbs;

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

    public List<IndividuoAbs> selecaoPorTorneio(List<? extends IndividuoAbs> pop, Map<Parametos, Integer> parametros, boolean vencedorMaiorValor) {
        List<IndividuoAbs> novaPop = new ArrayList<>();
        for (int i = 0; i < parametros.get(Parametos.NrDeRodadas); i++) {
            novaPop.add(torneio(pop, vencedorMaiorValor, parametros.get(Parametos.NrDeCompetidore)));
        }
        return novaPop;
    }

    private IndividuoAbs torneio(List<? extends IndividuoAbs> pop, boolean vencedorMaiorValor, int nrComp) {
        List<IndividuoAbs> competidores = selecaoDeIndividosAleatorios(pop, nrComp);
        Collections.sort(competidores);
        IndividuoAbs vencedor;
        if (vencedorMaiorValor) vencedor = competidores.get(nrComp - 1);
        else vencedor = competidores.get(0);
        return vencedor;
    }

    private List<IndividuoAbs> selecaoDeIndividosAleatorios(List<? extends IndividuoAbs> fonte, int qtdIndividos) {
        List<IndividuoAbs> resultado = new ArrayList<>();
        int nrVoltas = qtdIndividos;
        while (nrVoltas-- >= 0) {
            resultado.add(fonte.get(random.nextInt(fonte.size())));
        }
        return resultado;
    }
}
