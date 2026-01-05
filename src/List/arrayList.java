package List;

import java.util.List;

public class arrayList {
    public static void main(String[] args){
        student s = new student(1, "John");
        List<student> list = new java.util.ArrayList<>();
//        System.out.println(list);
//            list.add(s);
//        System.out.println(list);
//        student s1 = new student(2, "Doe");
//        list.add(s1);
//        System.out.println(list.indexOf(0));

        list.add(s);
        System.out.println(list);



//        System.out.println(list);

    }
}
