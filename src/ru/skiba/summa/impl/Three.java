package ru.skiba.summa.impl;

import ru.skiba.summa.Rows;

public class Three implements Rows {

    @Override
    public void findSumm() {
        double numElemSeq,pi,partSeq = 1, summa = 0, percision = 1e-10;
        pi = (15 * Math.pow(Math.PI,2) - Math.pow(Math.PI,4)) / 90;
        long begin = System.currentTimeMillis();
        String result;
        for (numElemSeq = 1; Math.abs(partSeq) >= percision; numElemSeq++)
        {
            partSeq = 1 / (numElemSeq * numElemSeq * numElemSeq * numElemSeq * (numElemSeq * numElemSeq + 1));
            summa += partSeq ;
        }
        summa += pi;
        result = String.format("%.10f",summa);
        System.out.println("(o)S = " + result + " Iteration = " + numElemSeq + " Time(ms) :" + (System.currentTimeMillis()-begin));
        summa = 0;partSeq = 1;
        begin = System.currentTimeMillis();
        for (numElemSeq = 1;Math.abs(partSeq) >= percision; numElemSeq++)
        {
            partSeq = 1 / (numElemSeq*numElemSeq + 1);
            summa += partSeq;
        }
        result = String.format("%.10f",summa);
        System.out.println("(l)S = " + result + " Iteration = " + numElemSeq + " Time(ms) :" + (System.currentTimeMillis()-begin));
    }
}
