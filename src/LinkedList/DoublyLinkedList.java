package LinkedList;

public class DoublyLinkedList {
    public static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
        }
    }
    public static class LinkedList{
        Node head = null;
        Node tail = null;

        void Add(int val){
            Node temp = new Node(val);
            if(head == null){
                head = tail = temp;
            }else{
                temp.next = head;
                head.prev = temp;
                head= temp;
            }
        }
        public void insertAtEnd(int val){
            Node temp = new Node(val);
            if(head == null){
                head = tail = temp;
            }else{
                tail.next = temp;
                temp.prev = tail;
                tail = temp;
            }
        }
        public void removeFromEnd(){
            if(tail == null){
                return;
            }else if(tail == head){
                head = tail = null;
            }else{
                tail = tail.prev;
                tail.next = null;
            }
        }

        public void removeFromFront(){
            if(head == null){
                return;
            }else if(head == tail){
                head = tail = null;
            }else{
                head = head.next;
                head.prev = null;
            }
        }

        public void display(){
            Node curr = head;
            while(curr != null){
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println();
        }
        public static void main(String[] args){
            LinkedList dll = new LinkedList();
            dll.Add(10);
            dll.Add(20);
            dll.Add(30);
            dll.display(); // 30 20 10
            dll.insertAtEnd(40);
            dll.insertAtEnd(50);
            dll.display(); // 30 20 10 40 50
        }
    }
}
