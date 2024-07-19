import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class p19 {
    Node head;
    
    public p19() {
        this.head = null;
    }
    
    public void addFirst(int data) {
        Node newNode = new Node(data);
        
        newNode.next = head;
        head = newNode;
    }
        
    public void addLast(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    
    public static void main(String args[]) {
        int data, n;
        Scanner input = new Scanner(System.in);
        p19 list = new p19();
        
        System.out.print("Enter number of elements to enter at last: ");
        n = input.nextInt();
        System.out.println("Enter data: ");
        for (int i = 0; i < n; i++) {
            data = input.nextInt();
            list.addLast(data);
        }
        System.out.println("List after addition at last: ");
        list.display();
       
        System.out.println("Enter data to enter at first: ");
        data = input.nextInt();
        list.addFirst(data);
        System.out.println("List after addition at first: ");
        list.display();
        
        
        
        
        input.close(); // Closing scanner
    }
}

