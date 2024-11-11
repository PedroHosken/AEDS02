package Unidade04.ListaSimples;



/**
 * Lista simples dinamica
 * 
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class PrincipalLista {
    public static void main(String[] args) {
        try {
            System.out.println("=== LISTA FLEXIVEL SIMPLESMENTE ENCADEADA ===");
            Lista lista = new Lista();

            lista.inserirFim(4);
            lista.inserirFim(5);
            lista.inserirFim(7);
            lista.inserirFim(8);
            lista.inserirFim(12);

            System.out.print("Apos insercoes: ");
            lista.mostrar();

            Celula invertido = lista.ReverseNode(lista.primeiro);
            for(Celula i = invertido; i != null;  i = i.prox  ){
                System.out.println(i.elemento);
            }
        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }
    }
}

/**
 * TESTES -
 * 
 * @version 1 - Middle Node
 *          Celula meio = lista.MiddleNode(lista.primeiro);
 *          System.out.print("meio.elemento : " + meio.elemento);
 */