import static org.junit.Assert.*;
import org.junit.Test;

public class FPBEuclidTest {
    @Test
    public void testHitungFPB(){
        assertEquals(6, FPBEuclid.hitungFPB(54, 24));
        assertEquals(1, FPBEuclid.hitungFPB(17, 31));
        assertEquals(10, FPBEuclid.hitungFPB(100, 30));

    }
}
