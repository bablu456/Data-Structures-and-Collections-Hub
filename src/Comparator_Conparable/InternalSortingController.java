package Comparator_Conparable;

import java.util.ArrayList;
import java.util.List;

public class InternalSortingController {
    public static void main(String[] args) {
        List<Student1> students = new ArrayList<>();
        students.add(new Student1("A", 25));
        students.add(new Student1("B", 25));
        students.add(new Student1("C", 25));
        students.add(new Student1("C", 10));
        students.add(new Student1("D", 13));
        students.add(new Student1("D", 13));
        students.add(new Student1("E", 25));
        students.add(new Student1("E", 20));
        students.add(new Student1("F", 48));

        System.out.println("Before Sorting: ");
        for(Student1 student : students) {
            System.out.println("Name : "+student.getName()+", Age :  "+student.getMarks());
        }

    }
}
