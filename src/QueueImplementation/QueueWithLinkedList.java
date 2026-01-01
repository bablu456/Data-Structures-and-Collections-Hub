package QueueImplementation;

import LinkedList.SinglyLinkedList;

public class QueueWithLinkedList {
    public static void main(String[] args){
        // Use custom linked list (non-generic) as the backing store for the queue
        SinglyLinkedList list = new SinglyLinkedList();

        // enqueue
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        System.out.println(list); // [10, 20, 30]

        // dequeue
        Integer i = (Integer) list.removeFirst();
        System.out.println("Removed Element : " + i);
        System.out.println(list); // [20, 30]

        // peek
        System.out.println("Peek : " + list.peekFirst());

        // simple additional demo
        while (!list.isEmpty()) {
            System.out.println("Dequeue -> " + list.removeFirst());
        }
        System.out.println("Empty? " + list.isEmpty());
    }
}
