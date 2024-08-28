package Verde.TP01.Q10;


public class pali_recu {

    //função main
      public static void main (String args[]){
        //definir dados
          String palavra;
          boolean is = false;
        //ler string e chamar funções
          palavra = MyIO.readLine();
          while (!palavra.equals("FIM")) {
            is = recu(palavra);
            MyIO.println((is ? "SIM" : "NAO"));
            palavra = MyIO.readLine();            
          }
      }

    //chamada de função recursiva
      static boolean recu(String palavra){
        return recu(palavra,0, palavra.length() -1);
      }
    //função recursiva atuando
      static boolean recu(String palavra, int x, int y){
        //definir dados
          boolean is = true;
        //parada da recursividade
          if (x <= y){
            if(palavra.charAt(x) != palavra.charAt(y)){
                is = false;
                x = y + 1;
            }
            else{
                is = true;
                is = recu(palavra, x + 1, y - 1);
            }
          }
        //return
          return is;
      }
}
