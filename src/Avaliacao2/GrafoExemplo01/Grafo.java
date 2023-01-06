package Avaliacao2.GrafoExemplo01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// MP  {  [dado, Vertice(dado)] , [dado, Vertice(dado)]                                         }

public class Grafo {

    private Map <String, Vertice> mapaGrafo = new HashMap <String, Vertice>();

    private ArrayList<ArrayList<Boolean>> tabelaIncidencia;

/*================================================================================================================*/

    public Map<String, Vertice> getMapaGrafo() {
        return mapaGrafo;
    }

/*================================================================================================================*/

    public void addVertice(String dado){
        mapaGrafo.put( dado, new Vertice(dado));
        //System.out.println("O Vertice Com o Dado "+dado+", Foi Criado e Adicionado ao Grafo!");
    }

    public void addAllVertice(List<String> listNos){
        for (String no: listNos) {
            mapaGrafo.put( no, new Vertice(no));
        }
        //System.out.println("O Vertice Com o Dado "+dado+", Foi Criado e Adicionado ao Grafo!");
    }

/*================================================================================================================*/

    public void criarApontadorComPesos(String dadoOrigem, String dadoDestino, int peso){
        Vertice verticeOrigem = buscarVertice(dadoOrigem);
        Vertice verticeDestino = buscarVertice(dadoDestino);

        if(verticeOrigem==null ){
            System.out.println("Ops >> Elemento *"+dadoOrigem+"* Nao Encontrado!");
        }if(verticeDestino==null){
            System.out.println("Ops >> Elemento *"+dadoDestino+"* Nao Encontrado!");
        }else{
            Aresta aresta = new Aresta(verticeDestino);
            aresta.adicionarPeso(peso);
            verticeOrigem.arestas.add(aresta);

            Aresta arestaReverso = new Aresta(verticeOrigem);
            arestaReverso.adicionarPeso(peso);
            verticeDestino.arestas.add(arestaReverso);
            //System.out.println("> Vertice "+dadoOrigem+" aponta para o vertice "+dadoDestino+ " com o custo "+peso);
        }
    }

/*================================================================================================================*/

    public Vertice buscarVertice(String dado){ //busca esta sendo realizada com metodo pq se a busca n for assim e so resscrever o metodo
        return mapaGrafo.get(dado);//pega o endereco de memoria
    }

/*================================================================================================================*/

    public void listarFullVerticeArestas(){
        for (Vertice vertice: mapaGrafo.values()) {
            System.out.print("Vertice "+vertice.dado + " > ");
            for (Aresta aresta: vertice.arestas) {
                System.out.print(aresta.destino.dado + "(" + aresta.peso + "), ");
            }
            System.out.println();
        }
    }
/*================================================================================================================*/
/*================================================================================================================*/

    public void buscarTodosCaminhos(String dadoOrigem, String dadoDestino){
        System.out.println("   Partido do Elemento *"+dadoOrigem+"* Deseja-se Chegar ao Elemento *"+dadoDestino+"* ");

        if(dadoOrigem.equals(dadoDestino)){
            System.out.println("A Origem e o Destino e o Mesmo Logo Nao e Possivel Tracar Um Caminho");

        }else {
            Vertice verticeOrigem = buscarVertice(dadoOrigem);
            Vertice verticeDestino = buscarVertice(dadoDestino);

            if(verticeOrigem==null || verticeDestino==null){
                System.out.println("Não Foi Possivel Realizar a Operação! \nO Elemento de Origem e/ou de Destino Não Foi/Foram Encontrado(s)!");
            }else{
                ArrayList <String> caminhosEncontrados = buscarTodosCaminhos(verticeOrigem,verticeDestino,"", 0, new ArrayList<String>(), new ArrayList<String>());
                listarCaminhosEncontrados(caminhosEncontrados);
            }
        }
    }

//--------------------------------------------------------------------------------------------------------//

    private ArrayList <String> buscarTodosCaminhos(Vertice verticeAtual, Vertice verticeDestino, String caminho, float pesoCaminho, ArrayList <String> caminhos, ArrayList <String> historico){
        caminho = caminho + verticeAtual.dado + " => ";

        for (int i = 0; i < verticeAtual.arestas.size(); i++) {

            if (verticeAtual.arestas.get(i).destino.dado == verticeDestino.dado) {
                pesoCaminho = pesoCaminho + verticeAtual.arestas.get(i).peso;
                caminhos.add(caminho + verticeDestino.dado + " - // "+ pesoCaminho);
            }else {
                if (!historico.contains(verticeAtual.arestas.get(i).destino.dado)) {
                    pesoCaminho = pesoCaminho + verticeAtual.arestas.get(i).peso;
                    historico.add(verticeAtual.dado);

                    buscarTodosCaminhos(verticeAtual.arestas.get(i).destino, verticeDestino, caminho, pesoCaminho, caminhos, historico);
                }
            }
        }
        if( (historico.size()-1) >= 0)
            historico.remove(historico.size()-1);
        /*int posicaoDoUltimoElemento = historico.size()-1;
        if(posicaoDoUltimoElemento>=0)
            historico.remove(posicaoDoUltimoElemento);*/
        return caminhos;
    }

//--------------------------------------------------------------------------------------------------------//

    public void pegarMelhorCaminho(ArrayList <String> caminhosEncontrados){
        String menorCaminho = null;
        float pesoTotal = 0;

        for(int i = 0; i <caminhosEncontrados.size(); i++) {
            if(i==0) {
                menorCaminho = caminhosEncontrados.get(i);
                pesoTotal = Float.parseFloat(caminhosEncontrados.get(i).substring(caminhosEncontrados.get(i).indexOf("//")+3));
            }else if(Float.parseFloat(caminhosEncontrados.get(i).substring(caminhosEncontrados.get(i).indexOf("//")+3)) < pesoTotal){
                menorCaminho = caminhosEncontrados.get(i);
                pesoTotal = Float.parseFloat(caminhosEncontrados.get(i).substring(caminhosEncontrados.get(i).indexOf("//")+3));
            }
        }

        System.out.println("\n\nO Menor Caminho Encontrado Foi Atraves Dos Vertices: - " + menorCaminho);
    }

//===============================================================================================================//
// ===============================================================================================================//


    public void buscarMelhorCaminho(String dadoOrigem, String dadoDestino){
        System.out.println("   Partido do Elemento *"+dadoOrigem+"* Deseja-se Chegar ao Elemento *"+dadoDestino+"* ");

        if(dadoOrigem.equals(dadoDestino)){
            System.out.println("A Origem e o Destino e o Mesmo Logo Nao e Possivel Tracar Um Caminho");

        }else {
            Vertice verticeOrigem = buscarVertice(dadoOrigem);
            Vertice verticeDestino = buscarVertice(dadoDestino);

            if (verticeOrigem == null || verticeDestino == null) {
                System.out.println("Não Foi Possivel Realizar a Operação! \nO Elemento de Origem e/ou de Destino Não Foi/Foram Encontrado(s)!");
            } else {
                String[] caminhoEncontrado = buscarCaminhoPorMenorPeso(verticeOrigem, verticeDestino, "", 0, new ArrayList<String>(), new String[2]);
                System.out.println("   O Melhor Caminho Encontrado Foi Atraves Dos Vertices: " + caminhoEncontrado[0] + " Somando " + caminhoEncontrado[1] + " Pesos!");
            }
        }
    }

    private String [] buscarCaminhoPorMenorPeso(Vertice verticeAtual, Vertice verticeDestino, String caminhoAtual, float pesoCaminhoAtual, ArrayList <String> historico, String[] menorCaminho){
        caminhoAtual = caminhoAtual + verticeAtual.dado + " => ";

        for (int i = 0; i < verticeAtual.arestas.size(); i++) {

            if (verticeAtual.arestas.get(i).destino.dado == verticeDestino.dado) {
                pesoCaminhoAtual = pesoCaminhoAtual + verticeAtual.arestas.get(i).peso;
                caminhoAtual = caminhoAtual + verticeDestino.dado+" -";

                if(menorCaminho[0]==null){
                    menorCaminho[0] = caminhoAtual;
                    menorCaminho[1] = ""+pesoCaminhoAtual;
                }else{
                    if(Float.parseFloat(menorCaminho[1]) > pesoCaminhoAtual){
                        menorCaminho[0] = caminhoAtual;
                        menorCaminho[1] = ""+pesoCaminhoAtual;
                    }
                }

            }else {
                if (!historico.contains(verticeAtual.arestas.get(i).destino.dado)) {
                    pesoCaminhoAtual = pesoCaminhoAtual + verticeAtual.arestas.get(i).peso;
                    historico.add(verticeAtual.dado);

                    menorCaminho = buscarCaminhoPorMenorPeso(verticeAtual.arestas.get(i).destino, verticeDestino,caminhoAtual, pesoCaminhoAtual, historico, menorCaminho);
                }
            }
        }

        if( (historico.size()-1) >= 0)
            historico.remove(historico.size()-1);

        return menorCaminho;
    }

//===============================================================================================================//

    public void listarCaminhosEncontrados(ArrayList <String> caminhosEncontrados){
        for(int i = 0; i <caminhosEncontrados.size(); i++) {
            System.out.println("      - "+caminhosEncontrados.get(i));
        }
    }

    /*================================================================================================================*/
    /*================================================================================================================*/

    public void tabelaIncidencia(){
        System.out.println("Gerando Tabela de Incidencia...");
        tabIncidencia();
        System.out.println("Tabela de Incidencia Criada com Sucesso!");
    }
    private void tabIncidencia(){
        tabelaIncidencia = new ArrayList<>();
        ArrayList<Boolean> apontados;

        for (String aponta : mapaGrafo.keySet()) {
            //System.out.println(aponta + " = " + mapaGrafo.get(aponta));
            apontados = new ArrayList<>();
            for (String apontado : mapaGrafo.keySet()) {
                if(possuiApontador(mapaGrafo.get(aponta),apontado)){
                    apontados.add(true);
                }else{
                    apontados.add(false);
                }
            }
            tabelaIncidencia.add(apontados);
        }

    }


    public boolean possuiApontador(Vertice v, String x){

        for(int i = 0; i<v.arestas.size(); i++){
            if(v.arestas.get(i).destino.dado.equals(x))
                return true;
        }

        return false;
    }

//--------------------------------------------------------------------------------------//


    public void listarTabela(){

        for ( ArrayList possui:tabelaIncidencia) {
            System.out.print("[");
            for (int i = 0; i<possui.size(); i++){
                System.out.print(possui.get(i)+", ");
            }
            System.out.println("]");
        }
    }
//--------------------------------------------------------------------------------------//

    public void buscarMelhorCaminhoPelaTabelaIncidencia(String dadoOrigem, String dadoDestino){
        System.out.println("   Partido do Elemento *"+dadoOrigem+"* Deseja-se Chegar ao Elemento *"+dadoDestino+"* - Utilizando a Tabela de Incidencia");

        if(dadoOrigem.equals(dadoDestino)){
            System.out.println("A Origem e o Destino e o Mesmo Logo Nao e Possivel Tracar Um Caminho");

        }else {

            if (buscarVertice(dadoOrigem) == null || buscarVertice(dadoDestino) == null) {
                System.out.println("Não Foi Possivel Realizar a Operação! \nO Elemento de Origem e/ou de Destino Não Foi/Foram Encontrado(s)!");
            } else {
                String[] caminhoEncontrado = buscarMelhorCaminhoIncidencia( qualPosicaoEsta(pegarTodosElementos(), dadoOrigem), dadoDestino, "", 0,
                        new String[2], pegarTodosElementos(), new ArrayList<String>() );

                System.out.println("   O Melhor Caminho Encontrado Foi Atraves Dos Vertices: " + caminhoEncontrado[0] + " Somando " + caminhoEncontrado[1] + " Pesos!");
            }
        }
    }

    private String [] buscarMelhorCaminhoIncidencia(int posicaoDadoAtual, String dadoDestino, String caminhoAtual, float pesoCaminhoAtual,
                                                    String[] menorCaminho, String [] todosElementos, ArrayList <String> historico ){

        caminhoAtual = caminhoAtual +  todosElementos[posicaoDadoAtual] +" => ";
        historico.add(todosElementos[posicaoDadoAtual]);

        for (int para = 0; para < tabelaIncidencia.size(); para++) {

            if(tabelaIncidencia.get(posicaoDadoAtual).get(para).equals(true)){

                if( dadoDestino.equals(todosElementos[para]) ){
                    caminhoAtual = caminhoAtual + dadoDestino +" -";
                    pesoCaminhoAtual = pesoCaminhoAtual + pegarPeso(buscarVertice(todosElementos[posicaoDadoAtual]), buscarVertice(dadoDestino));
                    if(menorCaminho[0]==null){
                        menorCaminho[0] = caminhoAtual;
                        menorCaminho[1] = ""+pesoCaminhoAtual;
                    }else{
                        if(Float.parseFloat(menorCaminho[1]) > pesoCaminhoAtual){
                            menorCaminho[0] = caminhoAtual;
                            menorCaminho[1] = ""+pesoCaminhoAtual;
                        }
                    }
                }else{
                    if(!historico.contains(todosElementos[para])) {
                        pesoCaminhoAtual = pesoCaminhoAtual+pegarPeso(buscarVertice(todosElementos[posicaoDadoAtual]), buscarVertice(todosElementos[para]));
                        menorCaminho = buscarMelhorCaminhoIncidencia(   para, dadoDestino, caminhoAtual, pesoCaminhoAtual,
                                menorCaminho, todosElementos, historico);
                    }
                }
            }

        }

        if( (historico.size()-1) >= 0)
            historico.remove(historico.size()-1);

        return  menorCaminho;
    }

    /*-------------------------------------------------------------------------------------------------*/


    public float pegarPeso(Vertice verticeAtual, Vertice verticeApontado){

        for (int i =0 ; i < verticeAtual.arestas.size(); i++) {
            if(verticeAtual.arestas.get(i).destino.dado.equals(verticeApontado.dado) ){
                return verticeAtual.arestas.get(i).peso;
            }
        }
        return 0;
    }

    /*-------------------------------------------------------------------------------------------------*/

    private String [] pegarTodosElementos(){
        String[] todosElementos= new String[tabelaIncidencia.size()];
        int i=0;
        for (String aponta : mapaGrafo.keySet()) {
            todosElementos[i]=aponta;
            i++;
        }
        return todosElementos;
    }
    /*-------------------------------------------------------------------------------------------------*/

    private int qualPosicaoEsta(String[] todosElementos, String valor){
        for (int i = 0; i < todosElementos.length; i++) {
            if(todosElementos[i].equals(valor))
                return i;
        }
        return -1;
    }

    /*-------------------------------------------------------------------------------------------------*/



}
