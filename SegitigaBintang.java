import java.util.Scanner;

public class SegitigaBintang {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tuliskan sebuah angka: ");
        int bilangan = scanner.nextInt();
        System.out.println(segitiga(bilangan));


    }

    public static String segitiga(int bilangan){
        String hasil="";
        int tinggi = bilangan;
        for (int j =1; j <= tinggi ; j++) {
            bilangan--;
            for (int spasibintang = 0 ; spasibintang < bilangan; spasibintang++){
                System.out.print(" ");
                hasil += " ";
            }
            for (int bintang = 1 ; bintang <= 2*j-1 ; bintang++){
                System.out.print("*"); 
                hasil += "*";
            }
            System.out.println();
            hasil += "\n";
        }

        return hasil;

    }
         
}

