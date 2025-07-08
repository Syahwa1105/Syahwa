import java.util.Scanner;

public class Soal03 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        System.out.print("Masukkan Sisi Pertama:");
        int a = input.nextInt();
        System.out.print("Masukkan Sisi Kedua: ");
        int b = input.nextInt(); 
        System.out.print("Masukkan Sisi Ketiga: ");
        int c = input.nextInt();

        boolean Segitiga = (a + b > c) && (a + c > b) && (b + c > a);

        if (Segitiga) {
            System.out.println("Bukan Segitiga");
        } else {
            if (a == b && b == c) {
                System.out.println("Sama sisi"); 
            } else if (a == b || b == c || a == c) {
                System.out.println("Sama kaki");
            } else {
                System.out.println("Sembarang");
            }
        }

        input.close();
    
    }

}
