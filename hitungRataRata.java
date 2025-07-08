import java.util.Scanner;

public class hitungRataRata {
    public static void main (String[] args){
        Scanner input = new Scanner (System.in);
        System.out.println("\nTuliskan beberapa bilangan bulat positif. Untuk mengakhiri tuliskan");
        System.out.println("bilangan bulat negatif.");
        System.out.println("Bilangan anda: ");
        String[] inputNumbers = input.nextLine().split(" ");
        int[] numbers = new int[inputNumbers.length];
        int[] flag = new int[inputNumbers.length];
        int i = 0;
        int[] cek = new int[inputNumbers.length];
        for (int s = 0; s < inputNumbers.length; s++){
            cek [s] = -1; 
        }

        double mean = 0 ;
        for(String data: inputNumbers){
            if (data.contains("-")){
                break;
            }
            numbers[i++] = Integer.parseInt(data);
        
            mean += numbers[i - 1];

        }
        mean = mean / i; 
        System.out.println("Mean: " + mean);
        int kecil = 0;


        for (int a = 0; a < numbers.length -1; a++){
            int curr = numbers[a];
            boolean checked = false;
            if (curr < mean) {
                for (int s = 0; s < inputNumbers.length; s++){
                    if (curr == cek[s]){
                        checked = true;
                    }
                }
                if (!checked) {
                    flag[a] = 1;
                    cek [a] = curr;
                }
            }

        }

        for ( int a = 0; a < flag.length; a++){
            kecil+=flag[a];

        }
        System.out.println("Bilangan yang lebih kecil dari mean ada: " + kecil + " bilangan. ");  

}
    
}
