package PracticeForTest.ExceptionS;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class checkedAndUncheked {
    public static void main(String[] args) {
        System.out.println("Hello World");
        FileReader fr = null;
        try {
            fr = new FileReader("Myfile.txt");

            int data = fr.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fr.read();
            }
//            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception caught" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception caught" + e.getMessage());
//            throw new RuntimeException(e);
        } finally {
            System.out.println("\nFinally block executed");
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println("IO exception caught while closing file" + e.getMessage());
//            fr.close();
            }
        }
    }
}
