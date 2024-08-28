package Verde.TP01.Q12;

public class CesarRecu {

    // metodo de alteração de valor da letra
    static char Alt(char a) {
        // metódo de alteração de valor
        char nova = (char) (a + 3);
        // retornar valor nova
        return nova;
    }

    // chamada da recursividade
    static String recu(String palavra) {
        return recu(palavra, 0);
    }

    // função recursiva
    static String recu(String palavra, int x) {
        // definir dados
        String nova = "";
        int tam = palavra.length();
        char alt;
        // StringBuilder sb = new StringBuilder();
        // parada da recursividade
        if (x < tam) {
            alt = palavra.charAt(x);
            alt = Alt(alt);
            // sb.append(alt);
            nova += alt + recu(palavra, x + 1);
        }
        // nova = sb.toString();
        // return
        return nova;
    }

    // função main
    public static void main(String args[]) {
        // definir dados
        String palavra;
        String nova;
        // ler string e chamar funções
        palavra = MyIO.readLine();
        while (!palavra.equals("FIM")) {
            nova = recu(palavra);
            MyIO.println(nova);
            palavra = MyIO.readLine();
        }
    }
}
