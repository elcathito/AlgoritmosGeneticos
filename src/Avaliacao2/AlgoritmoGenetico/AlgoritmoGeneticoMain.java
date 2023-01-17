package Avaliacao2.AlgoritmoGenetico;

import Avaliacao2.AlgoritmoGenetico.individuo.Individuo;
import Avaliacao2.AlgoritmoGenetico.individuo.IndividuoAbs;
import Avaliacao2.AlgoritmoGenetico.selecao.Selecao;
import Avaliacao2.AlimentarGrafo;
import Avaliacao2.GrafoExemplo01.Grafo;
import Avaliacao2.GrafoExemplo01.Vertice;

import java.util.*;

import static Avaliacao2.AlgoritmoGenetico.Prints.informacoesInicais;
import static Avaliacao2.AlgoritmoGenetico.selecao.Selecao.newSelecao;

public class AlgoritmoGeneticoMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        AlimentarGrafo alimentarGrafo = new AlimentarGrafo();
        Grafo grafo = alimentarGrafo.padrao_25_vertices();

        ArrayList<Individuo> populacaoInicial = new ArrayList<>();

        int tamanhoPopulacao = 100;
        double porcentagemMutacao = 5;
        int nrGeracoes = 1;

        Individuo maisApto = null;
        int geracaoAlcancouMaisApto = -1;


        informacoesInicais(nrGeracoes,tamanhoPopulacao,porcentagemMutacao);

        /*System.out.println("Origem >> ");
        String origem = input.next();

        System.out.println("Destino >> ");
        String destino = input.next();*/

        Vertice verticeOrigem = grafo.buscarVertice("A");
        Vertice verticeDestino = grafo.buscarVertice("O");

        System.out.println("START...");

        for (int index = 0; index < tamanhoPopulacao; index++) {
            populacaoInicial.add(new Individuo(grafo, verticeOrigem, verticeDestino));
        }
        System.out.println("POPULACAO INICIAL ADICIONADA...");

        System.out.println("\n>> -------------------------------------------------------------------------------------------------- <<\n");

        System.out.println("PROCESSANDO AS GERACOES...");
        /*Map<Parametos, Integer> parametros = new HashMap<>();
        parametros.put(Parametos.NrDeRodadas, 10);
        parametros.put(Parametos.NrDeCompetidore, 15);*/
        for (int geracao = 0; geracao < nrGeracoes; geracao++) {
            List<? extends IndividuoAbs> novaPop = populacaoInicial;
//            novaPop = Selecao.newSelecao().selecaoPorTorneio(novaPop, parametros, false);
            novaPop = newSelecao().elitismo(novaPop,10);
            System.out.println(Arrays.toString(novaPop.toArray()));
        }
        /*System.out.println(Arrays.toString(populacaoInicial.toArray()));
        Collections.sort(populacaoInicial);//Metodo de ordenação de listas do tipo individo.
        System.out.println(Arrays.toString(populacaoInicial.toArray()));*/
        System.out.println("\n>> -------------------------------------------------------------------------------------------------- <<\n");

    }

}
