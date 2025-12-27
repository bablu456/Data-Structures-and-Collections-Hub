package Comparator_Conparable;

public class Student1 implements Comparable<Student1> {
    int id;
    String name;
    int marks;

    public Student1(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public Student1(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public int compareTo(Student1 other) {
        // desc
//         return  o.marks - this.marks;
        // asc
        // return this.marks - other.marks;

        // asc by name
        return this.name.compareTo(other.name);
        // dessending by name
        // return other.name.compareTo(this.name);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student1 student = (Student1) o;
        return id == student.id;
    }
    @Override
    public String toString() {
        return "Student1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
    public void setId(int id) {
        this.id = id;
    }
}
