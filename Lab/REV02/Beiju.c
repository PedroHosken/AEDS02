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
 *
 * @version 1 - testar dados definidos, leitura da linha ext e seu print - OK
 * @version 2 - buscar por parenteses e formar linha interna, percorrer
 * iterativamente
 *
 */

int main()
{
    // definir dados
    char ext[MAX];
    char inte[MAX - 2]; // abre e fecha []
    int tam = 0;
    // ler externa
    scanf("%s", ext);
    getchar();
    // buscar beiju
    tam = strlen(ext);
    for (int i = 0; i < tam; i++)
    {
        if (ext[i] == '[') // achou Beiju
        {
            int x = i + 1; // atualiza i
            // formar linha interna
            while (ext[x] != ']')
            {
                // testes de casos especiais
                if (ext[x] != '[' && ext[x] != ']')
                {
                    
                }
            }
        }
    }

    // return
    return 0;
}

/**
 * TESTES
 * @version 1 -
 * printf("%s\n", ext);
 *
 */