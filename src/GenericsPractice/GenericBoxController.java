package GenericsPractice;

public class GenericBoxController {
    public static void main(String[] args) {
    Box<Pencil> pencilBox = new Box<>();
    Pencil pencil = new Pencil();
    pencil.setColor("yellow");
    pencilBox.setValue(pencil);

    }
}
