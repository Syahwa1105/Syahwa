import java.util.Scanner;

public class maximumSubrayy {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("arr[]=  ");
        String[] n = input.nextLine().split(" ");
        int[] h = new int[n.length];
        for (int a = 0 ; a < h.length; a++){
            h[a]= Integer.parseInt(n[a]);
        }
        System.out.println("Output: " + maxSubArray(h));

    }
    public static int maxSubArray(int[] input){
        int terbesar = -999999;

        for (int i = 0; i < input.length; i++){
            int hasil = 0;
            for (int batas = i; batas < input.length ; batas++){
                hasil += input[batas];
                if (hasil > terbesar){
                    terbesar = hasil;
                }
            }

        }
        return terbesar;
    }
}
