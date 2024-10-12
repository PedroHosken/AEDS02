/**
 * Estrutura Pokemon
 * @author Pedro Hosken Fernandes Guimarães - 816561
 * @version 1 - 30/09/2024
 * @version 2 - 12/10/2024
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
#define MAX_STRING 50    // Tamanho máximo das strings
#define MAX_LINHA 100    // Tamanho máximo das strings

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
    char captureDate[MAX_STRING];
} Pokemon;

// Função para inicializar `setlocale`
void iniciarLocale()
{
    setlocale(LC_CTYPE, "pt_BR.UTF-8");
}

/**
 * Construtor1 do Pokemon
 * Objetivo: construir um Pokemon sem parametros
 *
 * @var Pokemon* novo
 *
 * @return Pokemon
 *
 * @version 1 - Criar Pokemon e inicializar variáveis com valores padrões
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
    strcpy(p->captureDate, "29/01/2004");
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
 * @param bool isLegendary
 * @param char[] captureDate
 *
 * @var Pokemon* novo
 *
 * @return Pokemon
 */
Pokemon *c2(int id, int generation, const char *name, const char *description, const char *type1,
            const char *type2, char **abilities, int abilitiesCount, double weight, double height,
            int captureRate, bool isLegendary, const char *captureDate)
{
    printf("Entrei C2\n");
    // Alocar o Pokémon
    Pokemon *p = (Pokemon *)malloc(sizeof(Pokemon));
    if (p == NULL)
    {
        printf("Erro ao alocar memória para o Pokémon.\n");
        return NULL;
    }

    // Inicializar atributos com valores dos parâmetros
    p->id = id;
    p->generation = generation;
    strncpy(p->name, name, MAX_STRING - 1);
    p->name[MAX_STRING - 1] = '\0'; // Garantir a terminação da string
    strncpy(p->description, description, MAX_STRING - 1);
    p->description[MAX_STRING - 1] = '\0';
    strncpy(p->type1, type1, MAX_STRING - 1);
    p->type1[MAX_STRING - 1] = '\0';
    if (type2 != NULL)
    {
        strncpy(p->type2, type2, MAX_STRING - 1);
        p->type2[MAX_STRING - 1] = '\0';
    }
    else
    {
        strcpy(p->type2, "");
    }

    // Inicializar habilidades
    p->abilitiesCount = abilitiesCount;
    for (int i = 0; i < abilitiesCount && i < MAX_ABILITIES; i++)
    {
        strncpy(p->abilities[i], abilities[i], MAX_STRING - 1);
        p->abilities[i][MAX_STRING - 1] = '\0'; // Garantir terminação de string
    }

    // Inicializar demais atributos
    p->weight = weight;
    p->height = height;
    p->captureRate = captureRate;
    p->isLegendary = isLegendary;

    // Armazenar a data de captura como string
    strncpy(p->captureDate, captureDate, MAX_STRING - 1);
    p->captureDate[MAX_STRING - 1] = '\0';

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
    printf("Entrei Free\n");
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
    printf("Entrei Imprimir\n");
    printf("[#%d -> %s: %s - ['%s'", p->id, p->name, p->description, p->type1);
    if (strlen(p->type2) > 0)
    {
        printf(", '%s']", p->type2);
    }
    else
    {
        printf("]");
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
    printf("] - %.2fkg - %.2fm - %d%% - %s - %d gen] - %s\n",
           p->weight, p->height, p->captureRate,
           p->isLegendary ? "true" : "false", p->generation, p->captureDate);
}

/**
 * Metódo de ler do arquivo CSV
 * Objetivo: ler atributos do arquivo csv e montar pokemon
 * Como: ler cada linha do arquivo, separar alinha por vírgulas, guardar os atributos e chamar construtor passando parametros,
 * tomando cuidado com abilities e data
 *
 * @param int id - montar pokemon daquele Id
 * @param char* file - caminho do arquivo
 * @return Pokemon* novo - retorna novo pokemon
 *
 * @var FILE file -  arquivo para lermos o CSV
 * @var Pokemon* p - novo pokemon a ser construído
 * @var char[] linha - para ler cada linha do arquivo CSV
 * @var bool found - verifica se o id pesquisado já foi encontrado
 */

Pokemon *ler(char *filename, char* id)
{

    // definir dados
    Pokemon *p = NULL;
    FILE *file = fopen(filename, "rt");
    char linha[MAX_LINHA];
    bool found = false;
    int Id = atoi(id);

    // teste de arquivo
    if (file == NULL)
    {
        printf("Erro ao abrir arquivo\n");
        return NULL;
    }

    // ler cabeçalho
    fgets(linha, sizeof(linha), file);

    // Lê as demais linhas do arquivo
    while (fgets(linha, sizeof(linha), file) != NULL && !found)
    {
        char *token = strtok(linha, ","); // separa a linha por vírgulas
        char *atributos[12];              // array de ponteiros para atributos
        int index = 0;

        // alocar espaço para cada atributo
        while (token != NULL)
        {
            atributos[index++] = strdup(token);
            token = strtok(NULL, ",");
        }

        // Verificar id
        if (atoi(atributos[0]) == Id)
        {
            found = true; // atualizar para parar repetição

            // construir pokemon com os atributos
            int Id = atoi(atributos[0]);
            int Generation = atoi(atributos[1]);
            char Name[MAX_STRING];
            char Description[MAX_STRING];
            char Type1[MAX_STRING];
            strcpy(Name, atributos[2]);
            strcpy(Description, atributos[3]);
            strcpy(Type1, atributos[4]);

            // Verificar se Type2 está vazio
            char Type2[MAX_STRING];
            if (strlen(atributos[5]) == 0)
            {
                strcpy(Type2, "");
            }
            else
            {
                strcpy(Type2, atributos[5]);
            }

            // Array temporário para armazenar habilidades formatadas
            char temp[MAX_STRING] = {0};
            int pos = 0;
            int len = strlen(atributos[6]);

            // Pré-processamento: remover colchetes e aspas simples
            for (int x = 0; x < len; x++)
            {
                if (atributos[6][x] == '[' || atributos[6][x] == ']')
                {
                    continue; // Ignorar colchetes
                }
                else if (atributos[6][x] == '\'')
                {
                    continue; // Ignorar aspas simples
                }
                else
                {
                    temp[pos++] = atributos[6][x]; // Copiar caractere para temp
                }
            }
            temp[pos] = '\0'; // Finalizar string

            // Separar habilidades usando ',' como delimitador
            char *tempAbilities[MAX_ABILITIES];
            int abilityIndex = 0;
            char *abilityToken = strtok(temp, ", ");
            while (abilityToken != NULL && abilityIndex < MAX_ABILITIES)
            {
                tempAbilities[abilityIndex++] = strdup(abilityToken); // Alocar e copiar habilidade
                abilityToken = strtok(NULL, ", ");
            }

            double Weight = atof(atributos[7]);
            double Height = atof(atributos[8]);
            int Capturerate = atoi(atributos[9]);
            bool Islegendary = strcmp(atributos[10], "true") == 0 ? true : false;
            char CaptureDate[MAX_STRING];
            strcpy(CaptureDate, atributos[11]);

            // Chamada para o construtor
            p = c2(Id, Generation, Name, Description, Type1, Type2, tempAbilities, abilityIndex, Weight, Height, Capturerate, Islegendary, CaptureDate);

            // Liberar memória alocada para tempAbilities
            for (int i = 0; i < abilityIndex; i++)
            {
                free(tempAbilities[i]);
            }

            // Liberar os atributos alocados com strdup
            for (int i = 0; i < 12; i++)
            {
                free(atributos[i]);
            }
        }
    }

    fclose(file); // Fechar o arquivo após terminar a leitura
    return p;
}

/**
 * Função main
 * @version 1 testar metódos de construtor, imprimir e de free - CERTO
 * @version 2 ler do arquivo CSV e montar pokemon
 *
 */
int main()
{
    // definir dados
    setlocale(LC_ALL, "en_US.UTF-8"); // Forçar o uso de UTF-8
    char *filename = "C:/Users/User11/Documents/AEDS02/Verde/TP02/Q02/pokemon.csv";
    char id[100];      // id que vai ser lido
    Pokemon *p = NULL; // Pokemon que vai ser construído
    // ler id enquanto diferente de FIM
    scanf("%s", id);
    getchar();
    while (strcmp(id, "FIM") != 0)
    {
        p = ler(filename, id);
        imprimir(p); // imprimir cada Pokemon
        scanf("%s", id);
        getchar();
    } // end while

    // Liberar a memória alocada
    freePokemon(p);

    // retornar
    return 0;
}

/**
 * TESTES
 *
 * @version 1 - Teste de construtores e imprimir - UTF CERTO
 * // definir dados
    setlocale(LC_ALL, "en_US.UTF-8"); // Forçar o uso de UTF-8
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