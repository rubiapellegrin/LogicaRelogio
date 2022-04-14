/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author rubia
 */
public class Principal {

    public static void main(String args[]) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Informe o numero de processos: ");
        int n = ler.nextInt();

        System.out.println("Informe o processo emissor: ");
        int emi = ler.nextInt();

        System.out.println("Informe o tempo do emissor: ");
        int tempoEmi = ler.nextInt();

        System.out.println("Informe o processo receptor: ");
        int rec = ler.nextInt();

        System.out.println("Informe o tempo do receptor: ");
        int tempoRec = ler.nextInt();

        int valorAnterior = 0;
        int valor = 0;
        int cont = 5;
        int valorEmissor = 0;
        int valorReceptor = 0;
        int diferençaReceptor = 0;

        int[][] mat = new int[n][10];
        
        System.out.println("Localização:");
    
       for (int i = 0; i < n; i++) {
            System.out.print("[ ");
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    valorAnterior = 0;
                    valor = 0;
                }
                if (j == 1) {
                    valorAnterior = 0;
                    valor = valor + cont;
                    cont = cont + 3;
                }
                mat[i][j] = valorAnterior + valor;
                valorAnterior = mat[i][j];

                if (emi == i && tempoEmi == j) {
                    System.out.print("->(Emissor)" + mat[i][j] + "<- ");
                    valorEmissor = mat[i][j];
                }
                if (rec == i && tempoRec == j) {
                    System.out.print("->(Receptor)" + mat[i][j] + "<- ");
                    valorReceptor = mat[i][j];
                    diferençaReceptor = cont - 3;
                }

                System.out.print(mat[i][j] + " ");

            }
            System.out.print("]");
            System.out.println();
        }

        //if(valorEmissor>valorReceptor)
        //      System.out.println("diferença do Receptor " + diferençaReceptor);
        System.out.println("Resultado:");

        int valorAnteriorAux = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("[ ");
            for (int j = 0; j < 10; j++) {
                if (valorEmissor > valorReceptor) {
                    if (i == rec && j == tempoRec) {
                        mat[i][j] = valorEmissor + 1;
                        valorAnteriorAux = mat[i][j];
                    }
                    if (i == rec && j > tempoRec) {
                        mat[i][j] = valorAnteriorAux + diferençaReceptor;
                        valorAnteriorAux = mat[i][j];
                    }

                }

                System.out.print(mat[i][j] + " ");
            }

            System.out.print("]");
            System.out.println();
        }

    }

}
