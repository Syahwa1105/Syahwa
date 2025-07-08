import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Month; // Import Month untuk LocalDate / LocalDateTime

public class BurhanFess {

    // Deklarasi Scanner di tingkat kelas agar bisa diakses oleh semua method
    public static Scanner scanner = new Scanner(System.in);

    // Variabel untuk menyimpan count permainan
    public static int gameCount = 0;
    // Variabel baru untuk menyimpan jumlah kesalahan input
    public static int errorCount = 0;


    // Tambahan Menggunakan Array untuk menyimpan variabel fess
    public static String[] fessArray= new String[5]; 
    public static int jumlahFess; 

    // Variabel untuk menyimpan data fess terjadwal (maks 5)
    public static String fessContent1 = null; 
    public static String fessVibe1 = null;
    public static LocalDateTime fessTime1 = null;

    public static String fessContent2 = null;
    public static String fessVibe2 = null;
    public static LocalDateTime fessTime2 = null;

    public static String fessContent3 = null;
    public static String fessVibe3 = null;
    public static LocalDateTime fessTime3 = null;

    public static String fessContent4 = null;
    public static String fessVibe4 = null;
    public static LocalDateTime fessTime4 = null;

    public static String fessContent5 = null;
    public static String fessVibe5 = null;
    public static LocalDateTime fessTime5 = null;

    public static int scheduledFessCount = 0; // Untuk melacak berapa banyak fess yang berhasil dijadwalkan

    public static void main(String[] args) {
        displayHeader();

        boolean playAgain = true;
        while (playAgain) {
            gameCount++;
            runBurhanFessApp();
            playAgain = askPlayAgain();
        }

        displayGameStats();
        displayClosingArt();

        scanner.close(); 
    }


    public static void displayHeader() {
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
    }

    public static void runBurhanFessApp() {
        // Pemilihan Mode Output Interpretasi
        int pilihanMode = getModeChoice();
        String modeOutputText = (pilihanMode == 0) ? "If-Else" : "Switch-Case";

        // Menerima Input dan Menghitung Skor
        int totalScore = askQuestionsAndCalculateScore();

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("Quiz selesai!");
        System.out.println("Total skor Anda adalah: " + totalScore);
        System.out.println("--------------------------------------------------------------------------------");

        // Mengeluarkan Output Sesuai kodeVibe
        String kodeVibeMessage = getVibeResult(totalScore, pilihanMode);
        System.out.println("\nInterpretasi 'kode vibe' Anda:");
        System.out.println(kodeVibeMessage + " : via " + modeOutputText);
        System.out.println("--------------------------------------------------------------------------------");

        // Pemilihan Mode Pengiriman Fess 
        int pilihanPengiriman = getDeliveryModeChoice(); // Meminta pengguna memilih mode pengiriman

        if (pilihanPengiriman == 0) { // Jika pengguna memilih '0' (Kirim sekarang)
            LocalDateTime waktuPengirimanFinal = waktuSekarang();
            String isiFess = getInputFessContent(); // Dapatkan isi fess
            displayFessDetails(kodeVibeMessage, isiFess, waktuPengirimanFinal); // Memanggil displayFessDetails
        } else { // Jika pengguna memilih '1' (Jadwalkan untuk masa depan)
            handleScheduledFessDelivery(kodeVibeMessage); // Panggil method penjadwalan fess
        }
        
        // Tambahan: Fitur Pencarian Fess Rekursif (Sub-Task 6)
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("Fitur Pencarian Fess (Rekursif):");
        System.out.print("Apakah Anda ingin mencari kata kunci di fess yang terjadwal? (ya/tidak): ");
        String wantToSearch = scanner.nextLine().trim();

        if (wantToSearch.equalsIgnoreCase("ya")) {
            if (scheduledFessCount == 0) {
                System.out.println("Belum ada fess yang terjadwal untuk dicari.");
            } else {
                System.out.print("Masukkan kata kunci yang ingin Anda cari: ");
                String searchKeyword = scanner.nextLine();
                boolean found = recursiveSearchFess(searchKeyword, 1); // Mulai pencarian dari fess pertama (indeks 1)

                if (found) {
                    System.out.println("Kata kunci '" + searchKeyword + "' ditemukan di setidaknya satu fess terjadwal!");
                } else {
                    System.out.println("Kata kunci '" + searchKeyword + "' tidak ditemukan di fess terjadwal manapun.");
                }
            }
        }
        System.out.println("--------------------------------------------------------------------------------");

        addMenfess();
    }

    // Digunakan untuk validasi input
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static int getModeChoice() {
        int pilihanMode = -1;
        String inputStr;
        while (true) { // Loop untuk validasi input
            System.out.print("\nPilih mode output interpretasi (0 = If-Else, 1 = Switch-Case): ");
            inputStr = scanner.nextLine();

            if (isNumeric(inputStr)) { // Periksa apakah input hanya angka
                int parsedInput = Integer.parseInt(inputStr);
                if (parsedInput == 0 || parsedInput == 1) {
                    pilihanMode = parsedInput;
                    break;
                } else {
                    System.out.println("Pilihan tidak valid. Harap masukkan 0 atau 1.");
                    errorCount++;
                }
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka (0 atau 1).");
                errorCount++;
            }
        }
        return pilihanMode;
    }


    public static int askQuestionsAndCalculateScore() {
        int totalScore = 0;
        String inputStr;

        // Pertanyaan 1: Validasi input "1" atau "0"
        while (true) {
            System.out.print("\nPertanyaan 1: Apakah Anda lebih sering menjadi pembaca daripada pembuat 'fess' di dunia maya? (Ketik 1 jika ya dan ketik 0 jika tidak): ");
            inputStr = scanner.nextLine();
            if (isNumeric(inputStr)) {
                int parsedInput = Integer.parseInt(inputStr);
                if (parsedInput == 1) {
                    totalScore += 1;
                    System.out.println("Skor bertambah +1.");
                    break;
                } else if (parsedInput == 0) {
                    break;
                } else {
                    System.out.println("Pilihan tidak valid. Harap masukkan 0 atau 1.");
                    errorCount++;
                }
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka (0 atau 1).");
                errorCount++;
            }
        }

        // Pertanyaan 2: Validasi input "ya" atau "tidak" (case-insensitive)
        while (true) {
            System.out.print("\nPertanyaan 2: Ketika ada isu hangat, apakah Anda cenderung ikut berkomentar atau memberikan reaksi? (Ketik 'ya' jika ya dan ketik 'tidak' jika tidak): ");
            inputStr = scanner.nextLine().trim(); // Trim untuk menghilangkan spasi di awal/akhir
            if (inputStr.equalsIgnoreCase("ya")) {
                totalScore += 2;
                System.out.println("Skor bertambah +2.");
                break;
            } else if (inputStr.equalsIgnoreCase("tidak")) {
                break;
            } else {
                System.out.println("Pilihan tidak valid. Harap masukkan 'ya' atau 'tidak'.");
                errorCount++;
            }
        }

        // Pertanyaan 3: Validasi input "1" atau "0"
        while (true) {
            System.out.print("\nPertanyaan 3: Apakah Anda suka membagikan 'fess' yang membuat orang lain bertanya-tanya atau menebak maksudnya? (Ketik 1 jika ya dan ketik 0 jika tidak): ");
            inputStr = scanner.nextLine();
            if (isNumeric(inputStr)) {
                int parsedInput = Integer.parseInt(inputStr);
                if (parsedInput == 1) {
                    totalScore += 4;
                    System.out.println("Skor bertambah +4.");
                    break;
                } else if (parsedInput == 0) {
                    break;
                } else {
                    System.out.println("Pilihan tidak valid. Harap masukkan 0 atau 1.");
                    errorCount++;
                }
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka (0 atau 1).");
                errorCount++;
            }
        }

        // Pertanyaan 4: Validasi input "ya" atau "tidak" (case-insensitive)
        while (true) {
            System.out.print("\nPertanyaan 4: Apakah Anda menikmati 'fess' yang memicu diskusi atau perdebatan seru, bahkan kadang kontroversial? (Ketik 'ya' jika ya dan ketik 'tidak' jika tidak): ");
            inputStr = scanner.nextLine().trim();
            if (inputStr.equalsIgnoreCase("ya")) {
                totalScore += 8;
                System.out.println("Skor bertambah +8.");
                break;
            } else if (inputStr.equalsIgnoreCase("tidak")) {
                break;
            } else {
                System.out.println("Pilihan tidak valid. Harap masukkan 'ya' atau 'tidak'.");
                errorCount++;
            }
        }

        // Pertanyaan 5: Validasi input "1" atau "0"
        while (true) {
            System.out.print("\nPertanyaan 5: Apakah Anda merasa 'fess' yang Anda kirim seringkali memiliki makna tersembunyi atau butuh pemikiran mendalam? (Ketik 1 jika ya dan ketik 0 jika tidak): ");
            inputStr = scanner.nextLine();
            if (isNumeric(inputStr)) {
                int parsedInput = Integer.parseInt(inputStr);
                if (parsedInput == 1) {
                    totalScore += 16;
                    System.out.println("Skor bertambah +16.");
                    break;
                } else if (parsedInput == 0) {
                    break;
                } else {
                    System.out.println("Pilihan tidak valid. Harap masukkan 0 atau 1.");
                    errorCount++;
                }
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka (0 atau 1).");
                errorCount++;
            }
        }
        return totalScore;
    }


    public static String getVibeResult(int totalScore, int pilihanMode) {
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
                kategoriScore = -1; // Untuk skor di luar rentang
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
        return kodeVibeMessage;
    }

    public static LocalDateTime waktuSekarang() {
        return LocalDateTime.now();
    }

    public static int getDeliveryModeChoice() {
        int pilihanPengiriman = -1;
        String inputStr;
        while (true) {
            System.out.print("Pilih mode pengiriman fess (0 = sekarang, 1 = masa depan): ");
            inputStr = scanner.nextLine();

            if (isNumeric(inputStr)) {
                int parsedInput = Integer.parseInt(inputStr);
                if (parsedInput == 0 || parsedInput == 1) {
                    pilihanPengiriman = parsedInput;
                    break;
                } else {
                    System.out.println("Pilihan tidak valid. Harap masukkan 0 atau 1.");
                    errorCount++;
                }
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka (0 atau 1).");
                errorCount++;
            }
        }
        return pilihanPengiriman;
    }

    // Method untuk menghitung waktu di masa depan
    public static LocalDateTime calculateFutureTime(LocalDateTime currentTime, long additionalSeconds) {
        // Menggunakan method bawaan LocalDateTime.plusSeconds()
        return currentTime.plusSeconds(additionalSeconds);
    }

    // Method tambahan untuk Sub-Task 5
    // Method untuk handle penjadwalan fess tanpa array
    public static void handleScheduledFessDelivery(String kodeVibeMessage) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, 'pukul' HH:mm:ss");
        LocalDateTime currentTime = waktuSekarang();

        System.out.println("Waktu sekarang: " + currentTime.format(formatter));

        int numFessToSchedule = -1;
        String inputStr;
        while (true) {
            System.out.print("Berapa banyak fess yang ingin kamu jadwalkan? (1-5): ");
            inputStr = scanner.nextLine();
            if (isNumeric(inputStr)) {
                int parsedInput = Integer.parseInt(inputStr);
                if (parsedInput >= 1 && parsedInput <= 5) {
                    numFessToSchedule = parsedInput;
                    break;
                } else {
                    System.out.println("Jumlah fess tidak valid. Harap masukkan angka antara 1 dan 5.");
                    errorCount++;
                }
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                errorCount++;
            }
        }
        System.out.println("--------------------------------------------------------------------------------");

        // Mereset variabel fess terjadwal untuk sesi penjadwalan baru
        resetScheduledFessVariables();

        for (int i = 1; i <= numFessToSchedule; i++) {
            long delaySeconds = -1;
            while (true) {
                System.out.print("Masukkan delay fess #" + i + " (detik): ");
                inputStr = scanner.nextLine();
                if (isNumeric(inputStr)) {
                    long parsedInput = Long.parseLong(inputStr);
                    if (parsedInput >= 0) {
                        delaySeconds = parsedInput;
                        break;
                    } else {
                        System.out.println("Jumlah detik tidak valid. Harap masukkan angka positif atau nol.");
                        errorCount++;
                    }
                } else {
                    System.out.println("Input tidak valid. Harap masukkan angka.");
                    errorCount++;
                }
            }

            LocalDateTime scheduledTime = calculateFutureTime(currentTime, delaySeconds);
            String fessContent = getInputFessContent(); 

            addOrInsertScheduledFess(fessContent, kodeVibeMessage, scheduledTime);
        }

        System.out.println("\nFess berhasil dijadwalkan!");
        System.out.println("\n--- Daftar Fess Terjadwal (Terurut) ---");
        displayAllScheduledFessDetails();
    }

    // Method baru untuk Sub-Task 5
    public static void addOrInsertScheduledFess(String content, String vibe, LocalDateTime time) {
        int insertIndex = scheduledFessCount; 
        for (int i = 0; i < scheduledFessCount; i++) {
            LocalDateTime existingTime = getFessTimeByIndex(i + 1);
            if (time.isBefore(existingTime)) {
                insertIndex = i;
                break;
            }
        }

        if (scheduledFessCount < 5) { 
            for (int i = scheduledFessCount; i > insertIndex; i--) {
                setFessByIndex(i + 1, getFessContentByIndex(i), getFessVibeByIndex(i), getFessTimeByIndex(i));
            }
            scheduledFessCount++;
        } else { 
            LocalDateTime slowestCurrentTime = getFessTimeByIndex(5);
            if (time.isAfter(slowestCurrentTime) || time.isEqual(slowestCurrentTime)) {
                return;
            }
            for (int i = 4; i > insertIndex; i--) { 
                 setFessByIndex(i + 1, getFessContentByIndex(i), getFessVibeByIndex(i), getFessTimeByIndex(i));
            }
        }
        setFessByIndex(insertIndex + 1, content, vibe, time);
    }

    // Method baru untuk Sub-Task 5
    // Method bantu untuk mendapatkan dan mengatur detail fess berdasarkan indeks (berbasis 1 untuk kemudahan membaca/pemetaan)
    public static String getFessContentByIndex(int index) {
        switch (index) {
            case 1: return fessContent1;
            case 2: return fessContent2;
            case 3: return fessContent3;
            case 4: return fessContent4;
            case 5: return fessContent5;
            default: return null; 
        }
    }

    // Method baru untuk Sub-Task 5
    public static String getFessVibeByIndex(int index) {
        switch (index) {
            case 1: return fessVibe1;
            case 2: return fessVibe2;
            case 3: return fessVibe3;
            case 4: return fessVibe4;
            case 5: return fessVibe5;
            default: return null; 
        }
    }

    // Method baru untuk Sub-Task 5
    public static LocalDateTime getFessTimeByIndex(int index) {
        switch (index) {
            case 1: return fessTime1;
            case 2: return fessTime2;
            case 3: return fessTime3;
            case 4: return fessTime4;
            case 5: return fessTime5;
            default: return null; 
        }
    }

    // Method baru untuk Sub-Task 5
    public static void setFessByIndex(int index, String content, String vibe, LocalDateTime time) {
        switch (index) {
            case 1: fessContent1 = content; fessVibe1 = vibe; fessTime1 = time; break;
            case 2: fessContent2 = content; fessVibe2 = vibe; fessTime2 = time; break;
            case 3: fessContent3 = content; fessVibe3 = vibe; fessTime3 = time; break;
            case 4: fessContent4 = content; fessVibe4 = vibe; fessTime4 = time; break;
            case 5: fessContent5 = content; fessVibe5 = vibe; fessTime5 = time; break;
            default: break; 
        }
    }

    // Method baru untuk Sub-Task 5
    // Mereset semua variabel fess terjadwal
    public static void resetScheduledFessVariables() {
        fessContent1 = null; fessVibe1 = null; fessTime1 = null;
        fessContent2 = null; fessVibe2 = null; fessTime2 = null;
        fessContent3 = null; fessVibe3 = null; fessTime3 = null;
        fessContent4 = null; fessVibe4 = null; fessTime4 = null;
        fessContent5 = null; fessVibe5 = null; fessTime5 = null;
        scheduledFessCount = 0;
    }

    // Method baru untuk Sub-Task 5
    // Method untuk menampilkan detail semua fess yang terjadwal
    public static void displayAllScheduledFessDetails() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, 'pukul' HH:mm:ss");

        for (int i = 1; i <= scheduledFessCount; i++) { // Loop hanya sebanyak fess yang terjadwal
            // Pastikan data tidak null sebelum ditampilkan (walaupun harusnya sudah terisi jika scheduledFessCount > 0)
            if (getFessTimeByIndex(i) != null) {
                System.out.println("Fess: \"" + getFessContentByIndex(i) + "\"");
                System.out.println("Vibe: " + getFessVibeByIndex(i));
                System.out.println("Waktu Pengiriman: " + getFessTimeByIndex(i).format(formatter));
                System.out.println("--------------------------------------------------------------------------------");
            }
        }
        if (scheduledFessCount == 0) {
            System.out.println("Tidak ada fess yang berhasil dijadwalkan.");
            System.out.println("--------------------------------------------------------------------------------");
        }
    }

    // Method untuk meminta input isi fess
    public static String getInputFessContent() {
        System.out.print("Kamu bisa ketikkan isi 'fess' yang akan dikirim: ");
        return scanner.nextLine();
    }

    // Method untuk menampilkan detail fess (untuk mode "kirim sekarang")
    // Disesuaikan agar tidak lagi menerima pilihanPengiriman jika tidak digunakan
    public static void displayFessDetails(String kodeVibeMessage, String isiFess, LocalDateTime waktuPengirimanFinal) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, 'pukul' HH:mm:ss");

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("Detail Fess Anda:");
        System.out.println("Kode Vibe: " + kodeVibeMessage);
        System.out.println("Isi Fess: \"" + isiFess + "\"");

        String formattedWaktuFinal = waktuPengirimanFinal.format(formatter);
        System.out.println("Fess dikirimkan sekarang pada: " + formattedWaktuFinal);
        System.out.println("--------------------------------------------------------------------------------");
    }

    // Method untuk menanyakan apakah pengguna ingin bermain lagi
    public static boolean askPlayAgain() {
        String pilihMainLagi;
        while (true) { // Loop untuk validasi input
            System.out.print("\nApakah kamu ingin melakukan quiz kembali? (0 = Berhenti, 1 = Lanjut): ");
            pilihMainLagi = scanner.nextLine().trim();
            if (pilihMainLagi.equals("0")) {
                return false;
            } else if (pilihMainLagi.equals("1")) {
                System.out.println("Memulai permainan baru ");
                return true; // Input valid dan pengguna ingin lanjut
            } else {
                System.out.println("Pilihan tidak valid. Harap masukkan 0 atau 1.");
                errorCount++; // (Memenuhi bagian Sub Task 3 TP2)
            }
        }
    }

    public static void displayGameStats() {
        System.out.println("Terimakasih telah melakukan permainan BurhanFess");
        System.out.println("kamu telah memainkan permainan sebanyak " + gameCount + " kali");
        System.out.println("Total kesalahan input: " + errorCount + " kali");
    }

    // Method untuk menampilkan ASCII art penutup
    public static void displayClosingArt() {
        System.out.println(" _____ _                 _ ");
        System.out.println("|_   _| |__   _  _ _  _ | | _____ ");
        System.out.println("  | | | '_ \\ / _` | '_ \\| |/ / __| ");
        System.out.println("  | | | | | | (_| | | | |   <\\__ \\ ");
        System.out.println("  |_| |_| |_|\\__,_|_| |_|_|\\_\\___/ ");

    }

    // Fungsi bantu 
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12) {
            return 0; // Bulan tidak valid
        }
        if (month == 2) { // Februari
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) { // April, Juni, September, November
            return 30;
        } else { // Januari, Maret, Mei, Juli, Agustus, Oktober, Desember
            return 31;
        }
    }

    // Sub-Task 6 
    public static boolean recursiveSearchFess(String keyword, int startIndex) {
        // Base case: jika startIndex sudah melebihi jumlah fess yang terjadwal, berhenti.
        if (startIndex > scheduledFessCount) {
            return false;
        }
        String currentContent = getFessContentByIndex(startIndex);
        if (currentContent != null && currentContent.toLowerCase().contains(keyword.toLowerCase())) {
            return true; // Ditemukan
        }
        // Recursive step: panggil diri sendiri untuk fess berikutnya
        return recursiveSearchFess(keyword, startIndex + 1);
    }

    // Praktikum Lanjutan TP2 
    public static void TP2Lanjutan (String[] args) {
        addMenfess();

    }
    public static void menuFess(String[] fessArray){
        while(true){
        System.out.println("==== MENU BURHANFESS ARRAY====");
        System.out.println("1. Tampilkan semua fess");
        System.out.println("2. Filter fess berdsarkan keyword");
        System.out.println("3. Mengakhiri program"); 
        System.out.println("Pilihan Anda: "); 
        int opsi = scanner.nextInt();
        scanner.nextLine();
        if (opsi == 1){
            System.out.println("📨 Daftar Fess: ");
            for (int i = 1 ; i <= jumlahFess ; i++){
                System.out.println(i + "."+ fessArray[i]);
            }
        }
        else if (opsi == 2){
            System.out.println("Masukkan keyword: ");
            String keyword = scanner.nextLine();
            Boolean ada = false;
            System.out.println("📨 Fess yang mengandung " + keyword );
            for (int i = 1 ; i <= jumlahFess ; i++){
                if (fessArray[i].contains(keyword)){
                    System.out.println(i+"."+ fessArray[i]);
                    ada=true;
                }
            }

            if(ada==false){
                System.out.println("Tidak ada fess yang mengandung keyword " + keyword + "."); 
            }
        }
        else{
            break;
        }
        } 

    }
    
    public static void addMenfess (){
       System.out.println("Berapa fess yang ingin Anda masukkan? (maks 5): ");
       jumlahFess = scanner.nextInt();
       scanner.nextLine();
       fessArray = new String[jumlahFess + 1];

       for (int i = 1; i <= jumlahFess ; i++) {
            System.out.println("Masukkan fess #" + i + ":"); 
            fessArray[i] = scanner.nextLine();
       }
       menuFess(fessArray);
    }
}
