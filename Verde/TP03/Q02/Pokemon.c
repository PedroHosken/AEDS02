/**
 * Estrutura Pokemon
 * @author Pedro Hosken Fernandes Guimarães - 816561
 * @version 1 - 30/09/2024
 * @version 2 - 12/10/2024
 * @version 3 - 31/10/2024
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
 *
 * IGNOREI, VAI TUDO SER STRING
 */

typedef struct
{
    char *id;
    char *generation;
    char *name;
    char *description;
    char *type1;
    char *type2;
    char *abilities[MAX_ABILITIES];
    char *weight;
    char *height;
    char *captureRate;
    char *isLegendary;
    char *captureDate;
} Pokemon;

/**
 * Metódo C2
 *
 * Objetivo: ser como um construtor padrão, utilizando parâmetros
 * Como: vamos passar para cada atributo seu devido parametro
 *
 * @param char* id
 * @param char* generation
 * @param char* name
 * @param char* description
 * @param char* id
 * @param char* id
 * @param char* id
 * @param char* id
 * @param char* id
 * @param char* id
 * @param char* 
 * @param char* 
 *
 */

/**
 * Função main
 * @version 1 testar metódos de construtor, imprimir e de free, TUDO EM STRING
 *
 */
int main()
{
    // definir dados
    setlocale(LC_CTYPE, "pt_BR.UTF-8");
    char *filename = "C:/Users/User11/Documents/AEDS02/Verde/TP02/Q02/pokemon.csv";
    // retornar
    return 0;
}

/**
 * TESTES
 *
 *
 *
 *
 *
 *
 */