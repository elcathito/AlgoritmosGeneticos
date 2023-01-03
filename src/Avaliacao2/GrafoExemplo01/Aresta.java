package Avaliacao2.GrafoExemplo01;

public class Aresta {

    Vertice destino;
    int peso;

//==========================================================================//

    public Aresta(Vertice destino){
        this.destino=destino;
    }

//==========================================================================//

    public void adicionarPeso(int peso){
        this.peso = peso;
    }

//==========================================================================//

}
