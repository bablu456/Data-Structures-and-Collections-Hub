package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Stackcontroller {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top Elemnt : "+stack.peek());

        System.out.println("Popped Element : "+stack.pop());
        System.out.println("Stack Elements : "+stack);

        System.out.println("Is Stack Empty? : "+stack.isEmpty());

        Deque<Integer> stack2 = new ArrayDeque<>();
        stack2.push(100);
        stack2.push(200);
        stack2.push(300);

        System.out.println("Top Element of Deque Stack : "+stack2.peek());
        System.out.println("Deque Stack Elements : "+stack2.pop());

        System.out.println("Top Element after pop : "+stack2.peek());

        System.out.println("Is Stack2 Empty? : "+stack2.isEmpty());

        // diffrence between stack and deque stack
        // stack is synchronized and thread-safe but deque is not
        // stack is legacy class but deque is part of collections framework
        // stack has few methods but deque has more methods
        // deque can be used as both stack and queue but stack can only be used as stack
        // deque is faster than stack
        // deque has more memory overhead than stack
        // deque is more versatile than stack
        // stack is LIFO but deque can be both LIFO and FIFO
        // stack extends vector but deque implements deque interface
        // stack is less preferred than deque for stack operations

    }
}
