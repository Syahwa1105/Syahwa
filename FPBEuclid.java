// Lanjutan dari soal 03 
import java.util.Scanner;

public class FPBEuclid {
    public static int hitungFPB(int a, int b){
        if ( a %  b == 0){
            return  b;
        } else {
            return hitungFPB(b, a % b);
        } 
}
}