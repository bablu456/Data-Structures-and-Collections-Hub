package PracticeForTest.ExceptionS.TryWithResources;

import java.io.FileReader;
import java.io.IOException;

public class withTryWithResources {
    public static void main(String[] args){

        try(FileReader fr = new FileReader("Data.txt")){
            int data = fr.read();
            while(data != -1){
                System.out.println((char) data);
                data = fr.read();
            }
        }catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
        int x = 5/0;
    }
}
