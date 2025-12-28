package MainMethod;

public class Test1 {

    public static void main(String[] args){
        System.out.println("This is Test1 main method");
    }

    
     public static void main(Integer[] bablu){
        System.out.println("This is Test2 main method");
    }
}
class test2 extends Test1{
    public static void main(String[] args) {
        System.out.println("This is Test2 main method");
    }

    public static void main(Integer[] args){
        System.out.println("This is Test2 main method with Integer array");
    }

}
