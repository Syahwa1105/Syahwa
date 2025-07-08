import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class FoodTest{
         
    FoodData FoodData1;
    FoodData FoodData2;
    FoodData FoodData3;

    @Before
    public void Setup()
    {
      FoodData1 = new FoodData("Nasi Uduk", 3, 10000, "nasi", "santan", "telur");
      FoodData2 = new FoodData("Jus Mangga", 0, 5000, "air", "mangga", "susu");
      FoodData3 = new FoodData("Ketoprak", 2, 5000, "ketupat", "kacang", "kecap");
    }

   @Test
   public void getterTest()
   {
      // Uji method getter. 
      //TODO lengkapi method ini untuk menguji semua method getter yang ada. 
      assertEquals("Nasi Uduk", FoodData1.getNama());
      assertEquals(10000, FoodData1.getHarga()); 
      assertEquals(3, FoodData1.getStok());

   }
   @Test
   public void totalHargaTest()
   {
      //Uji total harga dengan nilai qty = 2 dan diskon 50%
      assertEquals(10000, FoodData1.totalHarga(2,50));
   }
   @Test
   public void checkAvailTest()
   {
      //Uji availability untuk method checkAvail
      //TODO lengkapi 
      assertEquals("Tersedia", FoodData1.checkAvail());
   }

   @Test
   public void pesanMakananTest()
   {
      //Uji kasus pemesanan makanan sesuai dengan ketentuan pada soal
     //TODO Lengkapi di sini
     assertEquals("Pembelian gagal", FoodData1.pesanMakanan("nasi", "santan"));
   }
   
}
