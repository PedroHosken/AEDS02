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
 * Metódo compare
 * Objetivo: comparar o array ideal com a sequencia, e retornar numero de mov min
 * Como: passar ambos arrays como referencia, comparar cada posição do array, de forma iterativa,
 * caso diferente atualizar variavel dif, retornar por fim dif/2
 *
 * @var int dif = 0;
 *
 * @param int *sq - array sequencial
 * @param int *id - array ideal
 * @param int n - tamanho do array
 *
 * @return int dif/2
 */

int compare(int s, int *sq, int *id)
{
    // definir dados
    int dif = 0;
    // percorrer array e comparar posição por posição
    for (int i = 0; i < s; i++)
    {
        if (sq[i] != id[i])
        {
            dif = dif + 1;
        }
    }
    // return
    return (dif / 2);
}

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
        // chamar metódo de comparação entre arrays
        mov = compare(s, sq, id);
        printf("%i\n", mov);
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