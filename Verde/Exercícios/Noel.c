/**
 * Questão Lista do papai noel em c
 * @author Pedro Hosken
 * @version 1 16/09/2024
 */

//------- Dependencias--------//
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

/**
 * Struct do Tipo Lista de Crianças
 * @var char* listaCriancas[] - lista de crianças
 * @var int boazinhas - contador de crianças boazinhas
 * @var int malvadas - contador de crianças malvadas
 * @var int total - número total de crianças na lista
 */
typedef struct Noel
{
    int malvadas;         // Contador de crianças malvadas
    int boazinhas;        // Contador de crianças boazinhas
    char **listaCriancas; // Lista de nomes das crianças
    int total;            // Contador do número total de crianças na lista
} Criancas;

/**
 * Metódo de ordenação de Crianças por ordem alfabética
 * @param char** listaCrianca[]
 * @param int N total de crianças
 * @return void
 */

void ord(Criancas *crianca, int tot)
{
    // metódo de ordenação seleção
    for (int i = 1; i < tot; i++)
    {
        char *tmp = crianca->listaCriancas[i];
        int j = i - 1;
        while ((j >= 0) && (strcmp(crianca->listaCriancas[j], tmp) > 0))
        {
            crianca->listaCriancas[j + 1] = crianca->listaCriancas[j];
            j--;
        }
        crianca->listaCriancas[j + 1] = tmp;
    }
}

/**
 * Metódo Main
 * Le inteiro N e faz alocação dinamica por construtor
 * Le char + ou -  e atualiza variaveis m e b
 * Le nome da criança e guarda na lista alocada dinamicamente
 * Chama função de ordenar por ordem alfabética
 * Printa lista e printa variaveis
 */

int main()
{
    // definir dados
    int N = 0;
    Criancas crianca;
    crianca.boazinhas = 0;
    crianca.malvadas = 0;
    char nome[20] = "";
    char comportamento = '0';
    // inicializar váriaveis e alocação dinâmica da lista
    scanf("%i", &N);
    getchar();
    crianca.listaCriancas = (char **)malloc(N * sizeof(char *));
    // teste se lista foi alocada corretamente
    if (crianca.listaCriancas == NULL)
    {
        printf("Erro na alocacao\n");
    }
    for (int i = 0; i < N; i++)
    {
        crianca.listaCriancas[i] = (char *)malloc(20 * sizeof(char)); // Aloca memória para cada nome de criança
        // teste se lista de nomes esta alocada
        if (crianca.listaCriancas[i] == NULL)
        {
            printf("Erro na alocacao2\n");
        }
    }
    // ler nome das crianças até N e guardar na lista
    for (int i = 0; i < N; i = i + 1)
    {
        scanf("%c", &comportamento);
        getchar();
        scanf("%s", nome);
        getchar();
        // printf("%c / %s\n", comportamento, nome);
        // atualiza comportamento
        if (comportamento == '+')
        {
            crianca.boazinhas = crianca.boazinhas + 1;
        }
        else
        {
            crianca.malvadas = crianca.malvadas + 1;
        }
        // salva nome na lista
        strcpy(crianca.listaCriancas[i], nome);
        printf("%i / %i / %s\n", crianca.malvadas, crianca.boazinhas, crianca.listaCriancas[i]);
    }
    // realizar a ordenação da lista
    ord(&crianca, N);
    // printar lista
    for (int x = 0; x < N; x++)
    {
        printf("%i / %i / %s\n", crianca.malvadas, crianca.boazinhas, crianca.listaCriancas[x]);
    }
    // return
    return 0;
}
