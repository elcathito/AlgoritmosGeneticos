package Avaliacao2;

import Avaliacao2.GrafoExemplo01.Grafo;

import java.util.Arrays;
import java.util.List;

public class AlimentarGrafo {

    public Grafo padrao_25_vertices(){
        Grafo grafo =  new Grafo();
        List<String> listNos = Arrays.asList( "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
                                                "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "X", "Y", "Z" );
        grafo.addAllVertice(listNos);

        grafo.criarApontadorComPesos("A","B" , 3);
        grafo.criarApontadorComPesos("A","F", 3);
        grafo.criarApontadorComPesos("B","C", 4);
        grafo.criarApontadorComPesos("B","G", 5);
        grafo.criarApontadorComPesos("B","H", 3);
        grafo.criarApontadorComPesos("C","D",1);
        grafo.criarApontadorComPesos("C","I",4);
        grafo.criarApontadorComPesos("D","E",4);
        grafo.criarApontadorComPesos("D","I",5);
        grafo.criarApontadorComPesos("E","J",2);
        grafo.criarApontadorComPesos("F","G",1);
        grafo.criarApontadorComPesos("F","K",4);
        grafo.criarApontadorComPesos("F","L",2);
        grafo.criarApontadorComPesos("G","H",2);
        grafo.criarApontadorComPesos("H","I",5);
        grafo.criarApontadorComPesos("H","L",5);
        grafo.criarApontadorComPesos("I","J",2);
        grafo.criarApontadorComPesos("I","N",3);
        grafo.criarApontadorComPesos("J","O",5);
        grafo.criarApontadorComPesos("K","L",3);
        grafo.criarApontadorComPesos("K","P",3);
        grafo.criarApontadorComPesos("K","Q",3);
        grafo.criarApontadorComPesos("L","M",2);
        grafo.criarApontadorComPesos("M","N",1);
        grafo.criarApontadorComPesos("M","R",2);
        grafo.criarApontadorComPesos("N","O",2);
        grafo.criarApontadorComPesos("O","T",3);
        grafo.criarApontadorComPesos("O","S",4);
        grafo.criarApontadorComPesos("P","Q",6);
        grafo.criarApontadorComPesos("P","U",5);
        grafo.criarApontadorComPesos("Q","R",1);
        grafo.criarApontadorComPesos("Q","V",5);
        grafo.criarApontadorComPesos("R","S",2);
        grafo.criarApontadorComPesos("S","T",3);
        grafo.criarApontadorComPesos("S","Y",3);
        grafo.criarApontadorComPesos("T","Z",2);
        grafo.criarApontadorComPesos("U","V",3);
        grafo.criarApontadorComPesos("V","X",2);
        grafo.criarApontadorComPesos("X","Y",2);
        grafo.criarApontadorComPesos("Y","Z",4);
        return grafo;
    }

//====================================================================================================================//

    public void aleatorio_25_vertices(){

    }

//====================================================================================================================//

    public void aleatorio_50_vertices(){

    }

//====================================================================================================================//

    public void aleatorio_100_vertices(){

    }

//====================================================================================================================//

    public void aleatorio_150_vertices(){

    }

//====================================================================================================================//

    public void aleatorio_200_vertices(){

    }

//====================================================================================================================//

}
