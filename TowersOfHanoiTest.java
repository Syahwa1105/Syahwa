import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class TowersOfHanoiTest {
    @Test
    public void test3disks(){
        assertEquals(11000, TowersOfHanoi.moveDisks(3, 'A', 'B', 'C',0));
    }
    
    @Test
    public void test4disks(){
        assertEquals(26000, TowersOfHanoi.moveDisks(4, 'A', 'B', 'C',0));
    }
    

    @Test
    public void test7disks(){
        assertEquals(247000, TowersOfHanoi.moveDisks(7, 'A', 'B', 'C',0));
    }
    
}
