/**
 * Questão do Beiju
 * @author Pedro Hosken - 816561
 * @version 1 - 04/11/2024
 *
 */

// ---- Dependências ---- //
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

// ---- Global ---- //
#define MAX 100000

/**
 * Metódo Main
 * Objetivo: ler do teclado o texto, identificar a ocorrencia do [],
 * organizar a String a partir disso, printar na tela o resultado
 *
 * Como: instanciar string, ler a linha, percorrer até encontrar [,
 * ter outra String que salve texto interno, até encontrar ], printar na tela:
 * interior, depois restante. Na parte onde havia Beiju, subs por _
 *
 * @var char *ext - linha toda
 * @var char *inte - linha interna / Beiju
 * @var int tam - tamanho total da string
 * @var int i - controle
 * @var int x - controle
 * @var int b - inicio de beiju na string ext
 * @var int tam2 - tamanho da inte
 *
 * @version 1 - testar dados definidos, leitura da linha ext e seu print - OK
 * @version 2 - buscar por parenteses e formar linha interna, percorrer
 * iterativamente e printar - OK
 * @version 3 - retirar beiju e colocar _ - OK
 * @version 4 - desclocar biju para o inicio do array e printar,
 * respeitar casos especiais - OK
 *
 *
 */

int main()
{
    // definir dados
    char ext[MAX];
    char inte[MAX - 2]; // abre e fecha []
    int tam = 0;
    int b = 0;
    int tam2 = 0;
    // ler externa
    scanf("%s", ext);
    getchar();
    // buscar beiju
    tam = strlen(ext);
    for (int i = 0; i < tam; i++)
    {
        if (ext[i] == '[') // achou Beiju
        {
            b = i;         // atualiza inicio de beiju
            int x = i + 1; // atualiza i
            // formar linha interna
            while (ext[x] != ']')
            {
                // testes de casos especiais
                if (ext[x] != '[' && ext[x] != ']')
                {
                    strncat(inte, &ext[x], 1); // forma linha interna
                }
                x = x + 1; // anda com x
            }
        }
    }
    if (inte != NULL && inte[0] != '\0')
    {
        // substituir parte de beiju por _ na original e deslcoar
        tam2 = strlen(inte);
        ext[b] = '_'; // substitui por _
        // Deslocar o restante da string para a esquerda até ']'
        for (int i = b + 1; i <= tam - tam2 + 1; i++)
        {
            ext[i] = ext[i + tam2 + 1]; // corrigido e atualizado
        }
        printf("%s%s\n", inte, ext); // printa na nova ordem
    }
    else
    {
        tam2 = strlen(inte);
        // Deslocar o restante da string para a esquerda até ']'
        for (int i = b; i <= tam - tam2 + 1; i++)
        {
            ext[i] = ext[i + tam2 + 2]; // corrigido e atualizado
        }
        if (strcmp(ext, "[]") == 0)
        {
            
        }
        else
        {
            printf("%s\n", ext); // printa apenas ext
        }
    }

    // return
    return 0;
}

/**
 * TESTES
 * @version 1 -
 * printf("%s\n", ext);
 * @version 2 -
 * printf("%s - %s\n", inte, ext);
 *
 */