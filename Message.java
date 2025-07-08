
public class Message{
    //TODO implementasi class variable
    private HeaderMessage header;
    private BodyMessage body;
   
    //TODO constructor
    public Message(String sender, String receiver, String konten)
    {
        this.header = new headerMessage(sender, receiver);
        this.body = new bodyMessage(konten); 
    }
    //TODO mendapatkan header dari sebuah Message
    public headerMessage getHeaderMessage()
    {
        return this.header;
    }
    {}
    //TODO mendapatkan body dari sebuah Message
    public bodyMessage getBodyMessage()
    {
        return this.body;
    }
}
class headerMessage{
    //TODO implementasi class variable
    private String sender;
    private String receiver;

   
    //TODO constructor
    public headerMessage(String sender, String receiver)
    {}
    //TODO untuk mendapatkan nama pengirim
    public String getSender()
    {
        return this.sender;
    }
    //TODO untuk mendapatkan nama penerima
    public String getReceiverName()
    {
        return this.receiver;
    }
}

class bodyMessage{
    //TODO implementasi class variable
    private char[][] content;

    //TODO constructor
    public bodyMessage(String mssg)
    {
        this.content = addMessage(mssg);
    }
    //TODO method untuk merubah pesan ke dalam bentuk array
    public char[][] addMessage(String mssg)
    {
        int length = mssg.length();
        int rows = mssg.length();
        char[][] result = new char[rows][4];

        for (int i = 0; i < length; i++){
            int row = i / 4;
            int col = i % 4;
            result[row][col] = mssg.charAt(i);

        }
        for (int i = length; i< rows * 4 ; i++){
            int row = i / 4;
            int col = i % 4;
            result[row][col] = ' ';

        }
       
       return result;
    }
    //TODO method untuk mendapatkan isi pesan
    public char[][] getContent()
    {
        return this.content;
    }
}