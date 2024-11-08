package Unidade05;

/**
 * Exercício de Árvore de Lista
 * @author Pedro Hosken - 816561
 * @version 1 - 07/11/2024
 * 
 */

// ---- Dependencias ---- //
import java.util.*;

/**
 * Classe No e seu construtor
 */
class No {
    // ---- atributos ---- //
    public int elemento;
    public No esq, dir;

    // ---- Construtor ---- //
    public No() {
        this.elemento = 0;
        this.dir = this.esq = null;
    }

    public No(int x) {
        this.elemento = x;
        this.dir = this.esq = null;
    }

}

/**
 * Classe Celula e seu construtor
 */
class Celula {
    // ---- atributos ---- //
    public Celula prox;
    public No raiz;

    // ---- Construtor ---- //
    public Celula() {
        this.prox = null;
        this.raiz = null;
    }

    public Celula(No i) {
        this.prox = null;
        this.raiz = i;
    }
}

public class FiladeArvore {
    // ---- atributos ---- //
    public Celula head, tail;

    // ---- Construtor ---- //
    public FiladeArvore() {
        this.head = null;
        this.tail = null;
    }

    public FiladeArvore(Celula i) {
        this.head = this.tail = i;
    }

    /**
     * Metódo de adicionar na Fila
     * 
     * Objetivo: adicionar nova celúla na fila, e adicionar os elementos na árvore
     * 
     * Como: vamos receber do parametro o valor a ser inserido na estrutura, vamos
     * verificar se há celúlas presentes, caso não tenham vamos inicializar uma nova
     * e colocar o elemento como raiz. Caso já exista vamos adicionar o elemnto na
     * celula apontada pela HEAD, seguindo os padrões da árvore, caso a árvore não
     * tenham valores, ela será a raiz.
     * 
     * @param int elemento
     * @return boolean adi
     * 
     * @var Celula nv
     * @var No nm
     * @var boolean adi
     * 
     */

    public boolean add(int elemento) {
        // definir dados
        boolean adi = false;
        // teste para caso de estrutura vazia
        if (head == null && tail == null) {
            // vamos criar nova celula
            No nm = new No(elemento); // criamos novo no
            Celula nv = new Celula(nm); // criamos a nova celula apontando para novo nó raiz
            this.head = this.tail = nv; // apontamos para nova celula criada
            adi = true; // atualiza adi
        } else { // estrutura apresenta celulas
            // vamos inserir na celula apontada pelo HEAD
            adi = adicionar(this.head.raiz, elemento); // metódo auxiliar para inserção
        }
        // return
        return adi;
    }

    /**
     * Metódo Adicionar
     * 
     * Objetivo: metódo auxiliar para adicionar novos elementos na árvore da celúla
     * 
     * Como: seguindo a estrutura do metódo adicionar básico
     * 
     * @var No raiz
     * @var int x
     * @var boolean ok
     * 
     * @param No  raiz
     * @param int elemento
     * 
     * @return ok
     * 
     */

    private boolean adicionar(No raiz, int elemento) {
        // definir dados
        boolean ok = false;
        // teste para ver se raiz está vazia
        if (raiz == null) {
            raiz = new No(elemento);
            ok = true;
        }
        // caso de elemento ser maior que raiz.elemento
        else {
            if (elemento > raiz.elemento) {
                return adicionar(raiz.dir, elemento); // recursividade
            }
            // teste para caso elemento < raiz.elemento
            else {
                if (elemento < raiz.elemento) {
                    return adicionar(raiz.esq, elemento); // recursividade
                }
                // caso igual
                else {
                    System.out.println("Erro ao adicionar, elementos iguais");
                    return ok; // finaliza metódo
                }
            }
        }
        // return
        return ok;
    }

    /**
     * Metódo de Imprimir
     * 
     * Objetivo imprimir a estrutura a partir da raiz de cada Celula
     * 
     * Como: vamos passar como parametro a Celula e vamos passar celula por celula
     * de forma iterativa. Para imprimir vamos utilizar o caminha central.
     * 
     * @param Celula i
     * 
     * 
     */

    static void imprimir(Celula i) {
        // imprimir a árvore presente na celula
        impAB(i.raiz);
    }

    /**
     * Metódo de Imprimir Auxiliar
     * 
     * Objetivo imprimir a estrutura a partir da raiz de cada Celula
     * 
     * Como: vamos passar como parametro a Celula e vamos passar celula por celula
     * de forma iterativa. Para imprimir vamos utilizar o caminha central.
     * 
     * @param No raiz
     * 
     */

    static void impAB(No raiz) {
        // metódo de caminha central Esq->No->Dir
        if (raiz != null) { // teste para caso vazio
            impAB(raiz.esq); // esquerda
            System.out.println(raiz.elemento);
            impAB(raiz.dir);
        }

    }

    /**
     * Metódo Principal
     * 
     * 4.a) Adicionar novo elemento na estrutura
     * 4.b) Retornar elemento de maior valor na estrutura
     * 
     * @var Celula i
     * @var No x
     * @var FiladeArvore BST
     * 
     * @version 4.a)
     *          1 - Testar construtores de cada classe e imprimir - OK
     *          2 - Chamar metódo add e imprimir a estrutura
     * @param args
     */

    public static void main(String[] args) {
        // definir dados
        FiladeArvore BST = new FiladeArvore();
        // chamar metódo de adicionar na árvore
        BST.add(10); // teste de adicionar elemento sem células - OK
        BST.add(20);
        BST.add(30);        
        for (Celula i = BST.head; i != null; i = i.prox) {
            imprimir(i);
        }


    }

    /**
     * TESTES
     * 
     * @version 1 -
     *          No x = new No(5);
     *          Celula i = new Celula(x);
     *          FiladeArvore BST = new FiladeArvore(i);
     *          // Imprimir
     *          System.out.println(BST.head.raiz.elemento);
     * @version 2 -
     * 
     * 
     */

}
