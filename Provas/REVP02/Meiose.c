/**
 * Questão 01 da Prova
 *
 * @author Pedro Hosken 816561
 * @version 1 - 12/11/2024
 */

// ---- Dependências ---- //

#include <stdio.h>

// ---- Dados ---- //
typedef struct Celula
{
    int elemento;
    struct Celula *prox;
} Celula;

Celula *inicio;
Celula *fim;

/**
 * Metódo Meiose
 *
 * Objetivo: percorrer toda lista e realizar a "meiose" de cada célula
 *
 * Como: Vamos de forma iterativa, andando de 2 em 2 casas, acessar cada valor da célula,
 * dividi-la por dois, criar uma nova celula, anexa-la a lista.
 *
 * @var int val - valor que vai receber a celula->elemento / 2
 * @var Celula tmp - celula auxiliar para duplicar a Célula
 * @var Celula i - iteração
 *
 * @param Celula inicio
 *
 * Casos de teste: 1 - lista vazia
 */

void Meiose(Celula *inicio)
{
    // Verifica se a lista está vazia
    if (inicio == NULL)
    {
        return;
    }
    // definir dados
    int val = 0;

    // iteração
    for (Celula *i = inicio; i != NULL; i = i->prox->prox)
    {
        val = i->elemento / 2;                          // recebe valor e divide por 2
        Celula *tmp = (Celula *)malloc(sizeof(Celula)); // inicialização
        tmp->elemento = val;                            // recebe valor
        tmp->prox = i->prox;                            // aponta para o proximo
        i->prox = tmp;                                  // recebe do atual
    }
}
