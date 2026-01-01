package PracticeForTest.OOPs;

public class constructorCahinig {
    int data;
    String me;
    constructorCahinig(){
        this(10);
        System.out.println("Default Constructor");
    }
    constructorCahinig(int data){
        this(data,"Hello");
        System.out.println("Constructor with int parameter: "+data);
    }
    constructorCahinig(int data, String me) {
        this.data = data;
        this.me = me;
        System.out.println("Constructor with int and String parameters: " + data + ", " + me);
    }
    public static void main(String[] args){
        constructorCahinig obj = new constructorCahinig();
        System.out.println(obj.data);
        System.out.println(obj.me);
    }
}
