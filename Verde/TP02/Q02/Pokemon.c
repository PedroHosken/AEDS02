/**
 * Estrutura Pokemon
 * @author Pedro Hosken Fernandes Guimarães - 816561
 * @version 1 - 30/09/2024
 */

//--------Dependencias----------//
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

/**
 * Struct Pokemon
 * Estrtura com atributos para váriavel Pokemon
 *
 *  Sua Struct tera os atributos privado id (int),
 * generation (int), name (String), description (String), types (Lista)1
 * , abilities (Lista),
 * weight (double), height (double), captureRate (int), isLegendary (boolean),
 * captureDate
 * (Date)
 */

typedef struct
{
    int id;
    int generation;
    char name[50];
    char description[50];
    char type1[50];
    char type2[50];
    char **abilities;
    int abilitiesCount;
    double weight;
    double height;
    int captureRate;
    bool isLegendary;
    char captureDate[11];
} Pokemon;

/**
 * Construtor1 do Pokemon
 * Objetivo: construir um Pokemon sem parametros
 *
 * @var Pokemon* novo
 *
 * @return Pokemon
 *
 * @version 1 - Criar Pokemon e inicializar vaaria´veis com valores padrões
 */

Pokemon *c1()
{
    // definir dados
    Pokemon *p = (Pokemon *)malloc(sizeof(Pokemon));
    // teste se tudo deu certo
    if (p == NULL)
    {
        printf("Erro ao alocar memória para o Pokémon.\n");
        exit(1);
    }
    // inicializar atributos com valores padrões
    p->id = 0;
    p->generation = 0;
    strcpy(p->name, "");
    strcpy(p->description, "");
    strcpy(p->type1, "");
    strcpy(p->type2, "");
    p->abilities = NULL;
    p->abilitiesCount = 0;
    p->weight = 0.0;
    p->height = 0.0;
    p->captureRate = 0;
    p->isLegendary = false;
    time_t t = time(NULL);
    strcpy(p->captureDate, "0/0/0"); // Copiar a data como string
    // retornar
    return p;
}

/**
 * Construtor2 do Pokemon
 * Objetivo: construir um Pokemon com parametros
 *
 * @param int id
 * @param int generation
 * @param char[] name
 * @param char[] description
 * @param char[] type1
 * @param char[] type2
 * @param char** abilities
 * @param int abilitiesCount
 * @param double weight
 * @param double height
 * @param int captureRate
 * @param double isLegendary
 * @param char[] captureDate
 *
 * @var Pokemon* novo
 *
 * @return Pokemon
 *
 * @version 1 - Criar variável e depois preencher valores com parametros
 */
Pokemon *c2(int id, int generation, const char *name, const char *description, const char *type1,
            const char *type2, char **abilities, int abilitiesCount, double weight, double height,
            int captureRate, bool isLegendary, const char *captureDate)
{
    // definir dados
    Pokemon *p = (Pokemon *)malloc(sizeof(Pokemon));
    // teste se foi alocado
    if (p == NULL)
    {
        printf("Erro ao alocar memória para o Pokémon.\n");
        exit(1);
    }
    // inicializar atributos com valores dos parametros
    p->id = id;
    p->generation = generation;
    strcpy(p->name, name);
    strcpy(p->description, description);
    strcpy(p->type1, type1);
    if (type2 != NULL)
    {
        strcpy(p->type2, type2);
    }

    // Copiar lista de habilidades por meio da variável de controle
    p->abilitiesCount = abilitiesCount;
    p->abilities = (char **)malloc(abilitiesCount * sizeof(char *));
    for (int i = 0; i < abilitiesCount; i++)
    {
        p->abilities[i] = (char *)malloc((strlen(abilities[i]) + 1) * sizeof(char));
        strcpy(p->abilities[i], abilities[i]);
    }

    p->weight = weight;
    p->height = height;
    p->captureRate = captureRate;
    p->isLegendary = isLegendary;
    strcpy(p->captureDate, captureDate);
    // retornar
    return p;
}
/**
 * Free Pokemon
 * Objetivo: Metódo para liberar memória alocada
 *
 * @param Pokemon *p
 *
 */

void freePokemon(Pokemon *p)
{
    if (p != NULL)
    {
        for (int i = 0; i < p->abilitiesCount; i++)
        {
            free(p->abilities[i]);
        }
        free(p->abilities);
        free(p);
    }
}

/**
 * Printar pokemon
 * Objetivo: printar o atributos do Pokemon lido do arquivo Csv
 *
 * @param Pokemon *p
 */

void printPokemon(Pokemon *p)
{
    printf("Entrei");
    printf("[#%d -> %s: %s - ['%s'", p->id, p->name, p->description, p->type1);
    if (strlen(p->type2) > 0)
    {
        printf(", '%s']", p->type2);
    }
    else
    {
        printf("']");
    }
    printf(" - [");
    for (int i = 0; i < p->abilitiesCount; i++)
    {
        printf("'%s'", p->abilities[i]);
        if (i < p->abilitiesCount - 1)
        {
            printf(", ");
        }
    }
    printf("] - %.2fkg - %.2fm - %d%% - %s - %d gen] - %s",
           p->weight, p->height, p->captureRate,
           p->isLegendary ? "true" : "false", p->generation, p->captureDate);
}

// Função para processar habilidades
char **processAbilities(char *abilitiesRaw, int *abilitiesCount)
{
    abilitiesRaw++;                                // Remover o primeiro colchete
    abilitiesRaw[strlen(abilitiesRaw) - 1] = '\0'; // Remover o último colchete

    char *token = strtok(abilitiesRaw, ", ");
    char **abilities = (char **)malloc(5 * sizeof(char *)); // Supondo até 5 habilidades
    *abilitiesCount = 0;

    while (token != NULL)
    {
        abilities[*abilitiesCount] = (char *)malloc((strlen(token) + 1) * sizeof(char));
        strcpy(abilities[*abilitiesCount], token);
        (*abilitiesCount)++;
        token = strtok(NULL, ", ");
    }

    return abilities;
}

// Função para ler um Pokémon de um arquivo CSV (readPokemonFromCSV)// Função para ler um Pokémon de um arquivo CSV (readPokemonFromCSV)
Pokemon *readPokemonFromCSV(int id)
{
    printf("Entrou no método readPokemonFromCSV\n");

    FILE *file = fopen("pokemon.csv", "r");
    if (file == NULL)
    {
        printf("Erro ao abrir o arquivo CSV.\n");
        return NULL;
    }

    char line[512]; // Aumentei o buffer para garantir que as linhas maiores sejam capturadas
    bool found = false;
    Pokemon *p = NULL;

    // Ignorar a primeira linha (cabeçalho)
    fgets(line, sizeof(line), file);

    while (fgets(line, sizeof(line), file))
    {
        char *token;
        printf("Linha lida: %s\n", line); // Debug para ver a linha sendo lida

        token = strtok(line, ",");
        if (token == NULL)
        {
            printf("Erro: token é NULL após strtok\n");
            continue; // Pula para a próxima linha se não encontrar um token
        }

        int currentId = atoi(token); // Primeira coluna é o ID
        if (currentId == id)
        {
            found = true;
            printf("ID encontrado: %d\n", currentId);

            int generation = atoi(strtok(NULL, ","));
            char *name = strtok(NULL, ",");
            char *description = strtok(NULL, ",");
            char *type1 = strtok(NULL, ",");
            char *type2 = strtok(NULL, ",");

            if (type2 != NULL && strcmp(type2, "") == 0)
            {
                type2 = NULL; // Se o type2 for uma string vazia
            }

            // Leitura correta das habilidades que estão entre aspas e colchetes
            char *abilitiesRaw = strtok(NULL, "\"");
            if (abilitiesRaw == NULL)
            {
                printf("Erro ao processar habilidades\n");
                continue; // Pula para a próxima linha se não encontrar habilidades
            }

            int abilitiesCount = 0;
            char **abilities = processAbilities(abilitiesRaw, &abilitiesCount);

            double weight = atof(strtok(NULL, ","));
            double height = atof(strtok(NULL, ","));
            int captureRate = atoi(strtok(NULL, ","));
            bool isLegendary = atoi(strtok(NULL, ",")) == 1;

            // Lendo a data corretamente, sem depender do strtok
            char *captureDate = strtok(NULL, "\n"); // Captura a data até o fim da linha

            if (captureDate == NULL)
            {
                printf("Erro ao processar data\n");
                continue; // Pula para a próxima linha se não encontrar a data
            }

            // Criar o Pokémon
            p = c2(currentId, generation, name, description, type1, type2, abilities, abilitiesCount,
                   weight, height, captureRate, isLegendary, captureDate);
        }
    }

    fclose(file);

    if (!found)
    {
        printf("Pokémon com ID %d não encontrado.\n", id);
    }

    return p;
}

// Função principal (main)
int main()
{
    int id;
    printf("Digite o ID do Pokémon: ");
    scanf("%d", &id);

    Pokemon *p = readPokemonFromCSV(id);
    if (p != NULL)
    {
        printPokemon(p);
        freePokemon(p);
    }
    else
    {
        printf("p é vazio");
    }

    return 0;
}