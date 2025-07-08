import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BurhanFess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tambahan Variabel untuk (Sub-Task 5)
        String isiFess = "";
        // Variabel ini akan diisi nilainya di Sub-Task 4
        LocalDateTime waktuPengirimanFinal = null; 
        // variabel baru untuk Tugas Pemograman Lanjutan
        int permainanCount = 0;
        boolean lanjutPermainan = true; 
        do {
            permainanCount++; 
        
        // Tampilan Pembuka menggunakan ASCII-Art untuk "BurhanFess" (Sub-Task 1)
        System.out.println("\n###########################################################");
        System.out.println("#                                                          #");
        System.out.println("#                                                          #");
        System.out.println("#   ____             _                 ______              #");
        System.out.println("#  | __ ) _   _ _ __| |__   __ _ _ __ |   ___|__ ___ ___   #");
        System.out.println("#  |  _ \\| | | | '__| '_ \\ / _` | '_ \\| |_ / _ \\/ __/ __|  #");
        System.out.println("#  | |_) | |_| | |  | | | | (_| | | | |  _|   __/\\__ \\__ \\ #");
        System.out.println("#  |____/ \\__,_|_|  |_| |_|\\__,_|_| |_|_|   \\___||___/___/ #");
        System.out.println("#                                                          #");
        System.out.println("#                                                          #");
        System.out.println("#                                                          #");
        System.out.println("###########################################################");
        System.out.println("\n");
        System.out.println("Selamat datang di Quiz BurhanFess!");
        System.out.println("Temukan 'kode vibe' Anda di dunia fiksi BurhanFess.");
        System.out.println("Jawablah setiap pertanyaan dengan jujur.");

        // Pemilihan Mode Output Interpretasi (Sub-Task 3)
        int pilihanMode = -1;
        String modeOutputText = "";

        while (pilihanMode < 0 || pilihanMode > 1) {
            System.out.print("\nPilih mode output interpretasi (0 = If-Else, 1 = Switch-Case): ");
            pilihanMode = scanner.nextInt();
            if (pilihanMode == 0) {
                modeOutputText = "If-Else";
            } else if (pilihanMode == 1) {
                modeOutputText = "Switch-Case";
            } else {
                System.out.println("Pilihan tidak valid. Harap masukkan 0 atau 1.");
            }
        }
        scanner.nextLine();

        // Menerima Input dan Menghitung Skor (Sub-Task 1)
        int totalScore = 0;

        System.out.print("\nPertanyaan 1: Apakah Anda lebih sering menjadi pembaca daripada pembuat 'fess' di dunia maya? (Ketik 1 jika ya dan ketik 0 jika tidak): ");
        int input1 = scanner.nextInt();
        if (input1 == 1) {
            totalScore += 1;
            System.out.println("Skor bertambah +1.");
        }
        scanner.nextLine();

        System.out.print("\nPertanyaan 2: Ketika ada isu hangat, apakah Anda cenderung ikut berkomentar atau memberikan reaksi? (Ketik 'ya' jika ya dan ketik 'tidak' jika tidak):");
        String input2 = scanner.nextLine();
        if (input2.equalsIgnoreCase("ya")) {
            totalScore += 2;
            System.out.println("Skor bertambah +2.");
        }

        System.out.print("\nPertanyaan 3: Apakah Anda suka membagikan 'fess' yang membuat orang lain bertanya-tanya atau menebak maksudnya? (Ketik 1 jika ya dan ketik 0 jika tidak): ");
        int input3 = scanner.nextInt();
        if (input3 == 1) {
            totalScore += 4;
            System.out.println("Skor bertambah +4.");
        }
        scanner.nextLine();

        System.out.print("\nPertanyaan 4: Apakah Anda menikmati 'fess' yang memicu diskusi atau perdebatan seru, bahkan kadang kontroversial? (Ketik 'ya' jika ya dan ketik 'tidak' jika tidak): ");
        String input4 = scanner.nextLine();
        if (input4.equals("ya")) {
            totalScore += 8;
            System.out.println("Skor bertambah +8.");
        }

        System.out.print("\nPertanyaan 5: Apakah Anda merasa 'fess' yang Anda kirim seringkali memiliki makna tersembunyi atau butuh pemikiran mendalam? (Ketik 1 jika ya dan ketik 0 jika tidak): ");
        int input5 = scanner.nextInt();
        if (input5 == 1) {
            totalScore += 16;
            System.out.println("Skor bertambah +16.");
        }
        scanner.nextLine();

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("Quiz selesai!");
        System.out.println("Total skor Anda adalah: " + totalScore);
        System.out.println("--------------------------------------------------------------------------------");

        // Mengeluarkan Output Sesuai kodeVibe (Sub-Task 2 & 3)
        System.out.println("\nInterpretasi 'kode vibe' Anda:");
        String kodeVibeMessage = "Skor Anda berada di luar rentang kodeVibe yang diketahui. Ada yang menarik dengan Anda!";

        if (pilihanMode == 0) { // If-Else Mode
            if (totalScore >= 0 && totalScore <= 5) {
                kodeVibeMessage = "Kamu tipe 'pengagum diam-diam'. MenFess-mu jarang, tapi kalau muncul bikin kaget.";
            } else if (totalScore >= 6 && totalScore <= 10) {
                kodeVibeMessage = "Kamu tipe 'semi-aktif'. Kadang muncul dengan kode, kadang ngilang.";
            } else if (totalScore >= 11 && totalScore <= 15) {
                kodeVibeMessage = "Kamu tipe 'suka bikin penasaran'. MenFess-mu bikin orang mikir, tapi kadang bikin bingung.";
            } else if (totalScore >= 16 && totalScore <= 20) {
                kodeVibeMessage = "Kamu tipe 'suka bikin drama'. MenFess-mu bikin orang penasaran, tapi terlalu banyak drama.";
            } else if (totalScore >= 21 && totalScore <= 25) {
                kodeVibeMessage = "Kamu tipe 'suka bikin orang mikir'. MenFess-mu bikin orang penasaran, tapi kadang bikin mereka mikir";
            } else if (totalScore >= 26 && totalScore <= 31) {
                kodeVibeMessage = "Kamu tipe 'rahasia'. MenFess-mu jarang muncul, tapi kalau muncul bikin orang penasaran siapa yang kirim.";
            }
        } else if (pilihanMode == 1) { // Switch-Case Mode
            int kategoriScore;
            if (totalScore >= 0 && totalScore <= 5) {
                kategoriScore = 0;
            } else if (totalScore >= 6 && totalScore <= 10) {
                kategoriScore = 1;
            } else if (totalScore >= 11 && totalScore <= 15) {
                kategoriScore = 2;
            } else if (totalScore >= 16 && totalScore <= 20) {
                kategoriScore = 3;
            } else if (totalScore >= 21 && totalScore <= 25) {
                kategoriScore = 4;
            } else if (totalScore >= 26 && totalScore <= 31) {
                kategoriScore = 5;
            } else {
                kategoriScore = -1;
            }

            switch (kategoriScore) {
                case 0:
                    kodeVibeMessage = "Kamu tipe 'pengagum diam-diam'. MenFess-mu jarang, tapi kalau muncul bikin kaget.";
                    break;
                case 1:
                    kodeVibeMessage = "Kamu tipe 'semi-aktif'. Kadang muncul dengan kode, kadang ngilang.";
                    break;
                case 2:
                    kodeVibeMessage = "Kamu tipe 'suka bikin penasaran'. MenFess-mu bikin orang mikir, tapi kadang bikin bingung.";
                    break;
                case 3:
                    kodeVibeMessage = "Kamu tipe 'suka bikin drama'. MenFess-mu bikin orang penasaran, tapi terlalu banyak drama.";
                    break;
                case 4:
                    kodeVibeMessage = "Kamu tipe 'suka bikin orang mikir'. MenFess-mu bikin orang penasaran, tapi kadang bikin mereka mikir";
                    break;
                case 5:
                    kodeVibeMessage = "Kamu tipe 'rahasia'. MenFess-mu jarang muncul, tapi kalau muncul bikin orang penasaran siapa yang kirim.";
                    break;
                default:
                    break;
            }
        }
        
        System.out.println(kodeVibeMessage + " : via " + modeOutputText);
        System.out.println("--------------------------------------------------------------------------------");

        // Opsi Pengiriman Fess (Sub-Task 4)
        System.out.println("\nApakah kamu ingin fess-mu dikirimkan sekarang, atau dijadwalkan untuk masa depan?");
        int pilihanPengiriman = -1;

        while (pilihanPengiriman < 0 || pilihanPengiriman > 1) {
            System.out.print("Pilih mode pengiriman fess (0 = sekarang, 1 = masa depan): ");
            pilihanPengiriman = scanner.nextInt();
            if (pilihanPengiriman != 0 && pilihanPengiriman != 1) {
                System.out.println("Pilihan tidak valid. Harap masukkan 0 atau 1.");
            }
        }
        scanner.nextLine();

        // Untuk mendapatkan waktu saat ini dari sistem
        LocalDateTime waktuSekarang = LocalDateTime.now();
        // Membuat formatter untuk format output yang diinginkan
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, 'pukul' HH:mm:ss");
        
        if (pilihanPengiriman == 0) { 
            waktuPengirimanFinal = waktuSekarang; // Untuk opsi pengiriman Sekarang
            System.out.println("fess dikirimkan sekarang pada: " + waktuPengirimanFinal.format(formatter));
        } else { // Untuk opsi kirim di Masa Depan
            System.out.print("Masukkan jumlah detik dari sekarang hingga fess dikirim : ");
            long tambahanDetik = scanner.nextLong(); 
            scanner.nextLine(); 

            waktuPengirimanFinal = waktuSekarang.plusSeconds(tambahanDetik); 
            System.out.println("Fess akan dikirimkan pada: " + waktuPengirimanFinal.format(formatter)); 
        }
        System.out.println("--------------------------------------------------------------------------------");

        // Meminta input tambahan 'isiFess' (Sub-Task 5)
        System.out.print("\nKamu bisa ketikkan isi 'fess' yang akan dikirim: ");
        isiFess = scanner.nextLine(); // Mengisi variabel isiFess

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("Detail Fess Anda:");
        System.out.println("Kode Vibe: " + kodeVibeMessage);
        System.out.println("Isi Fess: \"" + isiFess + "\""); 
        
        String formattedWaktuFinal = waktuPengirimanFinal.format(formatter); 
        if (pilihanPengiriman == 0) { // Jika pilihanPengiriman == 0 (sekarang)
             System.out.println("Fess dikirimkan sekarang pada: " + formattedWaktuFinal);
        } else { // Jika pilihanPengiriman == 1 (masa depan)
             System.out.println("Fess akan dikirimkan pada: " + formattedWaktuFinal);
        }
       
        System.out.println("--------------------------------------------------------------------------------");

        // Tugas Pemograman Lanjutan TP01
        String PilihMainLagi= "-1";
        while (true) {
            System.out.print("\nApakah kamu ingin melakukan quiz kembali? (0 = Berhenti, 1 = Lanjut): ");
            PilihMainLagi = scanner.nextLine();
            if (PilihMainLagi.equals("0") ) {
                lanjutPermainan = false;
                break;
            } else if (PilihMainLagi.equals("1")) {
                System.out.println("Memulai permainan baru ");
                break;
            } else {
                System.out.println("Pilihan tidak valid. Harap masukkan 0 atau 1.");
            }
        }
    } while (lanjutPermainan);
    
    System.out.println("Terimakasih telah melakukan permainan BurhanFess");
    System.out.println("kamu telah memainkan permainan sebanyak" + " " + permainanCount + " " + "kali" );
    
    // ascii art untuk menutup permainain, tambahan dari lanjutan TP01 
    System.out.println(" _____ _                 _ ");
    System.out.println("|_   _|_|__   _  _ _  _ | | _____ ");
    System.out.println("  | | | '_ \\ / _` | '_ \\| |/ / __| ");
    System.out.println("  | | | | | | (_| | | | |   <\\__ \\ ");
    System.out.println("  |_| |_| |_|\\__,_|_| |_|_|\\_\\___/ ");

    scanner.close();
    
    }
}