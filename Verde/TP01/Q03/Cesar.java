package Verde.TP01.Q03;

//import java.util.*;

public class Cesar {

  // metodo de alteração de valor da letra
  public static char Alt(char a) {
    // definir dados
    int var = 3;
    // metódo de alteração de valor
    char nova = (char) (a + var);
    // retornar valor nova
    return nova;
  }

  // metodo de Ciframento
  public static String cesar(String palavra) {
    // definir dados
    String nova = "";
    char c = 'a';
    char novo = 'c';
    StringBuilder sb = new StringBuilder();
    // metodo iterativo
    for (int x = 0; x < palavra.length(); x++) {
      c = palavra.charAt(x);
      novo = Alt(c);
      sb.append(novo);
    }
    // montar nova string
    nova = sb.toString();
    System.out.println(nova);
    // retornar
    return nova;
  }

  // main
  public static void main(String args[]) {
    // definir dados
     // Scanner scanner = new Scanner(System.in);
    String palavra;
    // ler palavra e chamar função
    do {
      // palavra = scanner.nextLine();
      palavra = MyIO.readLine();
      if (!palavra.equals("FIM")) {
        cesar(palavra);
      }

    } while (!palavra.equals("FIM"));
    // fechar scanner
    // scanner.close();

  }

}
