package PracticeForTest.ExceptionS;

import java.io.FileReader;
import java.io.IOException;

public class throwsExample {
    void load() throws Exception{
        read();
    }
    void read() throws Exception{
        FileReader fr = new FileReader("bablu.txt");
    }

    public static void main(String[] args){
        throwsExample th = new throwsExample();
        try{
            th.load();
        }catch (IOException e ){
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println("Some other exception occurred"+e.getMessage());
        }finally {
            System.out.println("Execution completed");

        }
    }
}
