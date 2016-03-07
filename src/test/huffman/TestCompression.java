package test.huffman;

import huffman.Hzip;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Laurens on 7-3-2016.
 */
public class TestCompression  extends TestCase {

    public static final String FILE_NAME = "data/TestA.dat";
    private Support support = new Support();

    public void testCompression(){
        try {
            Hzip.compress(FILE_NAME);
            Hzip.uncompress(FILE_NAME+".huf");
            assertTrue(Arrays.equals(support.readFile(FILE_NAME),support.readFile(FILE_NAME+".uc")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
