package test.huffman;

import huffman.Hzip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Laurens on 7-3-2016.
 */
public class FilePercentages {

    public static final String FILE_NAME = "Temp.dat";
    public static final String ASCII = " !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
    private static Random random = new Random();
    public static final int BASE = 256, MAX = 1048576;

    public static void fillWithRandom(int size, FileOutputStream fileOutputStream){
        for (int i = 0; i < size; i++) {
            try {
                fileOutputStream.write(random.nextInt());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fillWithAscii(int size, FileOutputStream fileOutputStream){
        for (int i = 0; i < size; i++) {
            try {
                fileOutputStream.write(ASCII.charAt(random.nextInt(ASCII.length())));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void threeCharacters(int size, FileOutputStream fileOutputStream){
        for (int i = 0; i < size; i++) {
            try {
                fileOutputStream.write(ASCII.charAt(random.nextInt(3)+ASCII.indexOf('a')));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream;
            int current = BASE;
            while(current<=MAX){
                fileOutputStream = new FileOutputStream(FILE_NAME);
                fillWithAscii(current,fileOutputStream);
                Hzip.compress(FILE_NAME);
                printProgress("With all ascii",current);
                fileOutputStream.flush();
                fileOutputStream.close();
                fileOutputStream = new FileOutputStream(FILE_NAME);
                fillWithRandom(current,fileOutputStream);
                Hzip.compress(FILE_NAME);
                printProgress("With completely random bytes",current);
                fileOutputStream.flush();
                fileOutputStream.close();
                fileOutputStream = new FileOutputStream(FILE_NAME);
                threeCharacters(current,fileOutputStream);
                Hzip.compress(FILE_NAME);
                printProgress("With three characters",current);
                fileOutputStream.flush();
                fileOutputStream.close();
                current*=2;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printProgress(String description, long bytes){
        System.out.println(description);
        System.out.println("Original file size = " + bytes);
        File file = new File(FILE_NAME+".huf");
        long compressedSize = file.length();
        System.out.println("Compressed file size = " + compressedSize);
        double ratio = (double)compressedSize/bytes;
        double profit = (1-ratio)*100;
        System.out.println("We achieved a storage reduction of " + profit +"%");

    }
}
