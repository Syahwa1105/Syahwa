import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
    @Test 
    public void luasTest(){
        assertEquals(314.159, Calculator.hitungLuasLingkaran(10), 0.001);
    }
    
}
