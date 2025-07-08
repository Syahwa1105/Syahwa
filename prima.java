import java.util.Scanner;

public class prima {
    public static boolean isPrima (int bilangan) {
        for (int a= 2 ; a < bilangan ; a++){
            if (bilangan % a == 0) 
                return false;       
        }
        return true; 
    }

    public static void main(String[] args){
        System.out.println("Masukkan sebuah angka: ");
        Scanner scanner = new Scanner (System.in);
        int bilangan = scanner.nextInt(); 
        boolean hasil = isPrima (bilangan);
        System.out.println("Bilangan tersebut adalah bilangan prima " + hasil );
    }

}


