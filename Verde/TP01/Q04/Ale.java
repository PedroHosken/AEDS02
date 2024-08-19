package Verde.TP01.Q04;

import java.util.*;

public class Ale {

    // variaveis globais
    static char a, b;

    // metodo de começo
    public static void start() {
        // definir dados
        String input = MyIO.readLine();
        // chamar metodo de sorteio
        gerador();
        // continuar lendo enquanto diferente de FIM
        while (!input.equals("FIM")) {
            MyIO.println(ale(input));
            input = MyIO.readLine();
        }
    }

    // metódo de sorteio
    static void gerador() {

        Random sort = new Random();
        sort.setSeed(4);
        a = (char) (sort.nextInt(26) + 'a');
        b = (char) (sort.nextInt(26) + 'a');
    }
    // metódo de troca aleatoria
    static String ale(String palavra){
        //definir dados
          String nova = "";
          StringBuilder sb = new StringBuilder();
        //verificar iterativamente se possui as letras
          for(int i = 0; i < palavra.length(); i ++){
            if(palavra.charAt(i) == a){
                sb.append(b);
            }
            else{
                sb.append(palavra.charAt(i));
            }
          }
        //transformar em string
          nova = sb.toString();
        //retornar
          return nova;

    }
    // main
    public static void main(String args[]) {
        start();
    }

    /*  Metodos StringBuilder:
    
        append(char c): Adiciona um caractere ao final do StringBuilder.
        append(String str): Adiciona uma string ao final do StringBuilder.
        insert(int offset, String str): Insere uma string na posição especificada no StringBuilder.
        delete(int start, int end): Remove os caracteres entre as posições start e end - 1.
        deleteCharAt(int index): Remove o caractere na posição especificada.
        replace(int start, int end, String str): Substitui os caracteres entre as posições start e end - 1 pela string especificada.
        reverse(): Inverte a ordem dos caracteres no StringBuilder.
        length(): Retorna o comprimento atual do StringBuilder.
        charAt(int index): Retorna o caractere na posição especificada.
        setCharAt(int index, char c): Define o caractere na posição especificada para o caractere especificado.
        substring(int start): Retorna uma nova string que é uma subcadeia da string atual, começando na posição start.
        substring(int start, int end): Retorna uma nova string que é uma subcadeia da string atual, começando na posição start e indo até a posição end - 1.
     */

}
