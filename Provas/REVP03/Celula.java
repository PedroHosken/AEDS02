package Provas.REVP03;

/**
 * Questão 03
 * 
 * @author Pedro Hosken Fernandes Guimarães - 816561
 * @version 1.0 - 08/12/2024
 */

// ---- Classes Auxiliares ---- //
class No {
    public char caracter;
    public T1 t1;
    public No esq, dir;
}

class T1 {
    public String palavras[];
    public T2 t2;
}

class T2 {
    public CelulaT2 celulast2[];
}

class CelulaT2 {
    public Celula inicio;
    public Celula fim;
}

class Celula {
    public String palavra;
    public Celula prox;
}

public class DO {

}
