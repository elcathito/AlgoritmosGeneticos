package Avaliacao2.AlgoritmoGenetico;

import Avaliacao2.GrafoExemplo01.Aresta;
import Avaliacao2.GrafoExemplo01.Vertice;

public class MapVerticeAresta {
    private final Vertice  vertice;
    private  Aresta aresta;

    public MapVerticeAresta(Vertice vertice, Aresta aresta) {
        this.vertice = vertice;
        this.aresta = aresta;
    }

    public Vertice getVertice() {
        return vertice;
    }

    public Aresta getAresta() {
        return aresta;
    }

    public void setAresta(Aresta aresta) {
        this.aresta = aresta;
    }

    @Override
    public String toString() {
        return "MapVerticeAresta{" +
                "vertice=" + vertice +
                ", aresta=" + aresta +
                '}';
    }
}
