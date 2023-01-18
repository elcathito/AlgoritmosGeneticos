package Avaliacao2.GrafoExemplo01;

public class TesteGrafoProfessor {

    public static void main(String[] args) {
        System.out.println("\n                          ALGORITMO GENETICO - GRAFO!");
        System.out.println(  "                     RESOLUCAO BASEADO - ESTRUTURA DE DADOS!");

/*================================================================================================================*/

        Grafo grafo =  new Grafo();

        grafo.addVertice("A");
        grafo.addVertice("B");
        grafo.addVertice("C");
        grafo.addVertice("D");
        grafo.addVertice("E");
        grafo.addVertice("F");
        grafo.addVertice("G");
        grafo.addVertice("H");
        grafo.addVertice("I");
        grafo.addVertice("J");
        grafo.addVertice("K");
        grafo.addVertice("L");
        grafo.addVertice("M");
        grafo.addVertice("N");
        grafo.addVertice("O");
        grafo.addVertice("P");
        grafo.addVertice("Q");
        grafo.addVertice("R");
        grafo.addVertice("S");
        grafo.addVertice("T");
        grafo.addVertice("U");
        grafo.addVertice("V");
        grafo.addVertice("X");
        grafo.addVertice("Y");
        grafo.addVertice("Z");

        System.out.println("\n                  Imprimindo os Elementos que Compoem o Grafo:");
        System.out.println("    "+grafo.getMapaGrafo().keySet());

        System.out.println("\n==================================================================================\n");


        /*================================================================================================================*/

        System.out.println("\n                   Inserindo Apontador Para o Vertice: \n");

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

        /*grafo.criarApontadorComPesos("A","B" , 2);
        grafo.criarApontadorComPesos("A","F", 3);

        grafo.criarApontadorComPesos("B","A", 4);
        grafo.criarApontadorComPesos("B","C", 2);

        grafo.criarApontadorComPesos("C","B",3);
        grafo.criarApontadorComPesos("C","D",3);

        grafo.criarApontadorComPesos("D","C",4);
        grafo.criarApontadorComPesos("D","E",1);

        grafo.criarApontadorComPesos("E","J",1);

        grafo.criarApontadorComPesos("F","G",1);

        grafo.criarApontadorComPesos("G","A",6);
        grafo.criarApontadorComPesos("G","F",1);
        grafo.criarApontadorComPesos("G","H",1);
        grafo.criarApontadorComPesos("G","L",8);

        grafo.criarApontadorComPesos("H","G",1);
        grafo.criarApontadorComPesos("H","I",1);

        grafo.criarApontadorComPesos("I","O",3);

        grafo.criarApontadorComPesos("J","I",12);
        grafo.criarApontadorComPesos("J","P",1);

        grafo.criarApontadorComPesos("K","L",1);
        grafo.criarApontadorComPesos("K","Q",3);

        grafo.criarApontadorComPesos("L","G",1);
        grafo.criarApontadorComPesos("L","K",1);
        grafo.criarApontadorComPesos("L","M",1);
        grafo.criarApontadorComPesos("L","R",1);

        grafo.criarApontadorComPesos("M","L",1);
        grafo.criarApontadorComPesos("M","O",1);
        grafo.criarApontadorComPesos("M","S",10);

        grafo.criarApontadorComPesos("O","I",9);
        grafo.criarApontadorComPesos("O","M",1);
        grafo.criarApontadorComPesos("O","P",1);

        grafo.criarApontadorComPesos("P","O",1);
        grafo.criarApontadorComPesos("P","U",4);

        grafo.criarApontadorComPesos("Q","K",3);
        grafo.criarApontadorComPesos("Q","R",1);

        grafo.criarApontadorComPesos("R","L",1);
        grafo.criarApontadorComPesos("R","Q",1);
        grafo.criarApontadorComPesos("R","S",3);

        grafo.criarApontadorComPesos("S","L",8);
        grafo.criarApontadorComPesos("S","R",4);
        grafo.criarApontadorComPesos("S","T",1);

        grafo.criarApontadorComPesos("T","S",1);
        grafo.criarApontadorComPesos("T","U",1);

        grafo.criarApontadorComPesos("U","T",1);*/


        grafo.listarFullVerticeArestas();

/*================================================================================================================*/

        System.out.println("\n==================================================================================\n");

        System.out.println("                - BUSCANDO TODOS OS POSSIVEIS CAMINHOS! - \n");
        grafo.buscarTodosCaminhos("A","C");


        System.out.println("\n                    - BUSCANDO OS MELHOR CAMINHO! - \n");
        grafo.buscarMelhorCaminho("A","C");

        System.out.println("\n==================================================================================\n");

        System.out.println("                    - TABELA DE INCIDENCIA! - \n");
        grafo.tabelaIncidencia();

        System.out.println("\n-------------------------------------------------------------\n");

        System.out.println("\n                    - IMPRESSAO DA TABELA DE INCIDENCIA! - \n");
        grafo.listarTabela();



    }

}
