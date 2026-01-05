package List;

public class student {
    int add;
    String name;

    public student(int add, String name) {
        this.add = add;
        this.name = name;
    }

    @Override
    public String toString() {
        return "student{" +
                "add=" + add +
                ", name='" + name + '\'' +
                '}';
    }
}
