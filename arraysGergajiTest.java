import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class arraysGergajiTest {
    @Test
    public void arraysGergaji() throws IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        
        int n = 15; 
        int[][] triangle = new int[n][];
        int size = 1;
        for (int i = 0; i<triangle.length; i = i + size++){
            arraysGergaji.createColumnPerRow(triangle,i,size);
        }
        arraysGergaji.isiAngka(triangle);
        arraysGergaji.printMatrix(triangle);

        baos.flush();
        String whatWasPrinted = new String(baos.toByteArray());
        String[] linesOfOutput = whatWasPrinted.split(System.getProperty("line.separator"));


        assertEquals(15, linesOfOutput.length);
        assertEquals("  0", linesOfOutput[0]);
        assertEquals("  1", linesOfOutput[1]);
        assertEquals("  2  5", linesOfOutput[2]);
        assertEquals("  3", linesOfOutput[3]);
        assertEquals("  4  6", linesOfOutput[4]);
        assertEquals("  5  7  5", linesOfOutput[5]);
        assertEquals("  6", linesOfOutput[6]);
        assertEquals("  7  8", linesOfOutput[7]);
        assertEquals("  8  9  6", linesOfOutput[8]);
        assertEquals("  9  0  7  1", linesOfOutput[9]);
        assertEquals("  0", linesOfOutput[10]);
        assertEquals("  1  1", linesOfOutput[11]);
        assertEquals("  2  2  8", linesOfOutput[12]);
        assertEquals("  3  3  9  2", linesOfOutput[13]);
        assertEquals("  4  4  0  3  4", linesOfOutput[14]);

    }


}