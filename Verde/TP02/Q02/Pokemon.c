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
#include <wchar.h>
#include <locale.h>

//---------Variáveis Globais----------//
#define MAX_ABILITIES 10 // Máximo de habilidades que um Pokémon pode ter
#define MAX_STRING 100   // Tamanho máximo das strings

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
    char name[MAX_STRING];
    char description[MAX_STRING];
    char type1[MAX_STRING];
    char type2[MAX_STRING];
    char abilities[MAX_STRING][MAX_ABILITIES];
    int abilitiesCount;
    double weight;
    double height;
    int captureRate;
    bool isLegendary;
    struct tm captureDate; // Usaremos `struct tm` para representar a data
} Pokemon;

/**
 * Função para fazer parsing de uma data no formato "dd/MM/yyyy"
 */
void parseDate(const char *dateStr, struct tm *date)
{
    printf("dentro da data\n");
    printf("Data recebida: '%s'\n", dateStr);

    int parsed = sscanf(dateStr, "%d/%d/%d", &date->tm_mday, &date->tm_mon, &date->tm_year);
    if (parsed == 3)
    {
        date->tm_mon -= 1;     // Meses em struct tm são de 0 a 11
        date->tm_year -= 1900; // Ano em struct tm é o número de anos desde 1900
    }
    else
    {
        printf("Erro ao interpretar a data: %s\n", dateStr);
    }
}

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
    // Inicializar o array de habilidades vazio
    for (int i = 0; i < MAX_ABILITIES; i++)
    {
        strcpy(p->abilities[i], ""); // Strings vazias para habilidades
    }
    p->abilitiesCount = 0; // Contador de habilidades
    p->weight = 0.0;
    p->height = 0.0;
    p->captureRate = 0;
    p->isLegendary = false;
    // Inicializar a data de captura com a data atual
    time_t t = time(NULL);
    p->captureDate = *localtime(&t); // Obter a data e hora atuais

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
 * @param Struct tm captureDate
 *
 * @var Pokemon* novo
 *
 * @return Pokemon
 *
 * @version 1 - Criar variável e depois preencher valores com parametros
 */
Pokemon *c2(int id, int generation, const char *name, const char *description, const char *type1,
            const char *type2, char **abilities, int abilitiesCount, double weight, double height,
            int captureRate, bool isLegendary, const char *captureDateStr)
{
    // Alocar o Pokémon
    Pokemon *p = (Pokemon *)malloc(sizeof(Pokemon));
    if (p == NULL)
    {
        printf("Erro ao alocar memória para o Pokémon.\n");
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
 * Metódo de imprimir Pokemon
 * Objetivo: Imprimir os atributos de determinado pokemon
 *  [#181 -> Ampharos: Light Pokémon - ['electric'] - ['Static', 'Plus'] - 61.5kg
 * - 1.4m - 45% - false - 2 gen] - 25/05/1999
 *
 */

void imprimir(Pokemon *p)
{
    printf("Entrei");
    printf("[#%d -> %s: %s - ['%s'", p->id, p->name, p->description, p->type1);
    if (strlen(p->type2) > 0)
    {
        printf(", '%s']", p->type2);
    }
    else
    {
        printf("]");
    }
    // continuando
    printf(" - [");
    // printando abilities
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
        printf("Erro ao abrir arquivo, confira o path.\n");
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
            printf("Entrou\n");
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

/**
 * Função main
 * @version 1 testar metódos de construtor, imprimir e de free
 * @version 2 testar metódo de ler arquivo e imprimir Pokemon
 */
int main()
{
    // definir dados
    setlocale(LC_ALL, "UTF-8"); // setCharset
    // testar metódo de leitura
    Pokemon *p = ler(4, "pokemon.csv");
    imprimir(p);
    // retornar
    return 0;
}

/**
 * TESTES
 *
 * @version 1 - Teste de construtores e imprimir - UTF ERRADO
 * // definir dados
    setlocale(LC_ALL, "UTF-8"); // setCharset
    char *abilities[] = {"Static", "Plus"};
    // Criar um Pokémon usando o construtor com parâmetros
    Pokemon *p = c2(181, 2, "Ampharos", "Light Pokémon", "electric", "",
                    abilities, 2, 61.5, 1.4, 45, false, "25/05/1999");

    // Imprimir os atributos do Pokémon
    imprimir(p);

    // Liberar a memória alocada
    freePokemon(p);

    // retornar
    return 0;
 *
 */