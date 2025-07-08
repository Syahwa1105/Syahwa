import java.util.Scanner;

public class matriksSegitiga {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan angka: ");
        int n = input.nextInt();
        input.nextLine();
        int[][] triangle = buatSegitiga(n);

        for (int i = 0; i < triangle.length; i++){
            for(int j=0; j < triangle[i].length; j++){
                System.out.printf("%3d", triangle[i][j]);
            }
            System.out.println(); 
        }
    }
    
    public static int[][] buatSegitiga(int n){
        int[][] triangle = new int[n][];
        for(int i=0; i < triangle.length; i++){
            triangle[i] = new int[i+1];

        }
        return triangle; 
    }
}