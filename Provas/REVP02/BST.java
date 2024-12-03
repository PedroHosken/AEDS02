package Provas.REVP02;

/**
 * Questão 02
 * 
 * @author Pedro Hosken - 816561
 * @version 1 - 12/11/2024
 * 
 */

// ---- Classe Nó ---- //
class No {
    public int elemento;
    public No esq, dir;
    public int vezes; // modifiquei nó para isso
}

public class BST {
    private No raiz;

    /**
     * Metódo de Inserir
     * 
     * Objetivo: Inserir elementos na BST, permitindo elementos repetidos
     * 
     * Como: Inserimos o atributo vezes, assim, ao inserir e ter já aquele nó na
     * árvore, atualizamos o atributos vezes. Para o metódo de inserir iremos
     * realizar recursão, seguindo a inserção de Pai
     * 
     * Casos de teste: raiz == null, x > raiz.elemento, x < raiz.elemento, x =
     * raiz.elemento
     * 
     * @param x
     * 
     * @var No nv - novo nó a ser inserido
     * 
     */

    public void inserir(int x) {
        // caso de 1
        if (raiz == null) {
            raiz = new No(x); // começa
            raiz.vezes = 1; // inicializa
        }
        // outros casos de Teste
        else {
            if (x > raiz.elemento) { // 2 caso
                inserirPai(x, raiz.dir, raiz);
            } else {
                if (x < raiz.elemento) { // 3 caso
                    inserirPai(x, raiz.esq, raiz);
                } else {
                    if (x == raiz.elemento) { // 4 caso
                        raiz.vezes += 1; // incrementa
                    }
                }
            }
        }

    }

    /**
     * Metódo Inserir Pai
     * 
     * Objetivo: metódo auxiliar de inserção
     * 
     * Como: sua passagem de parâmetro é através do Pai, assim vamos analisar cada
     * caso e realizar a recursão
     * 
     * @param int x - valor
     * @param No  i - atual
     * @param No  pai - pai do atual
     * 
     */

    private void inserirPai(int x, No i, No pai) {
        // teste inicial
        if (i == null) {
            if (x > pai.elemento) {
                pai.dir = new No(x);
                pai.dir.vezes = 1;
            } else {
                pai.esq = new No(x);
                pai.esq.vezes = 1;
            }
        } else {
            // i não está vazio
            if (x > i.elemento) {
                inserirPai(x, i.dir, i);
            } else {
                if (x < i.elemento) {
                    inserirPai(x, i.esq, i);
                } else {
                    i.vezes += 1; // já está presente na árvore

                }

            }
        }
    }

}
