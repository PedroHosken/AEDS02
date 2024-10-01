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
    sscanf(dateStr, "%d/%d/%d", &date->tm_mday, &date->tm_mon, &date->tm_year);
    date->tm_mon -= 1;     // Meses em struct tm são de 0 a 11
    date->tm_year -= 1900; // Ano em struct tm é o número de anos desde 1900
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
    // definir dados
    Pokemon *p = (Pokemon *)malloc(sizeof(Pokemon));
    // teste se foi alocado
    if (p == NULL)
    {
        printf("Erro ao alocar memória para o Pokémon.\n");
    }
    else
    {
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

        // Inicializar o array de habilidades
        p->abilitiesCount = abilitiesCount;
        for (int i = 0; i < abilitiesCount && i < MAX_ABILITIES; i++)
        {
            strcpy(p->abilities[i], abilities[i]);
        }

        p->weight = weight;
        p->height = height;
        p->captureRate = captureRate;
        p->isLegendary = isLegendary;
        // Usar a função alternativa para fazer parsing da data
        parseDate(captureDateStr, &p->captureDate);
    }
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
    // imprimir
    printf("[#%i -> %s: %s - ['%s'", p->id, p->name, p->description, p->type1);
    // testar type2
    if (strcmp(p->type2, "") != 0)
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
    // restante
    printf("] - %.2fkg - %.2fm - %d%% - %s - %d gen] - %02d/%02d/%04d\n",
           p->weight, p->height, p->captureRate, p->isLegendary ? "true" : "false", p->generation,
           p->captureDate.tm_mday, p->captureDate.tm_mon + 1, p->captureDate.tm_year + 1900);
}

/**
 * Metódo Ler
 * Objetivo: ler arquivo csv e construir Pokemon
 * @param int id do pokemon a ser lido
 * @param char[] path
 * @return Pokemon p
 *
 * @var Pokemon p // construtor
 * @var FILE arquivo csv // onde vamos ler os atributos
 * @var char[MAX_STRING] linha // linha do arquivo ccsv
 * @var bool found // variavel de controle para quando achar
 * @var int pesq // id pesquisado
 * @var char* campo // separar a linha em campos e salvar
 * @var char *atributos // organizar os campos
 */

Pokemon *ler(int id, const char *path)
{
    // definir dados
    Pokemon *p = c1(); // construtor padrão de pokemon
    bool found = false;
    char linha[MAX_STRING];         // linha
    char linha2[MAX_STRING];        // corrigir uso de linha no while
    FILE *file = fopen(path, "rt"); // arquivo definido
    int pesq = 0;
    // teste para verificar se arquivo está nulo
    if (file == NULL)
    {
        printf("Erro ao abrir arquivo, confira o path");
    }
    else
    {
        printf("Tudo certo\n");
    }
    // ler cabeçalho do arquivo
    fgets(linha, sizeof(linha), file);
    // ler arquivo csv enquanto não encontrar o id
    while (fgets(linha, sizeof(linha), file) != NULL && !found)
    {
        // separar os campos do arquivo CSV
        char *campo = strtok(linha, ","); // Pega o primeiro campo (ID)
        pesq = atoi(campo);               // converte o primeiro campo (id) para inteiro

        // comparando o ID atual com o ID que estamos procurando
        if (pesq == id)
        {
            found = true;
            strcpy(linha2, linha);
        }

        /* TESTE DE LINHA OK
        fgets(linha, sizeof(linha), file); // lê a linha
        printf("%s\n", linha);             // teste para ver se linha está correta
        // teste se esse é o id que estamos pesquisando
        if (pesq == id)
        {
            found = true;
        }
        pesq = pesq + 1;
        */
    }
    // printf("%s\n", linha2); - OK
    if (found)
    {
        // ID encontrado, separar os demais campos
        p->id = pesq;                    // passar o id
        char *campo = strtok(NULL, ","); // ler generation
        p->generation = atoi(campo);

        campo = strtok(NULL, ","); // ler name
        strcpy(p->name, campo);

        campo = strtok(NULL, ","); // ler description
        strcpy(p->description, campo);

        campo = strtok(NULL, ","); // ler type1
        strcpy(p->type1, campo);

        campo = strtok(NULL, ","); // ler type2 (campo pode ser vazio)
        if (strcmp(campo, "") == 0)
        {
            strcpy(p->type2, "");
        }
        else
        {
            strcpy(p->type2, campo);
        }

        // Processar abilities (remover colchetes e separar por vírgula)
        campo = strtok(NULL, ",");
        strcpy(campo, strtok(campo, "[]")); // remover colchetes
        char *ability = strtok(campo, "' ,");
        int abilityIndex = 0;
        while (ability != NULL && abilityIndex < MAX_ABILITIES)
        {
            strcpy(p->abilities[abilityIndex++], ability);
            ability = strtok(NULL, "' ,");
        }
        p->abilitiesCount = abilityIndex;

        campo = strtok(NULL, ","); // ler weight
        p->weight = atof(campo);

        campo = strtok(NULL, ","); // ler height
        p->height = atof(campo);

        campo = strtok(NULL, ","); // ler captureRate
        p->captureRate = atoi(campo);

        campo = strtok(NULL, ","); // ler isLegendary
        p->isLegendary = atoi(campo) == 1;

        campo = strtok(NULL, ",");         // ler captureDate
        parseDate(campo, &p->captureDate); // tratar a data
    }
    else
    {
        printf("Pokémon com ID %d não encontrado.\n", p->id);
    }

    /* TESTE DE CAMPOS OK
    while (campo != NULL)
    {
        printf("Campo: %s\n", campo); // Exibir o campo
        campo = strtok(NULL, ",");    // Continuar para o próximo campo
    }
    */

    // fechar arquivo
    fclose(file);
    // retornar pokemon
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