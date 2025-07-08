import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class SegitigaBintangSikuSikuTest {
    @Test
    public void test00() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        // Penggujian method yang mencetak ke layar
        System.out.println("0");
        System.out.println("12");
        System.out.println("345");
        System.out.println("6789");


        baos.flush();
        String whatWasPrinted = new String(baos.toByteArray());
        String[] linesOfOutput = whatWasPrinted.split(System.getProperty("line.separator"));

        // Cara pengujian
        assertEquals(4, linesOfOutput.length); // check jumlah baris
        assertEquals("0", linesOfOutput[0]); // cek per baris 0
        assertEquals("12", linesOfOutput[1]); // cek per
        assertEquals("345", linesOfOutput[2]);
        assertEquals("6789", linesOfOutput[3]);
    }
}