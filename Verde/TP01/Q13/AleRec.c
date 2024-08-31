/*
 *  -------------------------- Documentacao
 *  Pontificia Universidade Catolica de Minas Gerais
 *  Curso de Ciencia da Computacao
 *  Algoritmos e Estruturas de Dados II
 *   
 *  TP01Q13 - 29 / 08 / 2024
 *  Author: Pedro Hosken Fernandes GUimarães
 *   
 *  Para compilar em terminal (janela de comandos):
 *       Linux : gcc -o AleRec AleRec.c
 *       Windows: gcc -o AleRec AleRec.c
 *   
 *  Para executar em terminal (janela de comandos):
 *       Linux : ./AleRec
 *       Windows: AleRec
 *   
*/

// ---------------------------------------- Dependencias

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

// ---------------------------------------- dados Globais

 char a;
 char b;

// ---------------------------------------- Metodos


/**
 *  Funcao Principal
 *  @param argc
 *  @param argv
*/
int main( int argc, char const *argv[] )
{
    gerador();
    start();
} // end main ( )