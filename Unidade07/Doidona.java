package Unidade07;

/**
 * Implementação da Doidona sem TADS
 * 
 * @author Pedro Hosken -816561
 * @version 2.0 - 06/12/2024
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

    // construtor padrão
    public Celula(int x) {
        this.val = x;
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

    // construtor com passagem de valor
    public No(int x) {
        this.val = x;
        this.dir = this.esq = null;
    }
}

/**
 * Estrutura do Árvore, construtores e metódos
 */
class Ab {
    // atributos
    public int val;
    public No raiz;

    // construtor padrão
    public Ab() {
        this.val = 0;
        this.raiz = null;
    }

    // metodo de inserir
    public void inserir(int x, No raiz) {
        // teste para se raiz é nula
        if (raiz == null) {
            No nv = new No(x);
            raiz = nv; // aponta raiz para nv
        } else if (x > raiz.val) {
            inserir(x, raiz.dir);
        } else if (x < raiz.val) {
            inserir(x, raiz.esq);
        } else {
            // casos igual
            System.out.println("Não inserimos valores iguais");
        }

    }

    // metodo de pesquisar
    public boolean pesq(int x, No raiz) {
        // definir dados
        boolean is = false;
        // realizar pesquisar
        if (raiz == null) {
            is = false;
        } else if (raiz.val == x) {
            is = true;
        } else if (x > raiz.val) {
            pesq(x, raiz.dir);
        } else {
            pesq(x, raiz.esq);
        }
        // retornar
        return is;
    }

    // metodo de caminhar central
    public void caminharCentral(No raiz) {
        caminharCentral(raiz.esq);
        System.out.println(raiz.val);
        caminharCentral(raiz.dir);
    }

    /**
     * Metodo publico iterativo para remover elemento.
     * 
     * @param x Elemento a ser removido.
     * @throws Exception Se nao encontrar elemento.
     */
    public void remover2(int x) throws Exception {
        if (raiz == null) {
            throw new Exception("Erro ao remover2!");
        } else if (x < raiz.val) {
            remover2(x, raiz.esq, raiz);
        } else if (x > raiz.val) {
            remover2(x, raiz.dir, raiz);
        } else if (raiz.dir == null) {
            raiz = raiz.esq;
        } else if (raiz.esq == null) {
            raiz = raiz.dir;
        } else {
            raiz.esq = maiorEsq(raiz, raiz.esq);
        }
    }

    /**
     * Metodo privado recursivo para remover val.
     * 
     * @param x   val a ser removido.
     * @param i   No em analise.
     * @param pai do No em analise.
     * @throws Exception Se nao encontrar val.
     */
    private void remover2(int x, No i, No pai) throws Exception {
        if (i == null) {
            throw new Exception("Erro ao remover2!");
        } else if (x < i.val) {
            remover2(x, i.esq, i);
        } else if (x > i.val) {
            remover2(x, i.dir, i);
        } else if (i.dir == null) {
            pai = i.esq;
        } else if (i.esq == null) {
            pai = i.dir;
        } else {
            i.esq = maiorEsq(i, i.esq);
        }
    }

    /**
     * Metodo para trocar o elemento "removido" pelo maior da esquerda.
     * 
     * @param i No que teve o elemento removido.
     * @param j No da subarvore esquerda.
     * @return No em analise, alterado ou nao.
     */
    private No maiorEsq(No i, No j) {

        // Encontrou o maximo da subarvore esquerda.
        if (j.dir == null) {
            i.val = j.val; // Substitui i por j.
            j = j.esq; // Substitui j por j.ESQ.

            // Existe no a direita.
        } else {
            // Caminha para direita.
            j.dir = maiorEsq(i, j.dir);
        }
        return j;
    }
}

/**
 * Estrutura da Lista
 */
class Lista {
    // atributos
    public int val;
    public Celula primeiro, ultimo;

    // construtor padrão
    public Lista() {
        this.val = 0;
        Celula tmp = new Celula();
        this.primeiro = this.ultimo = tmp;
    }

    // metodo de inserir no fim
    public void inserir(int x) {
        // teste para caso lista vazia
        if (primeiro == ultimo) {
            Celula tmp = new Celula(x);
            ultimo = tmp;
            primeiro.prox = ultimo;
        } else {
            Celula tmp = new Celula(x);
            ultimo.prox = tmp;
            ultimo = tmp;
        }
    }

    // metodo de pesquisar
    public boolean pesq(int x) {
        // definir dados
        boolean is = false;
        // pesquisar
        for (Celula i = this.primeiro.prox; i.prox != null; i = i.prox) {
            if (i.val == x) {
                is = true;
            }
        }
        // retornar
        return is;
    }

    // metodo de remover no final tambem
    public int remover(int x) {
        // definir dados
        int y = 0;
        // teste para caso lista vazia
        if (primeiro == ultimo) {
            System.out.println("Lista está vazia");
        } else {
            Celula tmp;
            for (tmp = this.primeiro.prox; tmp.prox != ultimo; tmp = tmp.prox)
                ;
            y = ultimo.val;
            tmp.prox = null;
            ultimo = tmp;

        }
        // retornar
        return y;
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

    // definir estruturas
    Ab ab3;
    Lista lista;
    Ab ab2;

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

        // inicializa as árvores
        ab3 = new Ab();
        ab2 = new Ab();
        // inicializa a Lista
        lista = new Lista();
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
            h1[aux] = elemento; // insere naquela posição
        } else { // esta ocupado
            aux = hashT2(elemento); // retorno do valor da posição na Hash
            if (aux == 1) { // vai pra T3
                aux = hashT3(elemento);
                if (h3[aux] == NULO) { // caso de posição válida, insere
                    h3[aux] = elemento;
                } else { // está ocupado aquela posição
                    // inserir na árvore apontada pela raiz T3
                    ab3.inserir(elemento, ab3.raiz); // insere na árvore da raiz 3
                }
            } else if (aux == 2) { // lista encadeada
                lista.inserir(elemento); // insere o elemento na lista

            } else { // arvore binária
                ab2.inserir(elemento, ab2.raiz); // insere o elemento na árvore de raiz 2
            }
        }
    }

}
