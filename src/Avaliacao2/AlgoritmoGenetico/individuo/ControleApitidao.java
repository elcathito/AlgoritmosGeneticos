package Avaliacao2.AlgoritmoGenetico.individuo;

public class ControleApitidao {
    private double apitidao;

    public ControleApitidao(){
        apitidao=0;
    }
    public double get() {
        return apitidao;
    }
    public void incremente(double apitidao) {
        this.apitidao += apitidao;
    }
}
