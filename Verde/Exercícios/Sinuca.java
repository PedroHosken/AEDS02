/**
 * Exercicio das Bolas de Sinuca
 * 
 * @author Pedro Hosken
 * @version 1 16/09/2024
 */

package Verde.Exercícios;

public class Sinuca {

    /**
     * Função Main
     * Vai chamar outros metódos e realizar a leitura
     * 
     * @param String args[]
     */

    public static void main(String args[]) {
        // definir dados
        int n = MyIO.readInt();
        String primeira = MyIO.readLine();
        String nova = "";
        // chamar metódo de geradora enquanto <= n
        for (int i = n; i >= 1; i--) {
            nova = geradora(i, primeira);
            MyIO.println(nova);
        }
    }

    /**
     * Função Geradora
     * Realiza a produção da nova linha e retorna-a
     * 
     * @param int    tam, tamanho da nova String
     * @param String velha, valores da ultima linha
     * @return String nova, nova String formada pela lógica
     */

    static String geradora(int tam, String velha) {
        // definir dados
        String nova = "";
        StringBuilder aux = new StringBuilder();
        char p = '1';
        char b = '0';
        // ler string velha e formar a nova
        for (int x = 0; x < tam - 1; x++) {
            if (velha.charAt(x) == velha.charAt(x + 1)) {
                aux.append(p);
            } else {
                aux.append(b);
            }
        }
        // return
        nova = aux.toString();
        return nova;
    }

}
