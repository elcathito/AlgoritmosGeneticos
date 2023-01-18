package Avaliacao2.AlgoritmoGenetico.recombinacao;

import Avaliacao2.AlgoritmoGenetico.individuo.Individuo;
import Avaliacao2.AlgoritmoGenetico.individuo.IndividuoAbs;
import Avaliacao2.AlimentarGrafo;
import Avaliacao2.GrafoExemplo01.Aresta;
import Avaliacao2.GrafoExemplo01.Grafo;
import Avaliacao2.GrafoExemplo01.Vertice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Pmx {
    Random random = new Random();

    public List<IndividuoAbs> recombinacao(Individuo a, Individuo b){
        int num;
        int maior;
        if ((a.getCromossomo().size()) < (b.getCromossomo().size())) {
            num = random.nextInt(a.getCromossomo().size());
            maior = b.getCromossomo().size();
        }else{
            num = random.nextInt(b.getCromossomo().size());
            maior = a.getCromossomo().size();
        }
        String[][] subarray = new String[5][5];
        for (int i = 0; i < 5; i++) {
            if(num < a.getCromossomo().size() && num < b.getCromossomo().size()) {
                subarray[i][0] =  a.getCromossomo().get(num);
                subarray[i][1] = b.getCromossomo().get(num);
                num++;
                /*System.out.print(subarray[i][0] + ' ');
                System.out.println(subarray[i][1]);*/
            }else{
                break;
            }
        }
        Individuo newA = trade(subarray, a);
        Individuo newB = trade(subarray, b);
        /*System.out.println(newA.toString());
        System.out.println(newB.toString());*/

        List<IndividuoAbs> lista = new ArrayList<>();
        lista.add(0, newA);
        lista.add(1, newB);

        return lista;
    }

    public Individuo trade(String[][] mapa, Individuo a){
        for (int i = 0; i < a.getCromossomo().size(); i++) {
            for (int j = 0; j < 5; j++) {
                if (a.getCromossomo().get(i).equals(mapa[j][0])){
                    a.getCromossomo().set(i, mapa[j][1]);
                }else if (a.getCromossomo().get(i).equals(mapa[j][1])){
                    a.getCromossomo().set(i, mapa[j][0]);
                }
            }
        }
        return a;
    }



    public static void main(String[] args) {
        AlimentarGrafo alimentarGrafo = new AlimentarGrafo();
        Grafo grafo = alimentarGrafo.padrao_25_vertices();
        Vertice verticeOrigem = grafo.buscarVertice("A");
        Vertice verticeDestino = grafo.buscarVertice("O");
        Individuo i = new Individuo(grafo, verticeOrigem, verticeDestino);
        Individuo a = new Individuo(grafo, verticeOrigem, verticeDestino);
        Pmx pmx = new Pmx();
        //individuo um
        System.out.println( i.toString());
        //individuo 2
        System.out.println( a.toString());

        //recombinacao
        pmx.recombinacao(i, a);
    }
}
