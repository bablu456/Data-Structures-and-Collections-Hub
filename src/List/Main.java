package List;

import java.util.*;
class StringLengthComparator implements Comparator<String>{
    @Override
    public int compare(String s1,String s2){
        return s1.length() - s2.length();
    }
}
class MyComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer a, Integer b){
        return b - a; // Descending order
    }
}
// o1    o2
// "ok" "Bye"

public class Main {
    public static void main(String[] args){
//        List<Integer> list = new ArrayList<>();
//        list.add(4);
//        list.add(2);
//        list.add(3);
////        list.remove(Integer.valueOf(1));
//        System.out.println(list);
//        Collections.sort(list);
//        list.sort(new MyComparator());
//        System.out.println(list);
        List<String> words = Arrays.asList("Bab", "Kallu", "Challu", "Dabluuu");
//        words.sort(a,b) ->a.le;
        System.out.println(words);


    }
}
