package Unidade05;

/**
 * Pilha dinamica
 * 
 * @author Max do Val Machado
 * @version 2 01/2015
 */
public class Pilha {
    private Celula topo;
    private Celula m; // menor valor

    /**
     * Construtor da classe que cria uma fila sem elementos.
     */
    public Pilha() {
        topo = null;
    }

    /**
     * Insere elemento na pilha (politica FILO).
     * 
     * @param x int elemento a inserir.
     */
    public void inserir(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
        tmp = null;
        // atualizar ponteiro m
        if (x < m.elemento) {
            m = topo; // atualiza para celula que acabou de ser inserida
        }
    }

    /**
     * Remove elemento da pilha (politica FILO).
     * 
     * @return Elemento removido.
     * @trhows Exception Se a sequencia nao contiver elementos.
     */
    public int remover() throws Exception {
        if (topo == null) {
            throw new Exception("Erro ao remover!");
        }
        // teste para verificar se m == topo
        if (m == topo) { // celula minima está sendo removida
            m = topo.prox;
            for (Celula i = topo.prox.prox; i != null; i = i.prox) { // avança duas casas para não repetirmos
                if (m.elemento > i.elemento) {
                    m = i;
                }
            }
        }
        int resp = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox;
        tmp.prox = null;
        tmp = null;
        return resp;
    }

    /**
     * Mostra os elementos separados por espacos, comecando do topo.
     */
    public void mostrar() {
        System.out.print("[ ");
        for (Celula i = topo; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println("] ");
    }

    public int getSoma() {
        return getSoma(topo);
    }

    private int getSoma(Celula i) {
        int resp = 0;
        if (i != null) {
            resp += i.elemento + getSoma(i.prox);
        }
        return resp;
    }

    public int getMax() {
        int max = topo.elemento;
        for (Celula i = topo.prox; i != null; i = i.prox) {
            if (i.elemento > max)
                max = i.elemento;
        }
        return max;
    }

    public void mostraPilha() {
        mostraPilha(topo);
    }

    private void mostraPilha(Celula i) {
        if (i != null) {
            mostraPilha(i.prox);
            System.out.println("" + i.elemento);
        }
    }

    /**
     * Metódo getMin()
     * 
     * Objetivo: obter o menor valor da pilha em tempo constante O(1).
     * 
     * Como: vamos elaborar um novo ponteiro apontando para célula de menor valor,
     * vamos alterar os metódos de push e pop, para sempre atualizar a celúla de
     * menor valor, quando adicionarmos e removermos uma célula
     * 
     * @return int menor
     * 
     * @var int menor - valor da célula
     * @var Celula m - apontador para a celúla de menor valor
     * 
     * 
     */

    public int getMin() {
        // definir dados
        int min = 0;
        // passar valor para min
        min = m.elemento;
        // return
        return min;
    }

}