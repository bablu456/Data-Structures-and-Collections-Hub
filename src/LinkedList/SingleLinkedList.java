package LinkedList;

public class SingleLinkedList {
    public static class Node{
        int data;
        Node next;
        Node (int data){
            this.data = data;
        }
    }
    public static class LinkedList{
        Node head = null;

        void add(int val){
            Node temp = new Node(val);
            if(head == null){
                head = temp;
            }else{
                temp.next = head;
                head = temp;
            }
        }
        public void insertAtEnd(int val){
            Node temp = new Node(val);
            if(head == null){
                head = temp;
            }else{
                Node curr = head;
                while(curr.next != null){
                    curr = curr.next;
                }
                curr.next = temp;
            }
        }
        public void display(){
            Node curr = head;
            while(curr != null){
                System.out.print(curr.data + " -> ");
                curr = curr.next;
            }
            System.out.println("null");
        }
        public void removeFromFront(){
            if(head == null){
                return;
            }else{
                head = head.next;
            }
        }
        public void removeFromEnd(){
            if(head == null){
                return;
            }else if(head.next == null){
                head = null;
            }else{
                Node curr = head;
                while(curr.next.next != null){
                    curr = curr.next;
                }
                curr.next = null;
            }
        }
    }
    public static void main(String[] args){
LinkedList list = new LinkedList();
    list.add(10);
    list.add(20);
    list.insertAtEnd(30);
    list.display(); // 20 -> 10 -> 30 -> null
    list.removeFromFront();

    }
}
