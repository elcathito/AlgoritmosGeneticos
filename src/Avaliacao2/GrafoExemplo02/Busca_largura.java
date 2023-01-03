package Avaliacao2.GrafoExemplo02;

public class Busca_largura {
    
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<String>();
        grafo.adicionarVertice("João");
        grafo.adicionarVertice("Lorenzo");
        grafo.adicionarVertice("Creuza");
        grafo.adicionarVertice("Cléber");
        grafo.adicionarVertice("Cláudio");
        
        grafo.adicionarAresta(2.0, "João", "Lorenzo");
        grafo.adicionarAresta(3.0, "Lorenzo", "Cléber");
        grafo.adicionarAresta(1.0, "Cléber", "Creuza");
        grafo.adicionarAresta(1.0, "João", "Creuza");
        grafo.adicionarAresta(3.0, "Cláudio", "João");
        grafo.adicionarAresta(2.0, "Cláudio", "Lorenzo");
        
        
        grafo.buscaEmLargura();
    }
    
}
