private static int particao(int[] vetor, int esquerda, int direita) {
        int meio = (int) (esquerda + direita)/2;
        int pivo = vetor[meio];

        int i = esquerda - 1;
        int f = direita + 1;

        while (true){
            do {
                i++;

            }while (vetor[i] < pivo);

            do{
                f--;
            }while (vetor[f] > pivo);

            if (i >= f){
                return f;
            }

            int troca = vetor[i];
            vetor[i] = vetor[f];
            vetor[f] = troca;

        }

    }

}
