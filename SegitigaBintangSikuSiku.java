import java.util.Scanner;

public class SegitigaBintangSikuSiku {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tuliskan sebuah angka: ");
        int bilangan = scanner.nextInt();
        System.out.println(sikusiku(hasil));

        }

    public static String sikusiku (int hasil) {
        
        int angka = 0;
        for (int j =0; j <= bilangan ; j++) {
            for(int i = 0; i < j; i++){
                if (angka == 10){
                    angka = 0;
                }
                
                System.out.print(angka );
                angka++; 
            }
        
            System.out.println();
                
    }
         
}
