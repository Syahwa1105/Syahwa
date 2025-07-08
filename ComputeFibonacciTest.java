import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class ComputeFibonacciTest {
    @Test
    public void testFib0(){
        assertEquals(0, ComputeFibonacci.fib(0));
    }


    @Test
    public void testFib1(){
        assertEquals(1, ComputeFibonacci.fib(1));
    }

    @Test
    public void testFib2(){
        assertEquals(1, ComputeFibonacci.fib(2));
    }
    
    @Test
    public void testFib5(){
        assertEquals(5, ComputeFibonacci.fib(5));
    }

    @Test
    public void testFib10(){
        assertEquals(55, ComputeFibonacci.fib(10));
    }

    @Test
    public void testFib15(){
        assertEquals(610, ComputeFibonacci.fib(15));
    }   
}
