import static org.junit.Assert.*;
import org.junit.Test; 

public class primaTest {
    @Test
    public void test00() {
        int input = 5; 
        assertEquals (true, prima.isPrima(input));
    }

    @Test
    public void test01 () {
        boolean expected = false; 
        int input = 9; 
        assertEquals (false, prima.isPrima(input));
    }
    
}
