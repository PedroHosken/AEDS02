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
            System.out.println(aluno.name + " " + aluno.reg + " " + aluno.dist);
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
     *          caso empate, por nome
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