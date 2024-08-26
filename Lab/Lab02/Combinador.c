#include <stdio.h>
#include <string.h>
#include <stdbool.h>

// função comb

void comb(char s1[], char s2[])
{
    // definir dados
    int tam1 = strlen(s1);
    int tam2 = strlen(s2);
    int tam3 = tam1 + tam2;
    char nova[tam3];
    // iterativamente formar nova palavra
    int x = 0, y = 0, z = 0;
    while (x < tam1 && y < tam2)
    {
        nova[z] = s1[x];
        z++;
        x++;
        nova[z] = s2[y];
        z++;
        y++;
    }
    while(x < tam1)
    {
        nova[z] = s1[x];
        z++;
        x++;
    }
    while(y < tam2)
    {
        nova[z] = s2[y];
        z++;
        y++;
    }
    nova[z] = '\0';
    // retornar
    printf("%s\n", nova);
}

/*
//definir dados
      char s1[80];
      char s2[80];
    //chamra função e printar
      while(scanf("%s %s", s1, s2) == 1)
      {
        comb(s1,s2);
      }
*/

// main
int main()
{
    // definir dados
    char s1[80] = "abc";
    char s2[80] = "12345";
    //chamra função e printar
      while(scanf("%s %s", s1, s2) == 1)
      {
        comb(s1,s2);
      }
    // retornar
    return (0);
}