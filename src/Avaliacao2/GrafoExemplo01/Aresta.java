package Avaliacao2.GrafoExemplo01;

public class Aresta {

    public Vertice destino;
    public int peso;

//==========================================================================//

    public Aresta(Vertice destino){
        this.destino=destino;
    }

//==========================================================================//

    public void adicionarPeso(int peso){
        this.peso = peso;
    }

//==========================================================================//


    @Override
    public String toString() {
        return "Aresta{" +
                "destino " + destino +
                ", " + peso +
                '}';
    }
}
