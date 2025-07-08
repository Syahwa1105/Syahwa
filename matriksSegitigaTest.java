import static org.junit.Assert.*;
import org.junit.Test;

public class matriksSegitigaTest {
    @Test
    public void testBuatSegitiga1(){
        int [][] result = matriksSegitiga.buatSegitiga(0);
        assertEquals(0, result.length);

    }
    @Test
    public void testBuatSegitigaDengan1(){
        int [][] result = matriksSegitiga.buatSegitiga(1);
        assertEquals(1, result.length);
        assertEquals(1, result[0].length);
    }

    @Test
    public void testBuatSegitigaDengan2(){
        int [][] result = matriksSegitiga.buatSegitiga(3);
        assertEquals(3, result.length);
        assertEquals(1, result[0].length);
        assertEquals(2, result[1].length);
        assertEquals(3, result[2].length);

    }
}
