#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <locale.h> // location specific settings

// metodo de ler e do arquivo e printar na tela
void printar(FILE *file, int n)
{
    // definir dados
    double receive = 0.0;
    char numero[80];
    double numeros[n];
    char *aux;
    // ler iterativamente do fim para o iniicio
    fseek(file, 0, SEEK_END);
    long pos = ftell(file);
    for (long i = pos - 1; i >= 0; i = i - 1)
    {
        fseek(file, i, SEEK_SET);
        fscanf(file, "%s", numero);
        receive = strtod(numero, &aux);
        printf("%lf\n",receive);
    }
}
// metodo de leitura de reais e guardar em arquivo
void ler(FILE *file, int n)
{
    // definir dados
    double input = 0.0;
    char aux[80];
    // ler iterativamente e guardar em arquivo
    if (file == NULL)
    {
        printf("FALHA AO ABRIR\n");
    }
    else
    {
        for (int x = 0; x < n; x = x + 1)
        {
            scanf("%lf", &input);
            sprintf(aux, "%f", input);
            // printf("%s", aux);
            fprintf(file, "%s\n", aux);
        }
    }
}

// metodo de ler inteiro e chamar outras funções
void start(FILE *file)
{
    // definir dados
    int x = 0;
    // ler do teclado e chamr outras funções
    scanf("%d", &x);
    getchar();
    ler(file, x);
    printar(file, x);
}

// metodo main
int main()
{
    // definir dados
    FILE *file = fopen("reais2.txt", "w+");
    setlocale(LC_NUMERIC, "en_US.UTF-8");
    // começar metódos
    start(file);
    // fechar arquivo
    fclose(file);
    // retornar
    return 0;
}