import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class p20 {
    Node head;
    
    public p20() {
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
        p20 list = new p20();
        
        System.out.print("Enter number of elements to enter at last: ");
        n = input.nextInt();
        System.out.println("Enter data: ");
        for (int i = 0; i < n; i++) {
            data = input.nextInt();
            list.addLast(data);
        }
        System.out.println("List after addition at last: ");
        list.display();
        
        System.out.print("Enter number of elements to enter at first: ");
        n = input.nextInt();
        System.out.println("Enter data: ");
        for (int i = 0; i < n; i++) {
            data = input.nextInt();
            list.addFirst(data);
        }
        System.out.println("List after addition at first: ");
        list.display();
        
        
        
        
        input.close(); // Closing scanner
    }
}

