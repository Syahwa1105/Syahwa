
public class FoodData{

    //TODO buatlah class variables sesuai class diagram pada soal
    //
    private String namaMakanan;
    private int stokGudang;
    private int hargaSatuan;
    private String[] kandunganBahan = new String[3];

    //TODO buatlah constructor sesuai dengan class diagram pada soal
    public FoodData(String name , int stok, int price, String bahan1, String bahan2, String bahan3)
    { this. namaMakanan = name;
        this. stokGudang = stok;
        this. hargaSatuan = price;
        this. kandunganBahan[0] = bahan1;
        this. kandunganBahan[1] = bahan2;
        this. kandunganBahan[2]= bahan3;

    }
    public String getNama(){
        return namaMakanan;
    }
    public int getStok(){
        return stokGudang;
    }
    public int getHarga(){
        return hargaSatuan ;
    }
    public String[] getIngredients()
    {
        return kandunganBahan;
    }

    //TODO buatlah method untuk menghitung total harga sesuai ketentuan dalam soal
    public int totalHarga(int qty, int diskon)
    {
        double diskonBaru = (double) diskon;

        int harga = getHarga();

        int total = (harga * qty) - (int) ((harga * qty)*(diskonBaru/100.0));

        return total;
    }
     //TODO buatlah method untuk memeriksa ketersediaan sesuai ketentuan dalam soal
    public String checkAvail()
    {
        int stock = getStok();
        if (stock > 0){
            return "Tersedia";

        }
        else{
            return "Tidak tersedia";
        }
    }

    //TODO buatlah method untuk pemesanan makanan sesuai ketentuan dalam soal    
    public String pesanMakanan(String bahanAlergi1, String bahanAlergi2)
    {
        int komposisi = cariKomposisi(0, 0, bahanAlergi1, bahanAlergi2);
        int stock = getStok();
        if (stock> 0 && komposisi < 2){
            return "Pesanan sukses";

        }else {
            return "Pembelian gagal";
        }
    }

    //TODO buatlah method untuk pencarian alergen dalam komposisi sesuai ketentuan dalam soal
    public int cariKomposisi(int totalFound, int index, String bahanAlergen1, String bahanAlergen2)
    {    
        if (index > 2){
            return totalFound;

        }
        else {
            if (kandunganBahan[index].equals(bahanAlergen1) || kandunganBahan[index].equals(bahanAlergen2)){
                return cariKomposisi(totalFound+1, index+1, bahanAlergen1, bahanAlergen2);

            }
            return cariKomposisi(totalFound, index+1, bahanAlergen1, bahanAlergen2);
        }
       
    }
    
}