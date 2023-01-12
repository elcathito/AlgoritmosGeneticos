package Avaliacao2.AlgoritmoGenetico;
/**
 * Classe abstrata IndividuoAbs serve como base para a crição de novos individuos
 * que sejam ordenaveis e possuam aptidão do tipo double.
 * @author Gustavo A. Gama
 * */
public abstract class IndividuoAbs implements Comparable<IndividuoAbs> {

    protected double aptidao;

    public double getAptidao() {
        return aptidao;
    }

    /**
     * Compara a apitidão do individo atual com um outro individo.
     * @param outroIndivido represemta o outro individo que se deseja comparar.
     * @return 1 se o individo atual for maior que o outroIndivido.<br>
     * 0 se o individo atual for igual ao outroIndivido.<br>
     * -1 se o individo atual for menor que o outroIndivido.
     * @author Gustavo Avila Gama.
     * **/
    @Override
    public int compareTo(IndividuoAbs outroIndivido) {
        return Double.compare(this.aptidao,outroIndivido.aptidao);
    }
}
