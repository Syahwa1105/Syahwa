public class AgentCom {
    //TODO implementasi class variabel
    private String name;
    private Message message; 

    //TODO constructor 
    public AgentCom(String Nama)
    {
        this.name = Nama;
        this.message = null;
    }
    
    //TODO getter method untuk mendapatkan nama agentCom
    public String GetName()
    {
        return this.name;
    }
    //TODO method untuk mengirim pesan
    public void SendMessage(AgentCom Receiver, Message Mssg)
    {
        System.out.println("===== Message delivered =====");
        Receiver.ReceivedMessage(Mssg);
        System.out.println("==================");
    }
    //TODO method untuk menerima pesan
    public void ReceivedMessage(Message Scm)
    {
        this.message = Scm;
        System.out.println("Hello" + this.name + "You got a message:\r");
        System.out.print("[");
        char[][] content = this.message.getBodyMessage().getContent();
        for(int i = 0; i< content.length; i++){
            System.out.print("[");
            for(int j = 0; j< content.length; i++){
                System.out.print(content[i][j]);
                if (j < content[i].length - 1){
                    System.out.print(", ");

                }

            }
            System.out.print("] ");
        }
    }
    //TODO method untuk mendapatkan pesan 
    public Message GetMessage()
    {
        return this.message;
    }

    



}
