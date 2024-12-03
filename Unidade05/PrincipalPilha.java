package Unidade05;

/**
 * Pilha dinamica
 * 
 * @author Max do Val Machado
 * @version 2 01/2015
 */
public class PrincipalPilha {
    public static void main(String[] args) {
        try {
            System.out.println(" ==== PILHA FLEXIVEL ====");
            Pilha pilha = new Pilha();
            int x1, x2, x3;

            pilha.inserir(100);
            pilha.inserir(101);
            pilha.inserir(200);
            pilha.inserir(330);
            pilha.inserir(45);
            pilha.inserir(50);
            pilha.inserir(100);

            int x10 = pilha.getMin();
            System.out.println(" Menor elemento atual:" + x10);

            System.out.print("Apos insercoes: ");
            pilha.mostrar();

            x1 = pilha.remover();
            x2 = pilha.remover();
            int x11 = pilha.getMin();
            System.out.println(" Menor elemento atual:" + x11);

            x3 = pilha.remover();

            System.out.print("Apos as remocoes (" + x1 + "," + x2 + "," + x3 + "): ");
            pilha.mostrar();
            int x12 = pilha.getMin();
            System.out.println(" Menor elemento atual:" + x12);

            pilha.inserir(10);
            pilha.inserir(45);
            pilha.inserir(50);
            pilha.inserir(20);

            int x13 = pilha.getMin();
            System.out.println(" Menor elemento atual:" + x13);

        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }
    }
}
