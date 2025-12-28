package GenericsPractice;

public class Box <t>{
    private t value;
//    Box(){
//        this.value = value;
//    }
    public t getValue() {
        return value;
    }
    public void setValue(t value) {
        this.value = value;
    }
}
