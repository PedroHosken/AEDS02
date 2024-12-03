package Unidade07;

/**
 * Implementação da Doidona sem TADS
 * 
 * @author Pedro Hosken -816561
 * @version 1.0 - 03/12/2024
 * 
 */

/**
 * Estrutura da Celula e seus construtor
 */
class Celula {
    // atributos
    public int val;
    public Celula prox;

    // construtor padrão
    public Celula() {
        this.val = 0;
        this.prox = null;
    }
}

/**
 * Estrutura do Nó e seus construtor
 */
class No {
    // atributos
    public int val;
    public No dir, esq;

    // construtor padrão
    public No() {
        this.val = 0;
        this.dir = this.esq = null;
    }
}

public class Doidona {
    // atributos globais
    final int TAM1 = 10; // tamanho da hash1
    final int TAM3 = 10; // tamanho da hash3
    final int NULO = -0x7FFFFF; // valor nulo

    // inicializa as tabelas hash
    int[] h1;
    int[] h3;

    // inicializa as estruturas
    Celula primeiroT2, ultimoT2; // lista em T2
    No raizT2, raizT3; // raiz T2 e raiz T3

    // construtor padrão da Doidona
    public Doidona() {
        // inicializa estruturas com os tamanhos
        h1 = new int[TAM1]; // inicializa hash 1
        h3 = new int[TAM3]; // inicializa hash 3
        // inicializa cada estrutura com nulo
        for (int i = 0; i < TAM1; i++) {
            h1[i] = NULO;
        }
        for (int i = 0; i < TAM3; i++) {
            h3[i] = NULO;
        }

        // inicializa as células
        primeiroT2 = ultimoT2 = null;
        // inicializa os nós
        raizT2 = raizT3 = null;
    }

    // Metódos de Hash

    public int hashT1(int elemento) {
        return elemento % TAM1; // retorna o elemento dividido pelo tamanho da Hash
    }

    public int hashT2(int elemento) {
        return elemento % 3; // area de reserva destinada a T2
    }

    public int hashT3(int elemento) {
        return elemento % TAM3; // retorna o elemento dividido pelo tamanho da Hash
    }

    public int rehashT3(int elemento) {
        return (elemento + 1) % TAM3; // retorna o elemento dividido pelo tamanho da Hash
    }

    /**
     * Metódo de Inserir
     * 
     * Objetivo: inserir na estrtura doidona
     * 
     * Como: Vamos realizar a transformação do elemento para h1, caso colisão, vai
     * para T2. T2 transforma o elemento, o que vai direcioná-lo para sua estrtura
     * correta, seja T3, lista flexível, ou árvore binária. Em T3, caso colida vai
     * para área de reserva que é uma árvore binária
     * 
     * @param int elemento
     * 
     * @var int [] h1
     * @var int [] h3
     * @var No raiz T2
     * @var No raiz T3
     * @var Celula primeiroT2
     * @var Celula ultimoT2
     * @var aux
     */

    public void inserir(int elemento) {
        // definir dados
        int aux = 0;
        // transformar em h1
        aux = hashT1(elemento);
        // teste de posição em h1
        if (h1[aux] == NULO) { // caso vazio
            h1[aux] = elemento;
        } else { // esta ocupado
            aux = hashT2(elemento);
            if (aux == 1) { // vai pra T3

            } else if (aux == 2) { // lista encadeada

            } else { // arvore bináriaclear
                

            }
        }
    }

}
