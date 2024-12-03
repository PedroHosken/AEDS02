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

    public int hashT1(int elemento){
   }

   public int hashT2(int elemento){
   }

   public int hashT3(int elemento){
   }

   public int rehashT3(int elemento){
   }


}
