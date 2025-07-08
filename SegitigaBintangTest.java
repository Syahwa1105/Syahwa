import static org.junit.Assert.*;
import org.junit.Test; 

public class SegitigaBintangTest {
    @Test
    public void SegitigaBintang(){
        String actual = SegitigaBintang.segitiga(3);

        String expected=
        """
             *      
            ***   
           *****
                    """;
                            
                            

                         
  assertEquals(expected , actual);
    }


}
