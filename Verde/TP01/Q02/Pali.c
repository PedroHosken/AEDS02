#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
// Função Booleana que retorna se é Pali
bool isPali(char *palavra)
{
  // definir dados
  bool is = true;
  int tam = strlen(palavra);
  int x = tam - 2;
  int y = 0;
  // passar letras
  while (y <= x)
  {
    if (palavra[x] != palavra[y])
    {
      is = false;
    }
    x = x - 1;
    y = y + 1;
  }
  // retornar
  return (is);
}
// Função Main

int main()
{
  // definir dados
  char palavra[80];
  bool pali = false;
  fgets(palavra, sizeof(palavra), stdin);
  // chamar função enquanto diferente de FIM
  while (strcmp(palavra, "FIM\n") != 0)
  {

    pali = isPali(palavra);
    if (pali)
    {
      printf("SIM\n");
    }
    else
    {
      printf("NAO\n");
    }
    fgets(palavra, sizeof(palavra), stdin);
  }

  // retornar
  return (0);
}