/**
 * Elementary My Dear Watson
 * @author Pedro Hosken - 816561
 * @version 1 - 04/11/2024
 */

// ---- Dependências ---- //
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

/**
 * Metódo Main
 * Objetivo: Ler linha de comparações, ler inteiro de sequencia,ler sequencia, printar o mínimo de swaps
 * Como: scanf para n cmp, guardar em váriavel, fazer repetição iterativa, scanf de sequencia, comparar com seuquencia ideal, dar o resultado
 *
 * @var int comp -  numero de comparações
 * @var int s - tamanho do array
 * @var int sq[s] - sequencia
 * @var int id[s] - ideal
 * @var int nm - numero inserido
 * @var int mov - numero de movimentações
 *
 * @version 1 - ler número de comp e fazer repetição iterativa - OK
 * @version 2 - chamar metodo de comparação entre arrays e retornar resposta - 
 */

int main()
{
    // definir dados
    int comp = 0;
    int s = 0;
    int mov = 0;
    int nm = 0;
    // ler numero de comparações
    scanf("%i", &comp);
    getchar();
    // repetição iterativa
    for (int x = 0; x < comp; x++)
    {
        // ler total da sequencia
        scanf("%i", &s);
        getchar();
        // gerar iterativamente o array
        int sq[s]; // normal
        int id[s]; // ideal
        for (int i = 1; i <= s; i++)
        {
            id[i] = i;
            scanf("%i", &nm);
            getchar();
            sq[i] = nm;
        }
    }
}
/**
 * TESTES
 * @version 1 -
 * printf("%i - %i\n", comp, s);
 * for (int i = 1; i <= s; i++)
        {
            printf("%i - %i\n", sq[i], id[i]);
        }
 *
 */