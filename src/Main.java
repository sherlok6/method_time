import ru.skiba.slau.Gaus.Gaus;
import ru.skiba.slau.Matrix;
import ru.skiba.summa.Rows;
import ru.skiba.summa.impl.Four;
import ru.skiba.summa.impl.Two;

import java.util.Scanner;

public class Main {
    private static Matrix matrix;
    private static Rows rows;
    public static void main(String[] args){
      /* rows = new Two();
        rows.findSumm();*/
       matrix = new Gaus();
       System.out.print("Введите точность :");
       matrix.reschenie(new Scanner(System.in).nextDouble());
    }
}
