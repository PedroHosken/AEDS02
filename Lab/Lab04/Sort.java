package Lab.Lab04;

import java.util.*;

/*
 *  -------------------------- Documentacao
 *  Pontificia Universidade Catolica de Minas Gerais
 *  Curso de Ciencia da Computacao
 *  Algoritmos e Estruturas de Dados II
 *  
 *  LAB04 - 03 / 09 / 2024
 *  Author: Pedro Hosken Fernandes Guimarães
 *   
 *  Para compilar em terminal (janela de comandos):
 *       Linux : javac Sort.java
 *       Windows: javac Sort.java
 *   
 *  Para executar em terminal (janela de comandos):
 *       Linux : java Sort
 *       Windows: java Sort
 *   
*/

public class Sort {

  // Atributos da classe
  public int num;
  public int Pi;
  public int mod;
  static Sort[] lista;

  /**
   * Construtor que inicializa a lista
   * 
   * @param int tam
   */

  public Sort(int tam) {
    lista = new Sort[tam];

  }

  /**
   * Construtor individual do Objeto
   * 
   * @param int Valor
   */

  public Sort(int val, int Pi, int mod) {
    this.num = val;
    this.Pi = Pi;
    this.mod = mod;
  }

   /**
   * Metódo que ordena por valor do mod
   * 
   * @param Sort[] numeros
   * @param int tam
   */

   public void ordMod( Sort[] numeros, int tam) {
    for (int i = 1; i < tam; i++) {
      Sort key = numeros[i]; // Objeto atual
      int j = i - 1;

      // Compara o atributo 'valor' dos objetos Sort para determinar a ordem
      while (j >= 0 && numeros[j].mod > key.mod) {
          numeros[j + 1] = numeros[j]; // Desloca os objetos para frente
          j = j - 1;
      }
      numeros[j + 1] = key; // Insere o objeto na posição correta
  }
}

 /**
   * Metódo que ordena por numero impar
   * 
   * @param int num
   * @param int Pi
   */

    public void ordIMP( Sort[] numeros, int tam) {
      for (int i = 1; i < tam; i++) {
        Sort key = numeros[i]; // Objeto atual
        int j = i - 1;

        // Compara o atributo 'valor' dos objetos Sort para determinar a ordem
        while (j >= 0 && numeros[j].Pi < key.Pi) {
            numeros[j + 1] = numeros[j]; // Desloca os objetos para frente
            j = j - 1;
        }
        numeros[j + 1] = key; // Insere o objeto na posição correta
    }
  }

  /**
   * Metódo que imprime os valores guardados no array
   * 
   */
  public void imprimirDetalhes() {
    System.out.println("Nome: " + this.num + ", Par ou Impar: " + this.Pi);
  }

  /**
   * Funcao prinicipal.
   * 
   * @param args
   */
  public static void main(String[] args) {
    // definir dados
    MyIO.setCharset("UTF-8");
    int M = 0, N = 0;
    int PI = 0;
    int MOD = 0;
    Scanner scanner = new Scanner(System.in);
    String linha;
    // metodo de leitura e construção da lista
    linha = scanner.nextLine();
    String[] Num = linha.trim().split("\\s+");
    N = Integer.parseInt(Num[0]);
    M = Integer.parseInt(Num[1]);
    while (N != 0 && M != 0) {
      Sort[] numeros = new Sort[N];
      for (int c = 0; c < N; c++) {
        int x = MyIO.readInt();
        if (x % 2 == 0) {
          PI = 0;
        } else {
          PI = 1;
        }
        MOD = x % M;
        numeros[c] = new Sort(x, PI, MOD);
      }
      Sort sorter = new Sort(0);
      sorter.ordMod(numeros, N);
     // sorter.ordIMP(numeros, N);
      for (Sort numero : numeros) {
        numero.imprimirDetalhes();
      }
      linha = scanner.nextLine();
      String[] Num2 = linha.trim().split("\\s+");
      N = Integer.parseInt(Num2[0]);
      M = Integer.parseInt(Num2[1]);

    }
    // fechar scanner
    scanner.close();
  } // end main ( )

}
