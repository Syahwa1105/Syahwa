import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestAgent {
    AgentCom AgentCommunicator1;
    AgentCom AgentCommunicator2;
    Message Msg;
    Message Msg2;
    Message Msg3;

    @Before
    public void setup()
    {
        AgentCommunicator1 = new AgentCom("Agen 1");
        AgentCommunicator2 = new AgentCom("Agen 2");
        Msg = new Message(AgentCommunicator1.GetName(), AgentCommunicator2.GetName(), "Halo");
        Msg2 = new Message(AgentCommunicator1.GetName(), AgentCommunicator2.GetName(), "Hi");
        Msg3 = new Message(AgentCommunicator1.GetName(), AgentCommunicator2.GetName(), "Bersiagalah!");
    }
    @Test
    public void TestSendMessage()
    {
        //TODO lengkapi method berikut ini untuk menguji proses send and receive
    }
}
