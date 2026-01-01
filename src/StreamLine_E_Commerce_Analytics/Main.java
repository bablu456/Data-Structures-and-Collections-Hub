package StreamLine_E_Commerce_Analytics;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    // Generics Method : "Filter Anything From List"
    //List<T> Data ki list (orders)
    // Predicate<T> condition jo check karni hai
    public static <T> List<T> filterData(List<T> list,Predicate<T> logic){
        List<T> result = new ArrayList<>();
        for(T t : list){
            if(logic.test(t)){
                result.add(t);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        // Dummy Data Setup
        List<Order> myOrders = new ArrayList<>();
        myOrders.add(new Order(1, "MacBook", 120000, "DELIVERED"));
        myOrders.add(new Order(2, "Mouse", 800, "PENDING"));
        myOrders.add(new Order(3, "Keyboard", 1500, "DELIVERED"));
        myOrders.add(new Order(4, "HDMI Cable", 400, "CANCELLED"));

        System.out.println("StreamLine E-Commerce Analytics");

        List<Order> expensiveOrders = filterData(myOrders, order -> order.getPrice() > 1000);
        System.out.println("Expensive Orders: " + expensiveOrders);

        List<Order> pendingOrders = filterData(myOrders , order -> order.getStatus().equals("PENDING"));
        List<Order> cheapOrders = filterData(myOrders,order -> order.getPrice()<1000);


        // Inside main method
// 1. Source: myOrders.stream() (Conveyor belt start)
// 2. Operation: .filter() (Machine jo kharab maal hata degi)
// 3. Terminal: .collect() (Packing department jo bache hue maal ki List banayega)

        List<Order> pendingOrdersStream = myOrders.stream()
                .filter(o -> o.getStatus().equals("PENDING"))
                .collect(Collectors.toList());

        System.out.println("Stream Pending: " + pendingOrdersStream);

        List<String> deliveredProductNames = myOrders.stream().filter(o -> o.getStatus().equals("DELIVERED"))
                .map(o -> o.getProduct())
                .collect(Collectors.toList());

        System.out.println("Delivered Items: " + deliveredProductNames);

        List<String> checkExpensiveProdcutsAndCancelled = myOrders.stream().filter(o ->o.getPrice()>1000 && o.getStatus().equals("CANCELLED"))
                .map(o -> o.getProduct())
                .collect(Collectors.toList());


        System.out.println("Pending Orders: " + pendingOrders);
        System.out.println("Cheap Orders: " + cheapOrders);

//        OrderFilter highValueLambda = order -> {
//            return order.getPrice() > 5000;
//        };
//        OrderFilter cheapLambda = order -> order.getPrice() < 1000;
//        System.out.println("Is Laptop High Value? " + highValueLambda.filter(order1));
//        System.out.println("Is Book Cheap? " + cheapLambda.filter(order2));
//
//        OrderFilter completedFilter = order -> order.getStatus().equals("Delivered") || order.getStatus().equals("Shipped");
    }
}
