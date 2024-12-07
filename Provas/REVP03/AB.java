package Provas.REVP03;

/**
 * Questão 01 do semestre passado
 * 
 * @author Pedro Hosken Fernandes Guimarães
 * @version 1.0 - 07/12/2024
 */

// ---- Classe Nó ---- //
class No {
    public int elemento;
    public No esq, dir;
}

// ---- Classe da Árvore ---- //
public class AB {
    // dados
    private No raiz;

    // metódos da Questão

    /**
     * Metódo Get Altura
     * 
     * Objetivo: analisar qual é a maior altura da árvore
     * 
     * Como: vamos, recursivamente, analisar cada lado da árvore. Vamos ter um
     * inteiro para esq, e um inteiro para dir, acrescentamos cada lado a medida que
     * avança entre os nós
     * 
     * @param No  i
     * @param int altura
     * @return altura
     * 
     * @var int esq
     * @var int dir
     * 
     */

    public static int getAltura(No i, int altura) {
        // caso base
        if (i == null) {
            altura--;
        } else {
            int alturaEsq = getAltura(i.esq, altura + 1); // começa pela esquerda
            int alturaDir = getAltura(i.dir, altura + 1); // depois vai para direita
            // comparação entre valores
            altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
        }
        // retornar
        return altura;
    }

    /**
     * Metodo getNos
     * 
     * Objetivo: retornar a quantidade total de nós presente na estrutura.
     * 
     * @param No i
     * @return int qnt
     */
    public static int getNos(No i) {
        // Caso base: se o nó for nulo, retorna 0
        if (i == null) {
            return 0;
        }
        // Soma 1 (nó atual) + nós da subárvore esquerda + nós da subárvore direita
        return 1 + getNos(i.esq) + getNos(i.dir);
    }

    /**
     * Metódo isMax
     * 
     * Objetivo: comparar o valor da altura da árvore com o valor obtido pelo metódo
     * 
     * Como: vamos implementar o metodo get altura, depois o metódo get total nós
     * para auxiliar. Assim, vamos multiplicar o valor de parametro com o log2
     * daquantidade de nós, e comparar com o valor da altura.
     * 
     * @param valor
     * @return boolean is
     * 
     * @var boolean is
     * @var int alt
     * @var int tnt
     * @var int aux
     * 
     */
    public boolean isMax(double valor) {
        // definir dados
        boolean is = false;
        int alt, tnt, aux;
        // chamar metódo de getaltura
        alt = AB.getAltura(this.raiz, 0);
        // chamar metodo de getTnt
        tnt = AB.getNos(this.raiz);
        // gerar aux
        aux = (int) (valor * Math.log(tnt) / Math.log(2));
        // comaparar valores
        if (alt == aux) {
            is = true;
        }
        // retornar
        return is;

    }

}
