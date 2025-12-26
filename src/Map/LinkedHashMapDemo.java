package Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args){
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(11,0.3f,true); // double linked list
        HashMap<String, Integer> hashMap = new HashMap<>();
        linkedHashMap.put("Orange", 10);
        linkedHashMap.put("Apple", 22);
        linkedHashMap.put("Banana", 30);


        linkedHashMap.get("Apple");
        linkedHashMap.get("Orange");


        for(Map.Entry<String, Integer> entry : linkedHashMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        HashMap<String, Integer> hashMap1 = new HashMap<>();
        LinkedHashMap linkedHashMap1 =new LinkedHashMap(hashMap1);
        hashMap1.put("Shubham", 91);
        hashMap1.put("Ankit", 80);
        hashMap1.put("Bablu", 70);

        Integer res = hashMap1.getOrDefault("Shubham", 0);
        hashMap1.put("Shubham", 100);
        System.out.println(hashMap1);
    }

}
