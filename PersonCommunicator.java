public class PersonCommunicator{
    //TODO implementasi class variable di sini
    private String name;
    private String ReceivedMessage;
    
    //TODO constructor
    public PersonCommunicator(String Nama)
    {
        this.name = Nama;
        this.ReceivedMessage = " ";
    }

    //TODO method kirim pesan
    public void SendMessage(PersonCommunicator SenderMsg, String Mssg)
    {
        System.out.print(this.name + " mengirimkan pesan untuk" + SenderMsg.GetName());
        SenderMsg.ReceivedMessage(Mssg);
    }
    //TODO method terima pesan
    public void ReceivedMessage(String message)
    {
        this.ReceivedMessage = message;
        System.out.println(this.name + " baru saja menerima pesan:" );
        System.out.println(this.ReceivedMessage);
    }
    //TODO method getter name
    public String GetName()
    {
        return this.name;
    }

    //TODO method getter pesan yang diterima
    public String GetMessage()
    {
        return this.ReceivedMessage;
    }
}