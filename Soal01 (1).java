import java.util.Scanner;

public class Soal01 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        // masukkan nilai x1
        System.out.print("Masukkan x1: ");
        double x1 = input.nextDouble();
        // masukkan nilai y1 
        System.out.print("Masukkan y1: ");
        double y1 = input.nextDouble();
        // masukkan nilai r1 
        System.out.print("Masukkan jari-jari lingkaran (r)1 : ");
        double r1 = input.nextDouble();
        
        // masukkan nilai x2
        System.out.print("Masukkan x2: ");
        double x2 = input.nextDouble();
        System.out.print("Masukkan y2: ");
        double y2 = input.nextDouble();
        System.out.print("Masukkan jari-jari lingkaran (r)2: ");
        double r2 = input.nextDouble();

        double jarak = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

        if (jarak <= r1 + r2) {
            System.out.println("Beririsan");
        } else {
            System.out.println("Tidak beririsan");
        }
    }
}