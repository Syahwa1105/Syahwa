public class KomunikasiDuaArah{
    public static void main(String[] args)
    {
        PersonCommunicator Aa= new PersonCommunicator("Babidi");
        PersonCommunicator Bb = new PersonCommunicator("Buu");
        Aa.SendMessage(Bb, "Kita akan menguasai dunia");
        Bb.SendMessage(Aa, "Baiklah tuanku");
    }
}