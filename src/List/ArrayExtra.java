package List;

import java.util.ArrayList;
import java.util.Arrays;
import  java.util.List;
public class ArrayExtra {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        System.out.println(list.getClass().getName());

        List<String> list1 = Arrays.asList("Bablu", "Kallu", "Challu");
        System.out.println(list1.getClass().getName());

        String[] arry = {"A", "B", "C", "D"};

        List<String> list2 = Arrays.asList(arry);
        System.out.println(list2.getClass().getName());
        System.out.println(list2);

        List<Integer> list3 = List.of(1,2,3,4,5);
//        list3.set(1,33); // UnsupportedOperationException
        System.out.println(list3.getClass().getName());
        System.out.println(list3);

    }
}
