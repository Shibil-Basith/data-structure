import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class p22 {
    Node head;
    
    public p22() {
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
    
    public int removeFirst() {
        if (head == null) {
            System.out.println("List is empty. Cannot remove from empty list.");
            return -1; // Return -1 or throw an exception for empty list scenario
        }
        int removedValue = head.data;
        head = head.next;
        return removedValue;
    }
    
    public int removeLast() {
        if (head == null) {
            System.out.println("List is empty. Cannot remove from empty list.");
            return -1; // Return -1 or throw an exception for empty list scenario
        }
        
        if (head.next == null) {
            int removedValue = head.data;
            head = null;
            return removedValue;
        }
        
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        int removedValue = current.next.data;
        current.next = null;
        return removedValue;
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
        p22 list = new p22();
        
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
        
        int removedFirst = list.removeFirst();
        System.out.println("Removed value from first: " + removedFirst);
        System.out.println("List after remove at first: ");
        list.display();
        
        int removedLast = list.removeLast();
        System.out.println("Removed value from last: " + removedLast);
        System.out.println("List after remove at last: ");
        list.display();
        
        System.out.println("nodes count: " + list.countNodes());
        
        
        input.close(); // Closing scanner
    }
}

