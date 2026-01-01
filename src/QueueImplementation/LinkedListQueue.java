package QueueImplementation;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueue {
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(10); // enqueue
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        System.out.println(list.removeFirst()); // dequeue
        System.out.println(list.peekFirst()); // peek
        System.out.println(list);


        Queue<Integer> queue = new LinkedList<>();
        queue.add(10); // enqueue
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.peek());// dequeue

    }
}
