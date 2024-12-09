/**
 * Questão das Letras
 * @author Pedro Hosken - 816561
 * @version 1.0 - 09/12/2024
 */

// ---- Dependencias ---- //
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/**
 * Metódo Hs
 *
 * Objetivo: realizar a transformaçãod aquela String
 *
 * Como: função de transformação de cada caractere, vamos somar o hs da linha inteira e retornar daquela linha
 *
 * @param char* palavra
 * @param int pos
 * @return int hs
 *
 * @var char i - caractere acessado
 * @var int aux - auxiliar na conversão
 * @var int hs
 * @var int tm - tamanho da string
 *
 */

int hash(char *palavra, int pos)
{
    // definir dados
    char i = 'a';
    int aux = 0;
    int hs = 0;
    int tm = strlen(palavra);
    // transformação de cada caractere, iterativamente
    for (int i = 0; i < tm; i++)
    {
        // posição dele no alfabeto, elemento de entrada, sua posição local
        aux = palavra[i] - 'A'; // ASCII
        hs += aux + pos + i;
        printf("Aux = %i\n", aux);
        printf("pOS = %i\n", pos);
        printf("i = %i\n", i);
        printf("Hs atual = %i\n", hs);
        printf("\n");
    }
    // retornar
    return (hs);
}

/**
 * Metódo Main
 *
 * Objetivo: ler a quantidade de casos teste,
 * ler a quantidade de linhas de cada caso tetse, ler as linhas de cada caso,
 * chamar o hash para cada caso, printar o valor retornado do hash.
 *
 * Como: vamos ler dentro da main e chamar a função de hash para aquelas linhas daquele caso de teste
 *
 * @var int N - quantidade de casos de teste
 * @var int L - quantidade de linhas de cada caso 1 a 100
 * @var int tM - tamanho máxiomo de caracteres 50
 * @var int hs - valor que vai para hash e será printado
 * @var char* palavra
 * @var int pos - posição  geral
 * @var int el - posição local
 *
 * Passos =
 * 1. ler a quantidade de casos teste - OK
 * 2. iterativamente ler a quantidade de linhas de cada caso - OK
 * 3. iterativamente ler cada linha - OK
 * 4. ler cada palavra - OK
 * 5. chamar a função para aquela palavra
 *
 */

int main()
{
    // definir dados
    int n = 0;
    int l = 0;
    int tm = 50;
    int pos = 0;
    char palavra[tm];
    // ler a quantidade de casos de teste
    scanf("%i", &n);
    getchar();
    // iterativamente ler a quantidade de linhas de cada caso
    for (int i = 0; i < n; i++)
    {
        int hs = 0;      // definir ele dentro da função
        scanf("%i", &l); // quantidade de linhas daquele caso
        getchar();
        for (int x = 0; x < l; x++) // ler cada palavra de cada linha
        {
            scanf("%s", palavra);
            getchar();
            // printf("%s\n", palavra);
            hs += hash(palavra, pos); // chama a função que retorna o valor da hash
            pos = pos + 1;            // atualiza o valor do elemento local
        }
        printf("%i\n", hs); // imprime o valor daquela sequencia de linahas
        printf("\n");
    }
}

/**
 * TESTES
 * printf("%i\n", n);
 */