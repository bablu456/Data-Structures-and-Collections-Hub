package Comparator_Conparable;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

public class test  {
    public static void main(String[] args) {
        System.out.println("Hello World");

        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        System.out.println(l.remove(Integer.valueOf(2)));
        System.out.println(l);
    }
}
