package Collections_Practice_Sets;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1,2,2,3,4,4,5,5,6,7,8,8,9);
        Set<Integer> List1 = new HashSet<>(list);
//        System.out.println(list1);

        Iterator<Integer> it = List1.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }



//        Iterator<Integer> it = List1.iterator();
//        while(it.hasNext()){
//            System.out.print(it.next() + " ");
//        }

    }


}
