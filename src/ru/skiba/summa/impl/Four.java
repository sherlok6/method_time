package ru.skiba.summa.impl;

import ru.skiba.summa.Rows;

public class Four implements Rows {

    @Override
    public void findSumm() {
        double i, iterL, summa, e = 3e-08, x = 0.99999999999, partSeq = 1, S = 0;
        String result;
        for (i = 1; Math.abs(partSeq) >= e; i++)
        {
            partSeq = 1 / Math.sqrt((i*i*i) + x);
            S += partSeq;
        }
        iterL = i;summa = S;partSeq = 1;S = 0;

        for (i = 1;Math.abs(partSeq) >= e; i++)
        {
            partSeq = 1 / Math.sqrt((i*i*i) - x);
            S += partSeq;
        }
        summa += -S;
        iterL += i;
        result = String.format("%.8f",summa);
        System.out.println("Сумма рядов: " + result + "\nКол-во итераций: " + iterL );
        partSeq = 1; S = 0;
        for (i = 1; Math.abs(partSeq) >= e; i++)
        {
            partSeq = (Math.sqrt((i*i*i) - x) - Math.sqrt((i*i*i) + x))/Math.sqrt(i*i*i*i*i*i - x * x);
            S += partSeq;
        }
        summa = S;
        result = String.format("%.8f",summa);
        System.out.println("Сумма обработанного ряда: " + result + "\nКол-во итераций: " + i);
        System.out.println("\nРазница в итерациях: " + Math.abs(iterL - i));
    }
}
