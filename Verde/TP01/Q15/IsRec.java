package Verde.TP01.Q15;

public class IsRec {

    // metodo de leitura enquanto deiferente de FIM
    static void start() {
        // definir dados
        boolean p1 = false, p2 = false, p3 = false, p4 = false;
        String input = MyIO.readLine();
        // metodo iterativo de leitura
        while (!input.equals("FIM")) {
            p1 = vogais(input);
            p2 = consoantes(input);
            p3 = inteiros(input);
            p4 = reais(input);
            MyIO.println((p1 ? "SIM" : "NAO") + " " + (p2 ? "SIM" : "NAO") + " " + (p3 ? "SIM" : "NAO") + " "
                    + (p4 ? "SIM" : "NAO"));
            input = MyIO.readLine();
        }
    }

    // metodo de chamada de recursão
    static boolean vogais(String palavra) {
        // definir dados
        int tam = palavra.length();
        // retornar valor
        return vogais(palavra, 0, tam);
    }

    // metodo de verificar vogais recursivamente
    static boolean vogais(String palavra, int x, int tam) {
        // definir dados
        boolean is = true;// MUITO IMPORTANTE PARA RECURSIVIDADE
        char c = 'a';
        // opção de parada
        if (x < tam) {

            c = palavra.charAt(x);
            if ((c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u') || (c == 'A') || (c == 'E')
                    || (c == 'I') || (c == 'O') || (c == 'U')) {
                is = true;
                is = vogais(palavra, x + 1, tam);
            } else {
                is = false;
                x = tam + 1;
            }

        }
        // retornar valor
        return is;
    }

    // metodo de chamada de recursão
    static boolean consoantes(String palavra) {
        // definir dados
        int tam = palavra.length() - 1;
        // retornar valor
        return consoantes(palavra, 0, tam);
    }

    // metodo de verificar consoantes recursivamente
    static boolean consoantes(String palavra, int x, int tam) {
        // definir dados
        boolean is = true;// MUITO IMPORTANTE PARA RECURSIVIDADE
        char c = 'a';
        // ponto de parada
        if (x <= tam) {
            c = palavra.charAt(x);
            if ((c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u') || (c == 'A') || (c == 'E')
                    || (c == 'I') || (c == 'O') || (c == 'U')) {
                is = false;
                x = tam + 1;
            } else if (c >= '0' && c <= '9') {
                is = false;
                x = tam + 1;
            } else if (c == '.' || c == ',') {
                is = false;
                x = tam + 1;
            } else {
                is = true;
                is = consoantes(palavra, x + 1, tam);
            }
        }
        // retornar valor
        return is;
    }

    // metodo de chamada de recursão
    static boolean inteiros(String palavra) {
        // definir dados
        int tam = palavra.length();
        // retornar valor
        return inteiros(palavra, 0, tam);
    }

    // metodo de analisar inteiros recursivamente
    static boolean inteiros(String palavra, int x, int tam) {
        // definir dados
        boolean is = true;// MUITO IMPORTANTE PARA RECURSIVIDADE
        char c = 'a';
        // ponto de parada
        if (x < tam) {
            c = palavra.charAt(x);
            if (c >= '0' && c <= '9') {
                is = true;
                is = inteiros(palavra, x + 1, tam);
            } else {
                is = false;
                x = tam + 1;
            }
        }
        // retornar
        return is;
    }

    // metodo de chamada de recursão
    static boolean reais(String palavra) {
        // definir dados
        int tam = palavra.length();
        int virg = 0;
        // retornar valor
        return reais(palavra, 0, tam, virg);
    }

    // metodo de analisar reais recursivamente
    static boolean reais(String palavra, int x, int tam, int virg) {
        // definir dados
        boolean is = true; // MUITO IMPORTANTE PARA RECURSIVIDADE
        char c = 'a';
        // ponto de parada
        if (x < tam) {

            c = palavra.charAt(x);
            if (c >= '0' && c <= '9') {
                is = true;
                is = reais(palavra, x + 1, tam, virg);
            } else if (c == '.' || c == ',') {
                is = true;
                is = reais(palavra, x + 1, tam, virg + 1);
            } else {
                is = false;
                x = palavra.length();
            }
        }
        // verificar existencia de mais de uma virgula
        if (virg > 1) {
            is = false;
        }
        // retornar
        return is;
    }

    // função principal
    public static void main(String args[]) {
        // começar programa
        start();
    }

}
