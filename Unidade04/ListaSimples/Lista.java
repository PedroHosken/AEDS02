package Unidade04.ListaSimples;

import Unidade05.Celula;

/**
 * Lista dinamica
 * 
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Lista {
    public Celula primeiro;
    public Celula ultimo;

    /**
     * Construtor da classe que cria uma lista sem elementos (somente no cabeca).
     */
    public Lista() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    /**
     * Insere um elemento na primeira posicao da lista.
     * 
     * @param x int elemento a ser inserido.
     */
    public void inserirInicio(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
    }

    /**
     * Insere um elemento na ultima posicao da lista.
     * 
     * @param x int elemento a ser inserido.
     */
    public void inserirFim(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    /**
     * Remove um elemento da primeira posicao da lista.
     * 
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista nao contiver elementos.
     */
    public int removerInicio() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        }

        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        int resp = primeiro.elemento;
        tmp.prox = null;
        tmp = null;
        return resp;
    }

    /**
     * Remove um elemento da ultima posicao da lista.
     * 
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista nao contiver elementos.
     */
    public int removerFim() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        }

        // Caminhar ate a penultima celula:
        Celula i;
        for (i = primeiro; i.prox != ultimo; i = i.prox)
            ;

        int resp = ultimo.elemento;
        ultimo = i;
        i = ultimo.prox = null;

        return resp;
    }

    /**
     * Insere um elemento em uma posicao especifica considerando que o
     * primeiro elemento valido esta na posicao 0.
     * 
     * @param x   int elemento a ser inserido.
     * @param pos int posicao da insercao.
     * @throws Exception Se <code>posicao</code> invalida.
     */
    public void inserir(int x, int pos) throws Exception {

        int tamanho = tamanho();

        if (pos < 0 || pos > tamanho) {
            throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tamanho) {
            inserirFim(x);
        } else {
            // Caminhar ate a posicao anterior a insercao
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            Celula tmp = new Celula(x);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = i = null;
        }
    }

    /**
     * Remove um elemento de uma posicao especifica da lista
     * considerando que o primeiro elemento valido esta na posicao 0.
     * 
     * @param posicao Meio da remocao.
     * @return resp int elemento a ser removido.
     * @throws Exception Se <code>posicao</code> invalida.
     */
    public int remover(int pos) throws Exception {
        int resp;
        int tamanho = tamanho();

        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");

        } else if (pos < 0 || pos >= tamanho) {
            throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
        } else if (pos == 0) {
            resp = removerInicio();
        } else if (pos == tamanho - 1) {
            resp = removerFim();
        } else {
            // Caminhar ate a posicao anterior a insercao
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            Celula tmp = i.prox;
            resp = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            i = tmp = null;
        }

        return resp;
    }

    /**
     * Mostra os elementos da lista separados por espacos.
     */
    public void mostrar() {
        System.out.print("[ ");
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println("] ");
    }

    /**
     * Procura um elemento e retorna se ele existe.
     * 
     * @param x Elemento a pesquisar.
     * @return <code>true</code> se o elemento existir,
     *         <code>false</code> em caso contrario.
     */
    public boolean pesquisar(int x) {
        boolean resp = false;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            if (i.elemento == x) {
                resp = true;
                i = ultimo;
            }
        }
        return resp;
    }

    /**
     * Calcula e retorna o tamanho, em numero de elementos, da lista.
     * 
     * @return resp int tamanho
     */
    public int tamanho() {
        int tamanho = 0;
        for (Celula i = primeiro; i != ultimo; i = i.prox, tamanho++)
            ;
        return tamanho;
    }

    /**
     * Metódo MiddleNode
     * Objetivo: identificar a celula do meio, sem saber o tamanho total da lista
     * 
     * Como: vamos ter váriaveis de esquerda e direita, quando forem iguais, é o do
     * meio, caso número seja par de celúlas válidas, vamos escolher a da esquerda.
     * 
     * Implementação: em listas com números pares, a diferença pode será de 1, da
     * celúla anterior a do meio, de números impares a diferença sempre será >= 2.
     * 
     * Casos especiais: apenas 1 célula: vamos considera-la a do meio
     * 
     * @param Celula primeiro
     * @return Celula meio
     * 
     * @var int esq - contagem de celulas à esquerda
     * @var int dir - contagem de celulas à direita
     * @var Celula meio - celula do meio
     * @var Celula i - percorrer lista
     * @var Celula tmp - ponteiro de ajuda
     * 
     */

    public Celula MiddleNode(Celula primeiro) throws Exception {
        // teste de Lista vazia
        if (primeiro == ultimo) {
            throw new Exception("Erro (vazia)!");
        }
        // definir dados
        Celula meio = null;
        int esq = 0;
        // avançar par celúla válida
        Celula i = primeiro.prox;
        Celula tmp = i;
        // verificar se é a única CASO ESPECIAL
        if (i.prox == null) {
            meio = i;
        } else {
            // vamos avançar mais uma celula
            i = i.prox;// chegamos na 2 celula
            tmp = i;// avança com tmp
            esq = esq + 1;// temos a primeira celula à esquerda
            // forma iterativa de identificar o meio
            while (i != meio) {
                int dir = 0;
                tmp = i;// volta tmp para seu devido lugar
                // percorrer celulas à direita
                while (tmp.prox != null) {
                    tmp = tmp.prox;
                    dir = dir + 1;// atualiza casas a direita da celula i
                }
                // testar se esq - dir = 1 CASO DE LISTA PAR
                if (dir - esq == 1) {
                    meio = i;
                } else {
                    // testar se esq - dir = 0 CASO DE LISTA ÍMPAR
                    if (esq - dir == 0) {
                        meio = i;
                    } else {
                        // caso não seja nenhum dos casos avançar i
                        i = i.prox;// i avança uma casa para direita
                        esq = esq + 1;// esq atualiza + 1
                    }
                }

            }
        }
        // retornar
        return meio;
    }

    /**
     * Metódo de ReverseNode
     * 
     * Objetivo: inverter a lista flexível.
     * 
     * Como: vamos inverter o fluxo de ponteiros. Vamos receber o nó cabeça,
     * inicializar 03 ponteiros, e ir andando com o principal e fazendo ele apontar
     * para o anterior, vamos ter outro que vamos usar para não perder referencia
     * para lista. Vamos andar com a celula atual de forma iterativa
     * 
     * @param Celula primeiro
     * 
     * @return Celula primeiro
     * 
     * @throws Exception - caso de lista vazia
     * 
     * @var Celula ant - anterior
     * @var Celula at - atual
     * @var Celula post - posterior
     * 
     */
    public Celula ReverseNode(Celula primeiro) throws Exception {
        // Teste para lista vazia
        if (primeiro == null || primeiro.prox == null) {
            throw new Exception("Erro (lista vazia ou com um único elemento)!");
        }

        // Definir ponteiros iniciais
        Celula ant = null;
        Celula at = primeiro.prox;
        Celula dep;

        // Loop para inverter os ponteiros
        while (at != null) {
            dep = at.prox; // Salvar próxima célula
            at.prox = ant; // Inverter ponteiro
            ant = at; // Avançar ant
            at = dep; // Avançar at para o próximo nó
        }

        // Redefinir o início da lista para o novo primeiro nó
        primeiro.prox = ant;

        return primeiro;
    }

}