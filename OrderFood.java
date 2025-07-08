public class OrderFood {
    public static void main(String[] args)
    {
        System.out.println("Selamat Datang di Restaurant TanpaArah");
        
        FoodData FoodData1 = new FoodData("Nasi Goreng", 5, 10000, "nasi", "telor", "bumbu");
        FoodData FoodData2 = new FoodData("Jus Mengkudu", 9, 12000, "mengkudu", "gula", "air");
        FoodData FoodData3 = new FoodData("Sate", 6, 20000, "ayam", "kacang", "kecap");
         
        System.out.println("============== Selamat datang di Restaurant Tanpa Arah ==============");
        
        //Check Availability
        System.out.println(FoodData1.getNama()+ " "+ FoodData1.checkAvail());
        //Check harga
        System.out.println(FoodData2.getNama()+": "+ FoodData2.totalHarga(3,50));
        //Pesan Makanan
        System.out.println("Stok "+ FoodData1.getNama()+": "+FoodData1.getStok());
        System.out.println(FoodData1.pesanMakanan("almond","gula"));       
        System.out.println(FoodData2.pesanMakanan("gula","telor"));
        System.out.println(FoodData3.pesanMakanan("ayam", "kacang"));
    }
}
