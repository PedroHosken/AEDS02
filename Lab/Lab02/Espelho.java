
/**
 * Exercicio do espelho
 * 
 * @author Pedro Hosken
 * @version 1 12/09/2024
 */
package Lab.Lab02;

import java.util.*;

public class Espelho {

    /**
     * Função Principal
     * Ler intervalo + definir dados + chamar metódos
     * 
     */
    public static void main(String[] args) {
        // definir dados
        int inf = 0;
        int sup = 0; // guardar intervalo
        String linha = "";
        Scanner sc = new Scanner(System.in);
        // ler dados e guardar em cada váriavel
        linha = sc.nextLine();
        String[] numeros = linha.split(" ");
        inf = Integer.parseInt(numeros[0]);
        sup = Integer.parseInt(numeros[1]);
        // definir arrays
        int n = sup - inf + 1;
        int[] intv = new int[n];
        int[] inv = new int[n];

        // chamar metódos
        intv = geradora(inf, sup, n);
        for (int numero : intv) {
            System.out.print(numero);
        }
        inv = inversora(n, intv);
        for (int numero2 : inv) {
            System.out.print(numero2);
        }

        // fechar
        sc.close();
    }

    /**
     * Função Geradora
     * Gera um array, com os números do intervalo
     * 
     * @param int inf, int sup, int n
     * @return int array []
     */

    static int[] geradora(int x, int y, int n) {
        // definir dados
        int[] array = new int[n];
        int num = x;
        // preencher novo array com valores
        for (int i = 0; i < n; i++) {
            array[i] = num;
            num = num + 1;
        }
        // retornar
        return array;
    }

    /**
     * Função inversora
     * Recebe um array, chama outro metódo para inverter cada numero, de cada
     * posição do array
     * 
     * @param int intv, int n
     * @return int arrayinvertido[]
     */

    static int[] inversora(int n, int[] array) {
        // definir daodos
        int[] ainv = new int[n];
        int x = 0;
        // percorrer array e chamar para inverter
        for (int i = n - 1; i >= 0; i--) {
            ainv[x] = inverter(array[i]);
            x = x + 1;
        }
        // retornar
        return ainv;
    }

    /**
     * Função inverter
     * Função para inverter cada inteiro do array
     * 
     * @param int val
     * @return int val - 1
     */

    static int inverter(int val) {
        // definir dados
        int valInv = 0;
        String numero = Integer.toString(val);
        String numeroinv = new StringBuilder(numero).reverse().toString();
        // passar valor
        valInv = Integer.parseInt(numeroinv);
        // retornar
        return valInv;
    }

}
