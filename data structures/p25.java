import java.util.Scanner;

// ListNode class to represent each node in the circular linked list
class ListNode {
    int data;
    ListNode next;

    // Constructor to initialize a node
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// CircularLinkedList class to represent the circular linked list
class CircularLinkedList {
    ListNode head; // Head of the list

    // Constructor to initialize an empty circular linked list
    public CircularLinkedList() {
        head = null;
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Method to insert a new node at the beginning of the circular linked list
    public void insertAtBeginning(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            head = newNode;
            head.next = head; // Circular reference for the first node
        } else {
            newNode.next = head; // Point new node to current head
            ListNode current = head;
            while (current.next != head) {
                current = current.next; // Traverse to find the last node
            }
            current.next = newNode; // Make last node point to new head
            head = newNode; // Update head to new node
        }
    }

    // Method to insert a new node at a specific position in the circular linked list
    public void insertAtPosition(int data, int position) {
        ListNode newNode = new ListNode(data);
        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        } else if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        ListNode current = head;
        int currentPosition = 1;

        // Traverse to the position or wrap around the list if needed
        while (currentPosition < position - 1 && current.next != head) {
            current = current.next;
            currentPosition++;
        }

        if (current.next == head && currentPosition != position - 1) {
            System.out.println("Position is beyond the end of the list.");
            return;
        }

        // Insert newNode between current and current.next
        newNode.next = current.next;
        current.next = newNode;
    }

    // Method to display the circular linked list
    public void display() {
        if (head == null) {
            System.out.println("Circular Linked List is empty.");
            return;
        }

        ListNode current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}

// Main class to demonstrate the circular linked list, insert nodes, and display the list before and after insertion at a position
public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of nodes to insert at the beginning:");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter data for node " + (i + 1) + ":");
            int data = scanner.nextInt();
            list.insertAtBeginning(data); // Insert at the beginning for this example
        }

        System.out.println("Circular Linked List after insertion at beginning:");
        list.display();

        System.out.println("Enter position to insert a new element (1 to " + (n + 1) + "):");
        int position = scanner.nextInt();

        System.out.println("Enter data for the new element:");
        int newData = scanner.nextInt();

        // Display the list before insertion at position
        System.out.println("Circular Linked List before insertion at position:");
        list.display();

        // Insert node at the specified position
        list.insertAtPosition(newData, position);

        // Display the list after insertion at position
        System.out.println("Circular Linked List after insertion at position:");
        list.display();

        scanner.close();
    }
}

