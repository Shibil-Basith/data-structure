import java.util.Scanner;

// Node class to represent each node in the circular linked list
class Node {
    int data;
    Node next;

    // Constructor to initialize a node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// CircularLinkedList class to represent the circular linked list
class CircularLinkedList {
    Node head; // Head of the list

    // Constructor to initialize an empty circular linked list
    public CircularLinkedList() {
        head = null;
    }

    // Method to insert a new node at the end of the circular linked list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head; // Point to itself to make it circular
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    // Method to count the number of nodes in the circular linked list
    public int countNodes() {
        int count = 0;
        if (head == null) {
            return count;
        }

        Node current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);

        return count;
    }

    // Method to display the circular linked list
    public void display() {
        if (head == null) {
            System.out.println("Circular Linked List is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}

// Main class to demonstrate the circular linked list, insert nodes, count nodes, and display the list
public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of nodes to insert:");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " numbers to insert at the end of the circular linked list:");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            list.insertAtEnd(data);
        }

        scanner.close();

        // Display the circular linked list after insertion
        System.out.println("Circular Linked List after insertion:");
        list.display();

        // Counting the number of nodes in the circular linked list
        int nodeCount = list.countNodes();
        System.out.println("Number of nodes in the circular linked list: " + nodeCount);
    }
}

