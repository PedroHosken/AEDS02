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
    // dados
    private No raiz;

    // método requerido pela questão
    /**
     * Metódo Pesquisar
     * 
     * Objetivo: vamos pesquisar se aquela palavra está presente ou não na estrutura
     * 
     * Como: Vamos navegar pelas letras da arvore binária, verificar se está na
     * hash01, caso não esteja mesmo com rehash, vamos para área de reserva e ir
     * para hash2. Vamos verificar qual posição estaria na hash 02 e entrar na lista
     * daquele índice
     * 
     * @param String nome
     * @return boolean is
     * 
     *         Casos: a posição que é para se encontrar está vazia, a posição está
     *         ocupada por outra palavra, ou a palavra estáa naquela posição.
     * 
     * @var No aux
     * @var boolean is
     * @var char i
     * @var T1 c
     * @var char last
     * @var int i1
     * @var int i2
     * @var Celula x
     * 
     *      PASSOS:
     *      1. Pesquisar letra na árvore binária
     *      2. Função de transformação para hash 1
     *      3. Proucurar na hash 1
     *      4.reaalizar o rehash
     *      5.Proucurar posição na hash2
     *      6. verificar lista do índice
     *      7. verificar a lista apontada por aquele indice
     */
    public boolean pesquisar(String nome) {
        // definir dados
        boolean is = false;
        int i2 = 0; // indice para transformação da hash2
        int i1 = 0; // indice retornado da traansformação da hash 1
        char last = nome.charAt(nome.length() - 1); // última letra
        char i = nome.charAt(0); // primeira letra
        // pesquisar na árvore binária
        No aux = pesq(this.raiz, i); // metódo abstraído para pesquisar caractere na árvore binária apontada pela
                                     // raiz
        // verifica o nó correspondente
        if (aux == null) {
            return is; // retorna falso
        }
        // verificar a tabela Hash apontada pelo Nó correspondente
        T1 c = aux.t1; // passa a tabela apontada
        // realizar transformação em T1
        i1 = c.hashT1(last);
        // testar indice
        if (c.palavras[i1] != null) { // caso esteja ocupado
            if (c.palavra[i1].compareTo(nome) == 0) { // testar se é a palavra
                is = true;
                return is;

            } else { // posição ocupada por outra palavra
                i1 = c.reHashT1(last); // realiza o rehash
                if (c.palavra[i1].compareTo(nome) == 0) { // testar se é a palavra
                    is = true;
                    return is;
                } else { // vai para hash 2 - área de reserva de hash1
                    T2 c2 = c.t2; // passa a T2 apontada pela c
                    i2 = c2.hashT2(nome.length() - 1); // metódo que passa como parametro a quantidadde de caracteres
                                                       // da palavra
                    // acessar o índice e verificar se possui algo
                    if (c2.celulast2[i2] == null) { // caso esteja vazio
                        return is;
                    }
                    // percorrer a lista apontada por aquele indice
                    for (Celula x = c2.celulast2[i2].inicio; x.prox != null; x = x.prox) {
                        if (x.palavra.compareTo(nome) == 0) { // encontrou a palavra na lista
                            is = true;
                            return is;
                        }
                    }

                }
            }
        } else {
            return is; // está vazio
        }
        // retornar
        return is;

    }

}
