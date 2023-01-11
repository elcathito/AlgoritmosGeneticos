package Avaliacao2.AlgoritmoGenetico;

public class SelecaoExeption extends Exception{
    public SelecaoExeption(String mensage){
        super(mensage);
    }
    public SelecaoExeption(Parametos parameto){
        super("O parametro "+ parameto.name()+" Deve ser passado no Map<Parametros,Integer> parametros");
    }



}
