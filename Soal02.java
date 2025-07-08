import java.util.Scanner;

public class Soal02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // input yang pertama 
        System.out.print("Masukkan tanggal pertama: ");
        int tanggal1 = input.nextInt(); 
        System.out.print("Masukkan bulan pertama: ");
        int bulan1 = input.nextInt();
        System.out.print("Masukkan tahun pertama: ");
        int tahun1 = input.nextInt();

        // input yang kedua 
        System.out.print("Masukkan tanggal kedua: ");
        int tanggal2 = input.nextInt(); 
        System.out.print("Masukkan bulan kedua: ");
        int bulan2 = input.nextInt();
        System.out.print("Masukkan tahun kedua: ");
        int tahun2 = input.nextInt();

        int hari1 = hitungJumlahHari (tanggal1, bulan1, tahun1);
        int hari2 = hitungJumlahHari (tanggal2, bulan2, tahun2);

        int selisih = hari1 > hari2 ? hari1 - hari2 + 1 : hari2 - hari1 + 1;

        System.out.println("Jumlah hari antara kedua tanggal tersebut adalah:  " + selisih);

        input.close();
    }

    public static int hitungJumlahHari (int tanggal, int bulan, int tahun) {
        int total = 0;

        int tahunPenuh = tahun;
        int jumlahKabisat = (tahunPenuh / 4) - (tahunPenuh / 100) + (tahunPenuh / 400);
        int jumlahNormal = tahunPenuh - jumlahKabisat;
        total += (jumlahNormal * 365) + (jumlahKabisat * 366);
        
        if (bulan > 1) total += 31;
        if (bulan > 2) total += isKabisat(tahun) ? 29:28;
        if (bulan > 3) total += 31;
        if (bulan > 4) total += 30;
        if (bulan > 5) total += 31;
        if (bulan > 6) total += 30;
        if (bulan > 7) total += 31;
        if (bulan > 8) total += 30;
        if (bulan > 9) total += 31;
        if (bulan > 10) total += 30;
        if (bulan > 11) total += 31;

        total += tanggal;

        return total;
    }

    public static boolean isKabisat(int tahunn) {
        return (tahunn % 4 == 0 && tahunn % 100 != 0) || (tahunn % 400 == 0);
    }
}