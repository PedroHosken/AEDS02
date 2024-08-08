#include <stdio.h>
#include <string.h>

// função de recursão
int totM(char *palavra, int x)
{
    // definir dados
    char letra = 'a';
    int cont = 0;
    int tam = strlen(palavra);
    // ponto de parada
    if (x < tam)
    {
        // testar se o caractere daquela pos é M
        letra = palavra[x];
        if ('A' <= letra && letra <= 'Z')
        {
            cont = cont + 1;
        }
        // recursão
        cont += totM(palavra, x + 1);
    }
    // retornar valor
    return (cont);
}

// função de chamada
int tot(char *palavra)
{
    // retornar x
    return (totM(palavra, 0));
}

// função main
int main()
{
    // definir dados
    char palavra[80];
    int total = 0;
    // ler palavra e chamar função enquanto diferente de FIM
    do
    {
        scanf("%s", palavra);
        getchar();
        if (strcmp(palavra, "FIM"))
        {
            total = tot(palavra);
            printf("O total de M e %i\n", total);
        }
    } while (strcmp(palavra, "FIM"));
    // retornar
    return 0;
}
