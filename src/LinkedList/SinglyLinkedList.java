package LinkedList;

public class SinglyLinkedList {
    private static class Node {
        Object value;
        Node next;
        Node(Object value) { this.value = value; }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addLast(Object value) {
        Node node = new Node(value);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public Object removeFirst() {
        if (head == null) return null;
        Object val = head.value;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return val;
    }

    public Object peekFirst() {
        return head == null ? null : head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node curr = head;
        while (curr != null) {
            sb.append(curr.value);
            if (curr.next != null) sb.append(", ");
            curr = curr.next;
        }
        sb.append(']');
        return sb.toString();


    }
}
