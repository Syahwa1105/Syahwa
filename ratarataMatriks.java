import java.util.Scanner;

public class ratarataMatriks {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int [] [] matriks = new int [3] [3];
        int total = 0;

        System.out.println("\nMasukkan 9 bilangan bulat untuk matrik 3x3: ");
        for (int i = 0; i < 3; i++){
            for (int j = 0; j<3; j++){
                matriks[i][j] = input.nextInt();
                total += matriks[i][j];
                System.out.print(matriks[i][j]);
            }
            System.out.println();
        }

        double mean = total/9.0;

        int count = 0;
        int [][] indeksKecil = new int[9][2];

        for (int i = 0; i <3; i++){
            for (int j = 0; j<3; j++){
                if(matriks[i][j] < mean){
                    indeksKecil[count][0] = i;
                    indeksKecil[count][0] = j;
                    count++;
                }
            }
        }

        System.out.printf("Mean: %.1f\n" , mean);
        System.out.println("Bilangan yang lebih kecil dari mean ada: " + count + " bilangan" );
        System.out.println("Bilangan tersebut ada pada index:");
        for (int k = 0; k < count; k++){
            System.out.print("[" + indeksKecil[k][0] + "," + indeksKecil[k][1] + "]");
        }
        System.out.println();


    }
}