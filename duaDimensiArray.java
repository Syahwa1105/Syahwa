import java.util.Scanner;

public class duaDimensiArray {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int [] [] matriks1 = new int [3] [3];
        int [] [] matriks2 = new int [3] [3];
        
        System.out.println("Masukkan 9 bilangan bulat untuk matriks 1:");
        int counter = 0;
        String[] inputNumbers1 = input.nextLine().split(" ");
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                matriks1[i][j] = Integer.parseInt(inputNumbers1[counter++]);
            }
        }

        System.out.println("Masukkan 9 bilangan bulat untuk matriks 2:");
        counter = 0;
        String[] inputNumbers2 = input.nextLine().split(" ");
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                matriks2[i][j] = Integer.parseInt(inputNumbers2[counter++]);
            }
        }
        boolean sama = true;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (matriks1 [i][j] != matriks2 [i][j]){
                    System.out.print("[" + i + "," + j+ "]");
                    sama = false;
                }

            }
        }
        if(sama){
            System.out.println("Kedua matriks sama persis.");

        }else {
            System.out.println("\nKedua matriks tidak sama pada indeks tersebut.");
        }

        



    }
    
}
