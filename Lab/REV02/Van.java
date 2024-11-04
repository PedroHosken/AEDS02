package Lab.REV02;

/**
 * Exercício da Van
 * 
 * @author Pedro Hosken - 816561
 * @version 1 - 04/11/2024
 */

// ---- Dependências ----//
import java.util.*;

// ---- CLASSE ---- //
class Van {
    // ---- Atributos ALUNO ---- //
    public String name;
    public int dist;
    public char reg;

    /**
     * Metódo Construtor Sem parametros
     * 
     * @param args
     */
    public Van() {
        this.name = "";
        this.dist = 0;
        this.reg = 'a';
    }

    /**
     * Metódo Construtor com Parametros
     * 
     * @param String name
     * @param int    dist
     * @param char   reg
     * 
     */
    public Van(String name, int dist, char reg) {
        this.name = name;
        this.dist = dist;
        this.reg = reg;
    }

    /**
     * Metódo de Imprimir lista
     * Objetivo: imprimir a lista percorrendo cada componente presente
     * Como: iterativamente = for
     * 
     * @param ArrayLista<Van> lista
     * 
     * @var Van aluno - controle de cada aluno no metódo
     * 
     */
    static void imprimir(ArrayList<Van> lista) {
        // realizar metódo iterativo
        for (Van aluno : lista) {
            System.out.println(aluno.name); // atualizado
        }
    }

    /**
     * Metódo ord
     * Objetivo: ordenar lista de alunos, por menor distancia de cada região, e caso
     * empate, pelo nome
     * Como: vamos utilizar o metódo de seleção para ordenar pro região, caso for a
     * mesma, pela distancia, caso for a mesma, pelo nome
     * 
     * ordering the students from a distance (from lowest to highest), by region (in
     * alphabetical order) and last by name.
     * 
     * @var Van tmp - variável auxiliar para fazermos as trocas
     * @var int Menor - menro valor da lista, posição
     * @var int i - variavél de controle
     * @param args
     */
    static void ord(ArrayList<Van> lista) {
        // algoritmo de seleção
        for (int i = 0; i < lista.size() - 1; i++) {
            int menor = i; // pega posição do aluno de primeiro valor
            for (int j = (i + 1); j < lista.size(); j++) {
                if (lista.get(menor).reg > lista.get(j).reg) { // comparação por REG
                    menor = j; // atualiza posição do menor
                } else {
                    if (lista.get(menor).reg == lista.get(j).reg) { // MESMA REG
                        if (lista.get(menor).dist > lista.get(j).dist) { // comp de DIST
                            menor = j; // atualiza menor

                        } else {
                            if (lista.get(menor).dist == lista.get(j).dist) { // MESMA DIST
                                if (lista.get(menor).name.compareTo(lista.get(j).name) > 0) {
                                    menor = j; // atualiza menor
                                }
                            }

                        }

                    }
                }

            }
            // metódo swap
            Van tmp = lista.get(menor);
            // Troca o elemento i pelo elemento j
            lista.set(menor, lista.get(i));
            // Coloca o valor temporário na posição j
            lista.set(i, tmp);

        }
    }

    /**
     * Função Main
     * Objetivo: Leitura do número de alunos, ler os atributos de cada aluno,
     * guardar cada um em um array, chamar metódo de ordenação, e printar lista
     * ordenada.
     * 
     * Como; ler inteiros, numero de alunos, ler a linha de cada aluno e separar com
     * split, guardar cada atributo por linha lida, por fim chamar metódo de
     * ordenação e printar na tela
     * 
     * @var int n - numero de alunos
     * @var aluno - objeto de aluno criado
     * @var ArrayList - lista com numero de alunos
     * @var String Name - nome do aluno
     * @var Char R- região que vive
     * @var Int Dist - distancia
     * @var Scanner - variavel para leitura
     * @var String linha - linha para guardarmos as informações
     * @var String[] dados - atributos
     * 
     * 
     * @version 1 - testar construtores - OK
     * @version 2 - testar ler linha e guardar atributos por espaço em branco - OK
     * @version 3 - testar guardar cada atributo em uma váriavel e formar o aluno -
     *          OK
     * @version 4 - testar se está guradando na lista + metódo de imprimir - OK
     * @version 5 - realizar metódo de ordenação por menor distancia da região, e
     *          caso empate, por nome - OK
     * 
     */
    public static void main(String args[]) {
        // definir dados
        Scanner sc = new Scanner(System.in);
        int n = 0;
        ArrayList<Van> lista = new ArrayList<>();
        String linha = "";
        String name = "";
        int dist = 0;
        char R = 'a';

        // leitura do numero de alunos
        n = sc.nextInt();
        sc.nextLine(); // Consumir a quebra de linha após a leitura do número

        // ler iterativamente
        for (int i = 0; i < n; i++) {
            linha = sc.nextLine();
            String[] dados = linha.split(" ");// separa cada atributo por espaço em branco e atribui a uma posição
            name = dados[0]; // guardar nome
            R = dados[1].charAt(0);// caractere da região
            dist = Integer.parseInt(dados[2]); // pega distancia
            Van aluno = new Van(name, dist, R); // chama construtor
            lista.add(aluno);
        }
        ord(lista); // chama metódo de ordenação
        imprimir(lista); // metódo de imprimir lista

        // fechar sc
        sc.close();

    }

    /**
     * TESTES
     * 
     * @version 1
     * @version 2
     *          System.out.println(dados[0] + dados[1] + dados[2]);
     * @version 3
     *          System.out.println(aluno.name + aluno.dist + aluno.reg);
     * 
     */
}