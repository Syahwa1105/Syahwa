class User {
    private int id;         // ID unik untuk setiap user
    private String username; // Nama pengguna
    private String password; // Kata sandi pengguna

    // Constructor untuk inisialisasi objek User
    User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public int getId(){
        return this.id;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
}