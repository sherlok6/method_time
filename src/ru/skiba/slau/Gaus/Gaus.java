package ru.skiba.slau.Gaus;

import ru.skiba.slau.Matrix;

import java.util.Random;
import java.util.Scanner;

public class Gaus implements Matrix {
    private double a[][];
    private int N;
    private static Random random;
    @Override
    public void reschenie(double e) {
        int razmerA;
        Scanner scan = new Scanner(System.in);
        razmerA = scan.nextInt();
        a = new double [razmerA][razmerA];
        double[] X = new double[razmerA];
        double[] B = new double [razmerA];
        double[] zamena = new double[razmerA + 1];

        System.out.print("X = ( ");
        for (int i = 0; i < razmerA; i++)
        {
            X[i] = i+1;
            System.out.print(X[i]+" ");
        }
        System.out.print(")" + "\n");

        System.out.print("A = ( "+ "\n" );

        for (int i = 0; i < razmerA; i++)
        {
            for (int j = 0; j < razmerA; j++)
            {
                a[i][j] = 1.0 + random.nextDouble() % 100;
                System.out.print(a[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.print(")"+"\n");
        System.out.print("B = ( ");
        for (int i = 0; i < razmerA; i++)
        {
            B[i] = 0;
            for (int j = 0; j < razmerA; j++)
            {
                B[i] += a[i][j] * X[j];
            }
            System.out.print(B[i] + " ");
        }
        System.out.print(")"+"\n");

        for (int i = 0; i < razmerA; i++)
        {
            X[i] = 0;
        }
        System.out.print("//////////////////////////////////////\n");
        for (int k = 0; k < razmerA; k++) {
            //находим максимальный элемент столбца
            double max = a[k][k];
            int it = k;
            for (int i = k; i < razmerA; i++)
            {
                if (a[i][k] > max) {
                    max = a[i][k];
                    it = i;
                }
            }
            //меняем строчки местами если не 1(k)
            if (it != k)
            {
                for (int j = k; j < razmerA; j++)
                {
                    zamena[j] = a[k][j];
                    a[k][j] = a[it][j];
                    a[it][j] = zamena[j];
                }
                zamena[razmerA] = B[k];
                B[k] = B[it];
                B[it] = zamena[razmerA];
            }
            //делим
            double kel;
            kel = a[k][k];
            for (int j = k; j < razmerA; j++)
            {
                a[k][j] /= kel;
            }
            B[k] /= kel;

            //вычитаем
            for (int i = k + 1; i < razmerA; i++)
            {
                for (int j = k; j < razmerA; j++)
                {
                    zamena[j] = a[k][j] * a[i][k];
                }
                zamena[razmerA] = B[k] * a[i][k];
                for (int j = k; j < razmerA; j++)
                {
                    a[i][j] -= zamena[j];
                }
                B[i] -= zamena[razmerA];
            }
        }

        System.out.print("Otvet\n");
        //Находим Х
        for (int k = razmerA - 1; k >= 0; k--)
        {
            X[k] = B[k];
            for (int i = razmerA - 1; i > k; i--)
            {
                X[k] -= a[k][i] * X[i];
            }
        }

        System.out.print("X = ( ");
        for (int i = 0; i < razmerA; i++)
        {
            System.out.print(X[i] + " ");
        }
        System.out.print(")\n");
    }

}