package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Queue_Implementation {
    public static void main(String[] args) {
        Queue<Integer> quesue = new ArrayDeque<>();
        quesue.add(10);
        quesue.add(20);
        quesue.add(30);

        System.out.println("Front Element : " + quesue.peek());
        System.out.println("Removed Element : " + quesue.poll());
        System.out.println("Is Empty? : " + quesue.isEmpty());
        System.out.println("Queue Elements : " + quesue);

        // queue implementation using linked list

    }
}
