package Comparator_Conparable;

import java.util.Date;
import java.util.Objects;

public class Student {
    private String name;
    private String batchName;
    private boolean present;
    private String phoneNumber;
    private Date date;

    public Student(String name, String batchName, boolean present) {
        this.name = name;
        this.batchName = batchName;
        this.present = present;
    }
    public Student(String name, String batchName, boolean present, String phoneNumber, Date date) {
        this(name, batchName, present);
        this.phoneNumber = phoneNumber;
        this.date = date;
    }
    public String getName() {
        return name;
    }

    public String getBatchName() {
        return batchName;
    }

    public boolean isPresent() {
        return present;
    }

//    @Override
//    public boolean equals(Object o){
//        if(this == o) return true;
//        if(o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return Objects.equals(name,student.name);
//    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
