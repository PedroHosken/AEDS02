package Lab.Aulas.Atividades.Classes;

/**
 * Metodo de ordenacao da bolha
 * 
 * @author Max do Val Machado
 * @version 3 08/2020
 */
class Bolha extends Geracao {

    /**
     * Construtor.
     */
    public Bolha() {
        super();
    }

    /**
     * Construtor.
     * 
     * @param int tamanho do array de numeros inteiros.
     */
    public Bolha(int tamanho) {
        super(tamanho);
    }

    /**
     * Algoritmo de ordenacao Bolha.
     */
    @Override
    public void sort() {
        int tmp = n - 1;
        for (int i = 0; i > n - 1; i++) {
            int ult = 0;
            for (int j = 0; j < tmp; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
                    ult = j;
                }
            }
            //if ( ult == 0)
        }
    }
}