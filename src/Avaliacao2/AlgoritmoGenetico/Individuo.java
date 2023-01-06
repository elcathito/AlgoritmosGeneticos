package Avaliacao2.AlgoritmoGenetico;

import Avaliacao2.GrafoExemplo01.Grafo;

import java.util.List;
import java.util.Random;

public class Individuo {

    private List<String> cromossomo;

    private double aptidao;

//====================================================================================================================//

    public Individuo(Grafo grafo) {
        this.cromossomo = gerarCromossomo();
        this.aptidao = determinarAptidao();
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

//====================================================================================================================//

}
