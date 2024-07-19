import java.util.Scanner;

// ListNode class to represent each node in the doubly linked list
class ListNode {
    int data;
    ListNode prev;
    ListNode next;

    // Constructor to initialize a node
    public ListNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

// DoublyLinkedList class to represent the doubly linked list
class DoublyLinkedList {
    ListNode head; // Head of the list
    ListNode tail; // Tail of the list

    // Constructor to initialize an empty doubly linked list
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Method to insert a new node at the end of the doubly linked list
    public void insertAtEnd(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Method to display the doubly linked list (forward)
    public void displayForward() {
        if (isEmpty()) {
            System.out.println("Doubly Linked List is empty.");
            return;
        }

        ListNode current = head;
        System.out.print("Doubly Linked List (Forward): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to display the doubly linked list (backward)
    public void displayBackward() {
        if (isEmpty()) {
            System.out.println("Doubly Linked List is empty.");
            return;
        }

        ListNode current = tail;
        System.out.print("Doubly Linked List (Backward): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // Method to search for an element in the doubly linked list (forward)
    public boolean searchForward(int key) {
        ListNode current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to search for an element in the doubly linked list (backward)
    public boolean searchBackward(int key) {
        ListNode current = tail;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.prev;
        }
        return false;
    }
}

// Main class to demonstrate the doubly linked list operations with a menu-driven approach
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

        while (true) {
            System.out.println("\n--- Doubly Linked List Menu ---");
            System.out.println("1. Insert at End");
            System.out.println("2. Display Forward");
            System.out.println("3. Display Backward");
            System.out.println("4. Search Forward");
            System.out.println("5. Search Backward");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at end: ");
                    int data = scanner.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 2:
                    list.displayForward();
                    break;
                case 3:
                    list.displayBackward();
                    break;
                case 4:
                    System.out.print("Enter element to search forward: ");
                    int keyForward = scanner.nextInt();
                    if (list.searchForward(keyForward)) {
                        System.out.println(keyForward + " found in the list (Forward).");
                    } else {
                        System.out.println(keyForward + " not found in the list (Forward).");
                    }
                    break;
                case 5:
                    System.out.print("Enter element to search backward: ");
                    int keyBackward = scanner.nextInt();
                    if (list.searchBackward(keyBackward)) {
                        System.out.println(keyBackward + " found in the list (Backward).");
                    } else {
                        System.out.println(keyBackward + " not found in the list (Backward).");
                    }
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

