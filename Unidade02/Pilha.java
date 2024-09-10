/**
 * Pilha Estatica
 * 
 * @author Pedro Hosken
 * @version 1 09/2024
 */

public class Pilha {

    private int[] array;
    private int ultimo; // Insere no indice "ultimo".

    /**
     * Construtor da classe.
     */
    public Pilha() {
        this(6);
    }

    /**
     * Construtor da classe.
     * 
     * @param tamanho Tamanho da Pilha.
     */
    public Pilha(int tamanho) {
        array = new int[tamanho + 1];
        ultimo = 0;
    }

    /**
     * Insere um elemento na ultima posicao da Pilha.
     * 
     * @param x int elemento a ser inserido.
     * @throws Exception Se a Pilha estiver cheia.
     */
    public void inserir(int x) throws Exception {

        // validar insercao
        if ((ultimo + 1) >= array.length) {
            throw new Exception("Erro ao inserir!");
        }

        array[ultimo] = x;
        ultimo = ultimo + 1;
    }

    /**
     * Remove um elemento da ultima posicao da Pilha
     * 
     * @return resp int elemento a ser removido.
     * @throws Exception Se a Pilha estiver vazia.
     */
    public int remover() throws Exception {

        // validar remocao
        if (ultimo < 0) {
            throw new Exception("Erro ao remover!");
        }

        int resp = array[ultimo];
        ultimo = ultimo - 1;
        return resp;
    }

    /**
     * Mostra os array separados por espacos.
     */
    public void mostrar() {
        System.out.print("[ ");

        for (int i = 0; i != ultimo; i = ((i + 1) % array.length)) {
            System.out.print(array[i] + " ");
        }

        System.out.println("]");
    }

}
