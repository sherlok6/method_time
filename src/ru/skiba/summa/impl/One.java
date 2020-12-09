package ru.skiba.summa.impl;

import ru.skiba.summa.Rows;

import java.util.Date;

public class One implements Rows{
    public double getFactorial(double f) {
        if (f <= 1) {
            return 1;
        }
        else {
            return f * getFactorial(f - 1);
        }
    }
    @Override
    public void findSumm(){//e^x
        double summa, partSequence ,x = -5.5, precision = 1.0e-12/*0.000001*/, numElemSeq=0;
        partSequence = 1;summa = partSequence;
        long begin = System.currentTimeMillis(),end;
        while (Math.abs(partSequence) > precision) {
            numElemSeq ++;
            partSequence = partSequence * (x / numElemSeq);
            summa += partSequence;
        }
        end=System.currentTimeMillis();
        String result = String.format("%.12f",summa);
        System.out.println("(o) S = " + result + " Iteration = " + numElemSeq + " Time(ms):" + (end - begin));
        partSequence = 1;summa = 1;numElemSeq = 0;
        begin = System.currentTimeMillis();
        while(Math.abs(partSequence) > precision){
            numElemSeq ++;
            partSequence = Math.pow(x,numElemSeq)/getFactorial(numElemSeq);
            summa += partSequence;
        }
        end = System.currentTimeMillis();
        result = String.format("%.12f",summa);
        System.out.println("(l) S = " + result + " Iteration = "+ numElemSeq + " Time(ms):" + (end - begin));
    }
}
