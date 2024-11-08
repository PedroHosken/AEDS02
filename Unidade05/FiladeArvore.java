package Unidade05;

/**
 * Exercício de Árvore de Lista
 * @author Pedro Hosken - 816561
 * @version 1 - 07/11/2024
 */

/**
 * Classe No e seu construtor
 */
class No {
    public int elemento;
    public No esq, dir;

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
    public Celula prox;
    public No raiz;

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
    public Celula head, tail;

    public FiladeArvore() {
        this.head = null;
        this.tail = null;
    }

    public FiladeArvore(Celula i) {
        this.head = this.tail = i;
    }

    /**
     * Método de adicionar na Fila
     * 
     * @param elemento
     * @return boolean adi
     */
    public boolean add(int elemento) {
        if (head == null && tail == null) {
            // Inicializa a fila vazia com nova célula e árvore
            No nm = new No(elemento);
            Celula nv = new Celula(nm);
            this.head = this.tail = nv;
            return true;
        } else {
            // Adiciona o elemento na árvore na célula atual
            return adicionar(this.head.raiz, elemento);
        }
    }

    /**
     * Método auxiliar para adicionar elementos na árvore da célula
     */
    private boolean adicionar(No raiz, int elemento) {
        if (raiz == null) {
            raiz = new No(elemento);
            return true;
        } else if (elemento > raiz.elemento) {
            if (raiz.dir == null) {
                raiz.dir = new No(elemento);
                return true;
            } else {
                return adicionar(raiz.dir, elemento); // Chamada recursiva
            }
        } else if (elemento < raiz.elemento) {
            if (raiz.esq == null) {
                raiz.esq = new No(elemento);
                return true;
            } else {
                return adicionar(raiz.esq, elemento); // Chamada recursiva
            }
        } else {
            System.out.println("Erro ao adicionar, elementos iguais");
            return false; // Não permite duplicados
        }
    }

    /**
     * Método de Imprimir a fila de árvores
     */
    static void imprimirFila(FiladeArvore fila) {
        for (Celula i = fila.head; i != null; i = i.prox) {
            System.out.print("Árvore na célula: ");
            impAB(i.raiz); // Imprime a árvore na célula
            System.out.println();
        }
    }

    /**
     * Método de Impressão Auxiliar da árvore na célula
     */
    static void impAB(No raiz) {
        if (raiz != null) {
            impAB(raiz.esq);
            System.out.print(raiz.elemento + " ");
            impAB(raiz.dir);
        }
    }

    /**
     * Metódo getMaior
     * 
     * Objetivo: retornar elemento de maior valor da estrutura
     * 
     * Como: vamos percorrer a estrutura, cada celula, comparar elementos de cada
     * árvore, visando seu lado direito, guardar váriavele comparar com as árvores
     * de outras células. Vamos percorrer cada celula iterativamente, por for. Vamos
     * percorrer cada árvore visando seu lado da direita
     * 
     * @param Celula head
     * 
     * @return int
     * 
     * @var int M
     * 
     */

    public int getMaior(Celula head) {
        if (head == null) {
            System.out.println("Estrutura Vazia");
            return 0;
        } else {
            // definir dados
            int M = 0;
            // percorrer celulas
            for (Celula i = head; i != null; i = i.prox) {
                // percorrer árvore de cada celula
                for (No x = i.raiz; x != null; x = x.dir) {
                    if (M < x.elemento) {
                        M = x.elemento;
                    }
                }
            }
            // return
            return M;
        }
    }

    public static void main(String[] args) {
        FiladeArvore fila = new FiladeArvore();
        fila.add(10);
        fila.add(20);
        fila.add(5);
        fila.add(15);
        fila.add(8);
        fila.add(100);

        // Imprime a fila de árvores
        imprimirFila(fila);
        // Maior elemento da estrutura
        int x = fila.getMaior(fila.head);
        System.out.println(x);
    }
}
