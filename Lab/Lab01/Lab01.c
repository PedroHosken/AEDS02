#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//função inteira para analisar o total de maiusculas
int tot(char *palavra)
{
    // definir dados
    int cont = 0;
    char letra = 'a';
    // metodo iterativo
    for (int x = 0; x < strlen(palavra); x = x + 1)
    {
        // atribuir caractere à letra
        letra = palavra[x];
        // realizar o teste para verificar se a letra é maiusucla
        if ('A' <= letra && letra <= 'Z')
        {
            cont = cont + 1;
        }
    }
    // retornar
    return (cont);
}

int main()
{
    //definir dados
      int total = 0;
      char palavra [80];
    //leitura de string enquanto diferente de fim
      do{
        scanf("%s", palavra); getchar();
        if ( strcmp(palavra, "FIM")){
            total = tot(palavra);
            printf("O total de M e %i\n", total);
        }
      }while(strcmp(palavra, "FIM"));
    //retornar
      return 0;
}