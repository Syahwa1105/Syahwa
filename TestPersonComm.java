
import static org.junit.Assert.*;
import org.junit.Test;

public class TestPersonComm {
  @Test
  public void TestCommunication(){
    PersonCommunicator A = new PersonCommunicator("A");
    PersonCommunicator B = new PersonCommunicator("B");

    A.SendMessage(B, "Hai");
    assertEquals("Hai", B.GetMessage());

    B.SendMessage(A, "Halo");
    assertEquals("Halo", A.GetMessage());
  }
  
}
