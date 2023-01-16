package Avaliacao2.Grafo3;

import java.util.Objects;

public class Aresta {

    private final String rotulo;
    private  int verticeOrigem;
    private  int verticeDestino;
    private  int peso;

    public Aresta(int verticeOrigem, int verticeDestino, int peso) {
        this.rotulo = "De " + verticeOrigem + " Para " + verticeDestino;
        this.verticeOrigem = verticeOrigem;
        this.verticeDestino = verticeDestino;
        this.peso = peso;
    }

    public Aresta(String rotulo) {
        this.rotulo = rotulo;
    }

    public String getRotulo() {
        return rotulo;
    }

    public int getVerticeOrigem() {
        return verticeOrigem;
    }

    public int getVerticeDestino() {
        return verticeDestino;
    }

    public int getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Ponto{" +
                "rotulo='" + rotulo + '\'' +
                ", peso=" + peso +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aresta aresta = (Aresta) o;
        return rotulo.equals(aresta.rotulo);
    }

}
