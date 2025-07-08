import static org.junit.Assert.*;
import org.junit.Test;

public class maximumSubrayyTest {
    @Test
    public void testpositif(){
        int[] input = { 1, 2, 3, 4, 5};
        int expected = 15;
        assertEquals(expected, maximumSubrayy.maxSubArray(input));

    }
    @Test
    public void testnegatif(){
        int[] input = {-5, -2, -3, -4, -5};
        int expected = -2; 
        assertEquals(expected, maximumSubrayy.maxSubArray(input));
    }

    @Test
    public void testMixedValues(){
        int [] input = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expected = 6;
        assertEquals(expected, maximumSubrayy.maxSubArray(input));
    }

    @Test
    public void testSingleElement(){
        int [] input = {10};
        int expected = 10;
        assertEquals(expected, maximumSubrayy.maxSubArray(input));
    }
}
