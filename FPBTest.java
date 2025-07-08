import static org.junit.Assert.*;
import org.junit.Test;

public class FPBTest {
    @Test
    public void testHitungFPB(){
        assertEquals(6, FPB.hitungFPB(54, 24));
        assertEquals(1, FPB.hitungFPB(17, 31));
        assertEquals(10, FPB.hitungFPB(100, 30));

    }
}
