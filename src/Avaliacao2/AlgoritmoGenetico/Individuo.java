package Avaliacao2.AlgoritmoGenetico;

import java.util.Random;

public class Individuo {

    private String [] cromossomo;

    private double aptidao;

//====================================================================================================================//

    public Individuo() {
        this.cromossomo = gerarCromossomo();
        this.aptidao = determinarAptidao();
    }

//---------------------------------------------------------------------------//

    public Individuo(String [] cromossomoPai1, String [] cromossomoPai2) {

        this.cromossomo = cromossomoPai1;
        this.aptidao = determinarAptidao();
    }


//====================================================================================================================//

    private String [] gerarCromossomo(){

        return null;
    }

//====================================================================================================================//

    private double determinarAptidao(){
        return 0;
    }

//====================================================================================================================//

}
