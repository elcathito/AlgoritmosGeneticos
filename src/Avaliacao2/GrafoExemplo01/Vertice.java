package Avaliacao2.GrafoExemplo01;

import java.util.ArrayList;

public class Vertice {
    public String dado;
    public ArrayList<Aresta> arestas = new ArrayList<Aresta>();

//==========================================================================//

    public Vertice() {
    }

    public Vertice(String dado) {
        this.dado = dado;
    }

//==========================================================================//

    public void adicionarAresta(Vertice destino) {
        Aresta arresta = new Aresta(destino);
        arestas.add(arresta);
    }

//==========================================================================//

    public void adicionarPesos(Vertice destino, int peso) {
        Aresta arresta = bucarAresta(destino);
        arresta.adicionarPeso(peso);
    }

//==========================================================================//

    public Aresta bucarAresta(Vertice destino) {
        for (int i = 0; i <= arestas.size(); i++) {
            if (arestas.get(i).destino.dado.equals(destino.dado))
                return arestas.get(i);
        }
        return null;
    }

// ==========================================================================//

    public void listarAresta() {
        System.out.print("Esta Apontando Para os Vertices: [ ");
        for (int i = 0; i < arestas.size(); i++) {
            String pesos = String.valueOf(arestas.get(i).peso);
            System.out.print(arestas.get(i).destino.dado + "(" + pesos + "), ");
        }
    }

//==========================================================================//


    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Vertice)) return false;
        if (obj == this) return true;
        return this.dado.equals(((Vertice) obj).dado);
    }

    @Override
    public String toString() {
        return  dado;
    }
}
