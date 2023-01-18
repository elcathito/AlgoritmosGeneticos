package testes;

import Avaliacao2.AlgoritmoGenetico.AlgoritmoGenetico;

public class TesteGrafo3 {
    public static void main(String[] args) {

        AlgoritmoGenetico algoritmoGenetico = new AlgoritmoGenetico(1000, 5, 10, 25, 17);

        algoritmoGenetico.start(5, 24, 10, 15, 3);

        algoritmoGenetico.start(24, 4, 10, 15, 3);


        algoritmoGenetico.start(5, 24, 10, 15, 3);


        algoritmoGenetico.start(5, 10, 10, 15, 3);


    }

}

