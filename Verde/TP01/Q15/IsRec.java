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

    // metodo de verificar vogais
    static boolean vogais(String palavra) {
        // definir dados
        boolean is = false;
        char c = 'a';
        // metodo iterativo
        for (int x = 0; x < palavra.length(); x++) {
            c = palavra.charAt(x);
            if ((c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u') || (c == 'A') || (c == 'E')
                    || (c == 'I') || (c == 'O') || (c == 'U')) {
                is = true;
            } else {
                is = false;
                x = palavra.length();
            }
        }
        // retornar valor
        return is;
    }

    // metodo de verificar vogais
    static boolean consoantes(String palavra) {
        // definir dados
        boolean is = false;
        char c = 'a';
        // metodo iterativo
        for (int x = 0; x < palavra.length(); x++) {
            c = palavra.charAt(x);
            if ((c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u') || (c == 'A') || (c == 'E')
                    || (c == 'I') || (c == 'O') || (c == 'U')) {
                is = false;
                x = palavra.length();
            } else if (c >= '0' && c <= '9') {
                is = false;
                x = palavra.length();
            } else if (c == '.' || c == ',') {
                is = false;
                x = palavra.length();
            } else {
                is = true;
            }
        }
        // retornar valor
        return is;
    }

    // metodo de analisar inteiros
    static boolean inteiros(String palavra) {
        // definir dados
        boolean is = false;
        char c = 'a';
        // metodo iterativo de analise de inteiros
        for (int x = 0; x < palavra.length(); x++) {
            c = palavra.charAt(x);
            if (c >= '0' && c <= '9') {
                is = true;
            } else {
                is = false;
                x = palavra.length();
            }
        }
        // retornar
        return is;
    }

    // metodo de analisar reais
    static boolean reais(String palavra) {
        // definir dados
        boolean is = false;
        char c = 'a';
        int virg = 0;
        // metodo iterativo de analise de inteiros
        for (int x = 0; x < palavra.length(); x++) {

            c = palavra.charAt(x);
            if (c >= '0' && c <= '9') {
                is = true;
            } else if (c == '.' || c == ',') {
                is = true;
                virg++;
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
