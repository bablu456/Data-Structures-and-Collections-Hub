package StreamLine_E_Commerce_Analytics;

@FunctionalInterface // ye annotation ensures only one abstract method
public interface OrderFilter {
    boolean filter(Order order);
}
