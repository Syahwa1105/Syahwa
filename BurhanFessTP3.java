import java.util.*; 
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 


public class BurhanFessTP3 {
    // Sub-Task 1: Scanner sebagai input global untuk seluruh program
    static Scanner scanner = new Scanner(System.in);

    // Sub-Task 1
    // Class User dengan atribut id, username, dan password


    // Sub-Task 1: ArrayList untuk menyimpan semua objek User yang terdaftar
    static User [] users;

    // Tambahan tugas pemograman lanjutan 
    static  Menfess [] menfess ;

    // Sub-Task 4: Matriks adjacensi untuk menyimpan hubungan 'follow' antar user
    // followMatrix[i][j] = 1 jika user dengan ID 'i' mem-follow user dengan ID 'j'. 0 jika tidak mem-follow
    static int[][] followMatrix;

    static User userLogin;

    static private int idx=0;

    // Main method
    public static void main(String[] args) {
        runProgram(); // Memulai eksekusi program utama
        scanner.close(); 
    }

    // Metode runProgram(): Mengandung alur utama aplikasi (koordinasi subtask)
    public static void runProgram() {
        System.out.println("Selamat datang kembali di dunia BurhanFess!");

        // SUB-TASK 1: Pendaftaran User
        System.out.print("Berapa user yang ingin didaftarkan? ");
        int n = Integer.parseInt(scanner.nextLine());
        users = new User[n];

        // Loop untuk mendaftarkan user sebanyak 'n' kali
        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan username user dengan ID " + i + ": ");
            String username = scanner.nextLine(); 
            System.out.print("Masukkan password user dengan ID " + i + ": ");
            String password = scanner.nextLine(); 

            // Membuat objek User baru dan menambahkannya ke ArrayList 'users'
            users[i] = new User(i, username, password);
            System.out.println(); 
        }

        // Sub-task 4: Inisialisasi followMatrix setelah jumlah user diketahui
        followMatrix = new int[n][n];

        // Menampilkan daftar user yang telah dibuat
        System.out.println("Telah dibuat " + n + " user dengan masing-masing ID dan username:");

    
        for (User user : users) {
            System.out.println(user.getId() + ". " + user.getUsername()); // Menampilkan ID dan username setiap user
        }
        System.out.println("\nSetelah itu, program akan lanjut ke bagian selanjutnya.\n");
    
        userLogin = loginMenfes(scanner);
        menuMenfes();

    }

    // tambahan tugas pemograman lanjutan TP3 (loginMenfes, kirimMenfes, menuMenfess)
    public static User loginMenfes (Scanner scanner){
        System.out.println("Silakan login untuk dapat menggunakan fitur kami ");
        while(true) {
            System.out.println("username: ");
            String username = scanner.nextLine();
            System.out.println("password: ");
            String password = scanner.nextLine();
        
        for (User user : BurhanFessTP3.users ) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)){
                System.out.println("Berhasil Login");
                return user;
            }
        }
    
        System.out.println("Maaf, username atau password yang anda masukkan salah. Tolong masukkan kembali dengan benar");
        }    
    }
    

    public static void menuMenfes(){
        while(true){
            System.out.println("Pilih salah satu menu kami! ");
            System.out.println("1. Follow pengguna lain");
            System.out.println("2. Mengirim menfess");
            System.out.println("3. Melihat daftar followers dan following");
            System.out.println("4. Logout");
            System.out.print("Masukkan pilihanmu: ");
            System.out.println(""); 
            int opsi = scanner.nextInt();
            scanner.nextLine();
    
            if (opsi == 1){
                handleFollowUsers();
            }
            else if (opsi == 2) {
                handleScheduledFessWithPrimitiveArray();
                

            }
            else if (opsi == 3){
                displayFollowerFollowingLists();

            }
            else if (opsi == 4){
                System.err.println("Anda berhasil logout! Terima kasih telah menggunakan program kami.");
                break;
            }
        }
    }

    // SUB-TASK 2: Metode untuk menangani penjadwalan fess
    public static void handleScheduledFessWithPrimitiveArray() {
        System.out.print("Berapa fess yang ingin dijadwalkan? (maks 5): ");
        // Membaca jumlah fess yang akan dijadwalkan
        int jumlahFess = Integer.parseInt(scanner.nextLine());
        // Membuat array primitif untuk menyimpan delay setiap fess
        int[] delays = new int[jumlahFess];

        // Mengambil waktu sistem saat ini
        LocalDateTime currentTime = LocalDateTime.now();
        // Mendefinisikan format tanggal dan waktu untuk tampilan output
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm:ss", new Locale("id", "ID")); 

        System.out.println("Waktu sekarang: " + currentTime.format(formatter));

        menfess = new Menfess[jumlahFess];

        // Loop untuk meminta input delay (dalam detik) untuk setiap fess
        for (int i = 0; i < jumlahFess; i++) {
            System.out.print("Masukkan delay fess #" + (i + 1) + " (detik): ");
            delays[i] = Integer.parseInt(scanner.nextLine()); // Membaca delay dan menyimpannya dalam array

            System.out.print("Masukkan pesan fess #" + (i + 1) + ": " );
            String pesan = scanner.nextLine();

            LocalDateTime scheduledTime = currentTime.plusSeconds(delays[i]);

            Menfess men = new Menfess(userLogin.getUsername(), scheduledTime.format(formatter), pesan);
            menfess[idx] = men;
            idx++;
        }

        // Untuk memastikan fess dikirim berdasarkan waktu delay terpendek terlebih dahul
        System.out.println("\nMengurutkan dan mengirimkan fess...");
        // Loop untuk menampilkan waktu pengiriman setiap fess setelah diurutkan
        for (int i = 0; i < menfess.length; i++) {
            
            // Menghitung waktu terjadwal dengan menambahkan delay ke currentTime
            LocalDateTime scheduledTime = currentTime.plusSeconds(delays[i]);
            System.out.println("Fess akan dikirim pada: " + menfess[i].tanggalKirim); // Menampilkan waktu terjadwal
            System.out.println("Dengan pesan: " + menfess[i].isiMenfess); 
        System.out.println(); 
    }// Baris kosong untuk kerapian output
    }

    // SUB-TASK 4: Metode untuk menangani fitur 'follow' antar user
    public static void handleFollowUsers() {
        System.out.print("Berapa kali akan dilakukan follow user? ");
        // Membaca jumlah aksi follow yang akan dilakukan
        int numFollowActions = Integer.parseInt(scanner.nextLine());

        // Loop untuk melakukan aksi follow sebanyak 'numFollowActions'
        for (int k = 1; k <= numFollowActions; k++) {
            String followerUsername;  // Username user yang akan mem-follow
            String followedUsername;  // Username user yang akan di-follow
            User followerUser = null; // Objek User yang mem-follow
            User followedUser = null; // Objek User yang di-follow

            // Loop validasi input untuk username 'follower'
            while (true) {
                System.out.print("Masukkan username " + k + " yang mem-follow: ");
                followerUsername = scanner.nextLine(); 
                followerUser = findUserByUsername(followerUsername); // Mencari objek User berdasarkan username
                if (followerUser == null) {
                    System.out.println("Username " + followerUsername + " tidak ditemukan! Silakan masukkan ulang.");
                } else {
                    break; // Jika user ditemukan, keluar dari loop validasi
                }
            }

            // Loop validasi input untuk username 'followed'
            while (true) {
                System.out.print("Masukkan username " + k + " yang di-follow: ");
                followedUsername = scanner.nextLine();
                followedUser = findUserByUsername(followedUsername); 
                if (followedUser == null) {
                    System.out.println("Username " + followedUsername + " tidak ditemukan! Silakan masukkan ulang.");
                } else if (followerUser.getId() == followedUser.getId()) {
                    // Validasi: user tidak bisa mem-follow diri sendiri
                    System.out.println("Tidak bisa mem-follow diri sendiri! Silakan masukkan ulang.");
                } else if (followMatrix[followerUser.getId()][followedUser.getId()] == 1) {
                    // Validasi: user sudah mem-follow user ini sebelumnya
                    System.out.println("User " + followerUser.getUsername() + " sudah mem-follow " + followedUser.getUsername() + "! Silakan masukkan ulang.");
                } else {
                    break; 
                }
            }

            // Melakukan operasi follow: mengubah nilai di followMatrix menjadi 1
            followMatrix[followerUser.getId()][followedUser.getId()] = 1;
            System.out.println("User " + followerUser.getUsername() + " berhasil mem-follow " + followedUser.getUsername() + "!");
            System.out.println();
        }

        // Menampilkan status semua hubungan follow yang ada saat ini
        System.out.println("Status follow saat ini:");
        // Loop melalui semua kemungkinan pasangan user
        for (int i = 0; i < users.length; i++) {
            for (int j = 0; j < users.length; j++) {
                // Jika ada hubungan follow (nilai 1 di matriks)
                if (followMatrix[i][j] == 1) {
                    System.out.println(users[i].getUsername() + " (ID " + i + ") mem-follow " + users[j].getUsername() + " (ID " + j + ")");
                }
            }
        }
        System.out.println();
    }

    public static User findUserByUsername(String username) {
        for (User user : users) {
            // Membandingkan username yang dicari dengan username user (case-insensitive)
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user; // Jika ditemukan, kembalikan objek User tersebut
            }
        }
        return null; // Jika tidak ditemukan setelah iterating semua user, kembalikan null
    }

    // SUBTASK 5: Menampilkan Daftar Follower dan Following
    public static void displayFollowerFollowingLists() {
        System.out.println("Daftar mutual burhanFess:"); 
        for (User currentUser : users) {
            System.out.println("== User: " + currentUser.getUsername() + ", ID: " + currentUser.getId() + " ==");

            // List untuk menyimpan username follower dan following
            ArrayList<String> followers = new ArrayList<>();
            ArrayList<String> following = new ArrayList<>();

            // Menemukan Followers
            for (int i = 0; i < users.length; i++) {
                if (followMatrix[i][currentUser.getId()] == 1) {
                    followers.add(users[i].getUsername()); 
                }
            }

            // Menemukan Following
            for (int j = 0; j < users.length; j++) {
                if (followMatrix[currentUser.getId()][j] == 1) {
                    following.add(users[j].getUsername()); 
                }
            }

            // Menampilkan daftar Followers
            System.out.println("Followers:");
            if (followers.isEmpty()) {
                System.out.println("- Pengguna belum memiliki followers"); 
            } else {
                for (String followerName : followers) {
                    System.out.println("- " + followerName); 
                }
            }

            // Menampilkan daftar Following
            System.out.println("Following:");
            if (following.isEmpty()) {
                System.out.println("- Pengguna belum mem-follow siapapun"); 
            } else {
                for (String followingName : following) {
                    System.out.println("- " + followingName); 
                }
            }
            System.out.println(); 
        }
    }

    // SUB-TASK 6: Fitur Unfollow User (KREASI)
    public static void handleUnfollowUsers() {
        System.out.println("\n===== Unfollow User =====");
        System.out.println("Apakah Anda ingin melakukan unfollow user? (ya atau tidak) ");
        String konfirmasi = scanner.nextLine().trim().toLowerCase();

        // jika memilih tidak
        if (!konfirmasi.equals("ya")) {
            System.out.println("Proses unfollow dibatalkan.");
            return; // Keluar dari metode handleUnfollowUsers
        }

        System.out.print("Berapa kali akan dilakukan unfollow user? ");
        // Untuk membaca jumlah aksi unfollow yang akan dilakukan
        int numUnfollowActions = Integer.parseInt(scanner.nextLine());

        // Loop untuk melakukan aksi unfollow sebanyak 'numUnfollowActions' kali
        for (int k = 1; k <= numUnfollowActions; k++) {
            String unfollowerUsername;  
            String unfollowedUsername;  
            User unfollowerUser = null; 
            User unfollowedUser = null; 

            // Loop validasi input untuk username 'unfollower'
            while (true) {
                System.out.print("Masukkan username " + k + " yang meng-unfollow: ");
                unfollowerUsername = scanner.nextLine(); 
                unfollowerUser = findUserByUsername(unfollowerUsername); // Mencari objek User berdasarkan username
                if (unfollowerUser == null) {
                    System.out.println("Username " + unfollowerUsername + " tidak ditemukan! Silakan masukkan ulang.");
                } else {
                    break; 
                }
            }

            // Loop validasi input untuk username 'unfollowed'
            while (true) {
                System.out.print("Masukkan username " + k + " yang di-unfollow: ");
                unfollowedUsername = scanner.nextLine();
                unfollowedUser = findUserByUsername(unfollowedUsername); // Mencari objek User berdasarkan username
                if (unfollowedUser == null) {
                    System.out.println("Username " + unfollowedUsername + " tidak ditemukan! Silakan masukkan ulang.");
                } else if (unfollowerUser.getId() == unfollowedUser.getId()) {
                    System.out.println("Tidak bisa meng-unfollow diri sendiri! Silakan masukkan ulang.");
                } else if (followMatrix[unfollowerUser.getId()][unfollowedUser.getId()] == 0) {
                    System.out.println("User " + unfollowerUser.getUsername() + " belum mem-follow " + unfollowedUser.getUsername() + "! Tidak bisa di-unfollow. Silakan masukkan ulang.");
                } else {
                    break; 
                }
            }

            // Melakukan operasi unfollow
            followMatrix[unfollowerUser.getId()][unfollowedUser.getId()] = 0;
            System.out.println("User " + unfollowerUser.getUsername() + " berhasil meng-unfollow " + unfollowedUser.getUsername() + "!");
            System.out.println();
        }

        // Menampilkan kembali status follow setelah unfollow untuk menunjukkan perubahan
        System.out.println("Status follow terbaru setelah unfollow:");
        boolean anyFollowingRelationLeft = false;
        for (int i = 0; i < users.length; i++) {
            for (int j = 0; j < users.length; j++) {
                if (followMatrix[i][j] == 1) {
                    System.out.println(users[i].getUsername() + " (ID " + i + ") mem-follow " + users[j].getUsername()+ " (ID " + j + ")");
                    anyFollowingRelationLeft = true;
                }
            }
        }
        if (!anyFollowingRelationLeft) {
             System.out.println("Tidak ada hubungan follow yang tersisa."); 
        }
        System.out.println();
    }
}