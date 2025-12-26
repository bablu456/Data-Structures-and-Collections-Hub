package Map.Practice;

import java.util.*;

public class MapintoList {
    public static void main(String[] args){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Apple");
        map.put(2,"Banana");
        map.put(3,"Orange");
        List<Student>  list = new ArrayList<>(map.keySet().stream().map(key -> new Student(key, map.get(key))).toList());

        System.out.println(list);
    }
}
