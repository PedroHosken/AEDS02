

import java.util.*;

public class Lab01 {
  // metodo que retorna total de maiusculos
  public static int total(String palavra) {
    // definir dados
    int total = 0;
    int x = 0;
    // metodo iterativo de ler palavra letra por letra
    for (x = 0; x < palavra.length(); x = x + 1) {
      char letra = palavra.charAt(x);
      if ('A' <= letra && letra <= 'Z') {
        total++;
      }
    }
    // retornar
    return total;
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
      if (!palavra.equals("FIM")){
        totM = total(palavra);
        System.out.println("O total de maiusculas é " + totM);
      }
    } while (!palavra.equals("FIM"));
    //lembrar de fechar scanner
      scanner.close();
  }
}
