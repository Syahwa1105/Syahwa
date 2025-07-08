import java.util.Scanner; 

public class Soal03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // detail bujur sangkar pertama
        System.out.println("Masukkan detail bujur sangkar 1: ");
        System.out.print("x1: ");
        int x1 = input.nextInt();
        System.out.print("y1: ");
        int y1 = input.nextInt();
        System.out.print("sisi1: "); 
        int ss1 = input.nextInt();

        // detail bujur sangkar kedua
        System.out.println("Masukkan detail bujur sangkar 2: ");
        System.out.print("x2: ");
        int x2 = input.nextInt();
        System.out.print("y2: ");
        int y2 = input.nextInt();
        System.out.print("sisi2: "); 
        int ss2 = input.nextInt();

        int x1b = x1 + ss1;
        int y1b = y1 + ss1;
        int x2b = x2 + ss2;
        int y2b = y2 + ss2; 

        if (x1b <= x2 || x2b <= x1 || y1b <= y2 || y2b <= y1) {
            System.out.println("Kedua bujur sangkar terpisah."); 
        }
        else if ((x1 >= x2 && y1 >= y2 && x1b <= x2b && y1b <= y2b) || (x2 >= x1 && y2 >= y1 && x2b <= x1b && y2b <= y1b)) {
            System.out.println("Salah satu bujur sangkar berada didalam. ");
        }
        else {
            System.out.println("Kedua bujur sangkar saling beririsan. ");
        }
        
        input.close();
    }
}
