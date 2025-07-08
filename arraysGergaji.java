import java.util.Scanner;

public class arraysGergaji {
    public static void main(String[] args){
        int n = 15; 
        int[][] triangle = new int[n][];
        int size = 1;
        for (int i = 0; i<triangle.length; i = i + size++){
            createColumnPerRow(triangle,i,size);
        }
        isiAngka(triangle);
        printMatrix(triangle);
    }
    
    public static void isiAngka(int[][] triangle){
        int angka = 0;
        for (int kolom = 0; kolom < triangle.length ; kolom++){
            for (int baris2 = 0; baris2 < triangle.length ; baris2++){
                if (kolom < triangle[baris2].length){
                    triangle[baris2][kolom] = angka;
                    angka = (angka + 1) % 10;
                }
            }
        }
    }

    public static void createColumnPerRow(int[][] triangle,int row, int size){
        int i = 1;
        for(int baris = row; baris < Math.min(row+size, triangle.length) ;baris++)
            triangle[baris] = new int[i++];
    }

    public static void createColumn(int[][] triangle){
        for(int i=0; i < triangle.length; i++){
            triangle[i] = new int[i+1];
        }
    }

    public static void printMatrix(int[][] triangle){
        for(int i=0;i < triangle.length; i++){
            for(int j=0; j < triangle[i].length; j++)
                System.out.printf("%3d", triangle[i][j]);
            System.out.println();
        }
    }
}

