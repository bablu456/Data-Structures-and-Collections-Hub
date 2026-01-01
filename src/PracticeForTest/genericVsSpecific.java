package PracticeForTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class genericVsSpecific {

    static void readData() throws Exception{
        FileReader fr = new FileReader("data.txt");

        int data = fr.read();
        while(data != -1){
            System.out.println((char) data);
            data = fr.read();
        }
    }

    static void load() throws IOException, SQLException,ClassNotFoundException{
        FileReader fr = new FileReader("data.txt");

        int data = fr.read();
        while(data != -1){
            System.out.println((char) data);
            data = fr.read();
        }
    }
    public static void main(String[] args) {
        


    }
}
