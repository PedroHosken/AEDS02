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
     * @version 2 - testar ler linha e guardar atributos por espaço em branco
     */
    public static void main(String args[]) {
        // definir dados
        Scanner sc = new Scanner(System.in);
        int n = 0;
        Van aluno = new Van();
        ArrayList<Van> lista = new ArrayList<>();
        String linha = "";
        String name = "";
        int dist = 0;
        char R = 'a';

        // leitura do numero de alunos
        n = sc.nextInt();
        // ler iterativamente
        for (int i = 0; i < n; i++) {
            linha = sc.nextLine();
            String[] dados = linha.split(" ");// separa cada atributo por espaço em branco e atribui a uma posição
            System.out.println(dados[0] + dados[1] + dados[2]);
        }

        // fechar sc
        sc.close();

    }

    /**
     * TESTES
     * 
     * @version 1
     * 
     */
}