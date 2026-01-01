package PracticeForTest.equalAndHashcode;

public class User {
    private int age;
    private String name;

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;  // 1.  same object -> equal
        if(o == null || getClass() != o.getClass()) return false; // 2. null or different class -> not equal

        User other = (User) o; // 3. type casting
        return this.age == other.age &&
                this.name.equals(other.name); // 4. compare
    }

    @Override
    public int hashCode(){
        int result = Integer.hashCode(age);
        result = 31 * result + name.hashCode();
        return result;
    }
}
