package List;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ArrayCapacity {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        ArrayList<Integer> list = new ArrayList<>(10);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
//        list.add(11); // This will increase the capacity automatically

        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(list);
        System.out.println("Current capacity: " + elementData.length);
    }
}
