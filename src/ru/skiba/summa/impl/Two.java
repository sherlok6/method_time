package ru.skiba.summa.impl;

import ru.skiba.summa.Rows;

public class Two implements Rows {
    @Override
    public void findSumm() {
        double x, k, partSeq, f, precision = 5e-9/*0.000000005*/;
        String result,X;
        for (x = 0.0; x <= 1; x += 0.1)
        {
            partSeq = 1.0;f = 0.0;
            for (k = 1.0; partSeq >= precision; k++)
            {
                partSeq = 1.0 / (k*(k + x)*(k + 1));
                f += partSeq;
            }
            f = (1 - x)*f + 1;
            result = String.format("%.9f",f);
            X = String.format("%.1f",x);
            System.out.println("y(o) = " + result + " x = " + X );
        }
        System.out.print("\n");
        for (x = 0.0; x <= 1.0; x += 0.1)
        {
            partSeq = 1;
            f = 0;
            for (k = 1.0; partSeq >= precision; k++)
            {
                partSeq = 1 / (k*(k + x));
                f += partSeq;
            }
            result = String.format("%.9f",f);
            X = String.format("%.1f",x);
            System.out.println("y(l) = " + result + " x = " + X);
        }
    }
}
