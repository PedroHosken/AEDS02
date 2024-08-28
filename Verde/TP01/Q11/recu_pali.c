#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

// metodo recursividade
bool recu(char *palavra, int x, int y)
{
    // definir dados
    bool is = true;
    char a = 'a';
    char b = 'b';
    // parada da recursividade
    if (x <= y)
    {
        a = palavra[x];
        b = palavra[y];
        if (a != b)
        {
            is = false;
            x = y + 1;
        }
        else
        {
            is = true;
            is = recu(palavra, x + 1, y - 1);
        }
    }
    // retornar valor de is
    return (is);
}

// chamada da recursividade
bool recu2(char *palavra)
{
    // definir dados
    int tam = strlen(palavra) - 2;
    // chamar recursividade
    return (recu(palavra, 0, tam));
}
// metodo main
int main()
{
    // definir dados
    bool is = false;
    char palavra[80];
    // ler string e chamar funções
    fgets(palavra, sizeof(palavra), stdin);
    while (strcmp(palavra, "FIM\n") != 0)
    {

        is = recu2(palavra);
        if (is)
        {
            printf("SIM\n");
        }
        else
        {
            printf("NAO\n");
        }
        fgets(palavra, sizeof(palavra), stdin);
    }
}