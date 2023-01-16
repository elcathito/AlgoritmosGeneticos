package Avaliacao2.AlgoritmoGenetico;

import Avaliacao2.GrafoExemplo01.Aresta;
import Avaliacao2.GrafoExemplo01.Grafo;
import Avaliacao2.GrafoExemplo01.Vertice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Individuo extends IndividuoAbs {

    private List<String> cromossomo = new ArrayList<>();


//---------------------------------------------------------------------------//

    //====================================================================================================================//

    public Individuo( Grafo grafo, Vertice verticeOrigem, Vertice verticeDestino ) {
        cromossomo.add( verticeOrigem.dado );

        Random aleatoriedade = new Random();
        int tamanhoCromossomo = aleatoriedade.nextInt(grafo.getMapaGrafo().size() - 2 );

        Vertice verticeAtual = verticeOrigem;
        for (int i = 0; i< tamanhoCromossomo; i++ ){

            int indiceAresta = aleatoriedade.nextInt( verticeAtual.arestas.size() );
            Aresta arestaSelecionada = verticeAtual.arestas.get( indiceAresta );

            if(Objects.equals(arestaSelecionada.destino.dado, verticeDestino.dado)) {
                aptidao += arestaSelecionada.peso;
                break;
            } else {
                verticeAtual = arestaSelecionada.destino;
                cromossomo.add( verticeAtual.dado );
                aptidao += arestaSelecionada.peso;
            }
        }

        boolean encontrou = false;
        for ( Aresta aresta : verticeAtual.arestas ) {
            if (Objects.equals(aresta.destino.dado, verticeDestino.dado)) {
                encontrou = true;
                break;
            }
        }
        if(!encontrou){
            aptidao = 0;
        }
        cromossomo.add(verticeDestino.dado);
        System.out.println("CROMOSSOMO GERADO > "+cromossomo.toString() + "\n    <> Aptidao: "+aptidao +"\n");

    }

//---------------------------------------------------------------------------//

    public Individuo(List<String> cromossomoPai1, List<String> cromossomoPai2) {

        this.cromossomo = cromossomoPai1;
        this.aptidao = determinarAptidao();
    }


//====================================================================================================================//

    private List<String> gerarCromossomo(){

        return null;
    }

//====================================================================================================================//

    private double determinarAptidao(){
        return 0;
    }

    @Override
    public String toString() {
        return "Individuo{" +
                "cromossomo=" + cromossomo +
                ", aptidao=" + aptidao +
                '}';
    }
    //====================================================================================================================//

}
