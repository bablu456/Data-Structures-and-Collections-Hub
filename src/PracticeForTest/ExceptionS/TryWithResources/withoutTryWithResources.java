package PracticeForTest.ExceptionS.TryWithResources;

import java.io.FileReader;
import java.io.IOException;

public class withoutTryWithResources {
    public static void main(String[] args) {
        FileReader fr = null;

        try {
            fr = new FileReader("data.txt");
            int data = fr.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("General Exception: " + e.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
