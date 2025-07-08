import java.util.Scanner;

public class Soal02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print(" ");
        System.out.print("Masukkan Koordinat x: ");
        int x = input.nextInt();
        System.out.print("Masukkan Koordinat y: ");
        int y = input.nextInt();
        
        int JarakKuadrat = x * x + y * y ;
        

        if (JarakKuadrat <= 100){
            System.out.println("Titik ("+ x +","+ y +") berada dalam lingkaran ");
        } else {
            System.out.println("Titik ("+ x +","+ y +") berada di luar lingkaran ");
        }

    }

}
