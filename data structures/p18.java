import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class p18 {
    Node head;
    
    public p18() {
        this.head = null;
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
    
    public int countNodes() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    public static void main(String args[]) {
        int data, n;
        Scanner input = new Scanner(System.in);
        p18 list = new p18();
        
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
        
        System.out.println("nodes count: " + list.countNodes());
        
        
        input.close(); // Closing scanner
    }
}

