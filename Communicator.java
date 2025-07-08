public class Communicator {
    public static void main(String[] args)
    {
        //create agent
        AgentCom Ddp7 = new AgentCom("Udin");
        AgentCom Ddp8 = new AgentCom("Ucup" );
        //create message
        Message Scm = new Message(Ddp7.GetName(), Ddp8.GetName(), "Halo apa kabar?");

        Ddp7.SendMessage(Ddp8,Scm);
        System.out.println("==================");
        
    }
}
