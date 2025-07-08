import static org.junit.Assert.*;
import org.junit.Test;

public class PersegiPanjangTest {
    @Test 
    public void testHitungLuas(){
        assertEquals(20, PersegiPanjang.hitungLuas(4,5));
    }

    public void testHitungKeliling(){
        assertEquals(18, PersegiPanjang.hitungKeliling(4, 5));
    }
}
