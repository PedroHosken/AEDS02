public class Palindromo {

    public static boolean Pali(int array[], int n) throws Exception {
        // definir dados
        Pilha pilha = new Pilha(n);
        Fila fila = new Fila(n);
        boolean is = true;
        int x = 0;
        int um = 0;
        int dois = 0;

        // preencher fila e pilha com numeros do array
        for (int z = 0; z < n; z++) {
            int num = array[z];
            pilha.inserir(num);
        }
        for (int k = 0; k < n; k++) {
            int num2 = array[k];
            fila.inserir(num2);
        }
        // testar se é palindromo a sequencia
        while (x < n) {
            um = pilha.remover();
            dois = fila.remover();
            if( um != dois){
                is = false;
                x = n + 1;
            }
            else{
                is = true;
                x++;
            }
        }
        // retornar
        return is;
    }

    public static void main(String[] args) throws Exception {
        int array[] = {2,2,2,2,2};
        boolean is = Pali(array, 5);
        MyIO.println(is);
    }
}
