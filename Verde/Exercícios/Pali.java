package Verde.Exercícios;

import java.util.*;

public class Pali {

    // função booleana para testar
    public static boolean isPali(String palavra) {
        // definir dados
        boolean is = true;
        int x = 0;
        int y = palavra.length() - 1;
        char a = 'a';
        char b = 'b';
        // metodo iterativo
        while (x <= y) {
            a = palavra.charAt(x);
            b = palavra.charAt(y);
            if (a != b) {
                is = false;
            }
            x++;
            y--;
        }
        // retornar
        return is;
    }

    // função main
    public static void main(String args[]){
        //definir dados
          Scanner scanner = new Scanner(System.in);
          String palavra;
          boolean is = false;
        //ler palavra e chamar função
          do{
             palavra = scanner.nextLine();
             if(!palavra.equals("FIM")){
                is = isPali(palavra);
                if(is){
                    System.out.println("SIM");
                }
                else{
                    System.out.println("NAO");
                }
             }
          }while(!palavra.equals("FIM"));
        //fechar scanner
          scanner.close();
          
      }

}
