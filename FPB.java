import java.util.Scanner;

public class FPB {
    public static int hitungFPB(int a, int b){
        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;

        }
        return a;                 
    }
}