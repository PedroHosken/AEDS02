package Lab.Lab03;

/*
 *  -------------------------- Documentacao
 *  Pontificia Universidade Catolica de Minas Gerais
 *  Curso de Ciencia da Computacao
 *  Algoritmos e Estruturas de Dados II
 *   
 *  TP01Q14 - 31 / 08 / 2024
 *  Author: Pedro Hosken Fernandes Guimarães
 *   
 *  Para compilar em terminal (janela de comandos):
 *       Linux : javac Parenteses.java
 *       Windows: javac Parenteses.java
 *   
 *  Para executar em terminal (janela de comandos):
 *       Linux : java Parenteses
 *       Windows: java Parenteses
 *   
*/

public class Parenteses {

  /**
   * Funcao prinicipal.
   * 
   * @param args
   */
  public static void main(String args[]) {
    // definir dados
    String exp = "";
    boolean is1 = false;
    boolean is2 = false;
    // ler e chamar funções
    exp = MyIO.readLine();
    while (!exp.equals("FIM")) {
      is1 = s1(exp);
      is2 = s2(exp);
      // printar resultado na tela
      if (is1 == true && is2 == true) {
        MyIO.println("correto");
      } else {
        MyIO.println("incorreto");
      }
      exp = MyIO.readLine();
    }
  }

  /**
   * Funcao booleana para saber se número de parenteses é o mesmo.
   * 
   * @param exp - String
   * @return booleano
   */

  static boolean s1(String exp) {
    // definir dados
    boolean is = false;
    int esq = 0;
    int dir = 0;
    char p = '(';
    char q = ')';
    // analise iterativamente
    for (int x = 0; x < exp.length(); x++) {
      if (exp.charAt(x) == p) {
        esq++;
      }
      if (exp.charAt(x) == q) {
        dir++;
      }
    }
    if (esq == dir) {
      is = true;
    } else {
      is = false;
    }
    // retornar
    return is;
  }

  /**
   * Funcao booleana para saber se os parenteses primeiro e último estão corretos
   * 
   * @param exp - String
   * @return booleano
   */

  static boolean s2(String exp) {
    // definir dados
    boolean is = false;
    int cont = 0;
    int posp = 0;
    int posu = 0;
    char first = '(';
    char last = ')';
    // analise iterativamente
    for (int x = 0; x < exp.length(); x++) {
      // teste para pegar posição do primeiro
      if ((exp.charAt(x) == first || exp.charAt(x) == last) && cont == 0) {
        posp = x;
        cont++;
      } else {
        // contador para posição do segundo
        if ((exp.charAt(x) == first || exp.charAt(x) == last)) {
          cont++;
          posu = x;
        }
      }
    }
    // testar posp e posu
    if ((exp.charAt(posp) == first) && (exp.charAt(posu) == last)) {
      is = true;
    } else {
      is = false;
    }
    // retornar
    return is;
  }
}
