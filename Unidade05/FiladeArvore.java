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
    FiladeArvore head, tail;

    // ---- Construtor ---- //
    public FiladeArvore() {
        this.head = null;
        this.tail = null;
    }

    public FiladeArvore(FiladeArvore head, FiladeArvore tail) {
        this.head = head;
        this.tail = tail;
    }

}
