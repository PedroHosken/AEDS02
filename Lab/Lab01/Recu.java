package Lab01;

import java.util.Scanner;

public class Recu {
    // metodo que chama total de maiusculos
    public static int total(String palavra) {
        // chamar 2 função
        return total(palavra, 0);
    }

    // metodo recursivo que realmente faz o teste
    public static int total(String palavra, int x) {
        // definir dados
        int cont = 0;
        char letra = 'a';
        // ponto de parada
        if (x < palavra.length()) {
            letra = palavra.charAt(x);
            if (Character.isUpperCase(letra)) {
                cont++;
            }
            cont += total(palavra, x + 1);
        }
        // retornar
        return cont;
    }

    // função main
    public static void main(String[] args) {
        // definir dados
        String palavra = "";
        int totM = 0;
        Scanner scanner = new Scanner(System.in);
        // fazer metódo enquanto a palavra 'FIM' não for encontrada
        do {
            palavra = scanner.nextLine();
            if (!palavra.equals("FIM")) {
                totM = total(palavra);
                System.out.println("O total de maiusculas é " + totM);
            }
        } while (!palavra.equals("FIM"));
        // lembrar de fechar scanner
        scanner.close();
    }
}
