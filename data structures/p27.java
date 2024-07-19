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

    // Method to insert a new node at the beginning of the doubly linked list
    public void insertAtBeginning(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
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

    // Method to insert a new node after a given position in the doubly linked list
    public void insertAfter(int position, int data) {
        ListNode newNode = new ListNode(data);
        ListNode current = head;
        int currentPosition = 1;
        while (currentPosition < position && current != null) {
            current = current.next;
            currentPosition++;
        }
        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }
        if (current == tail) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
    }

    // Method to delete a node from the doubly linked list at a given position
    public void deleteAtPosition(int position) {
        if (isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        ListNode current = head;
        int currentPosition = 1;
        while (currentPosition < position && current != null) {
            current = current.next;
            currentPosition++;
        }
        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }
        if (current == head && current == tail) {
            head = null;
            tail = null;
        } else if (current == head) {
            head = head.next;
            head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    // Method to display the doubly linked list in forward direction
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

    // Method to display the doubly linked list in backward direction
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
}

// Main class to demonstrate the doubly linked list operations with a menu-driven approach
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

        while (true) {
            System.out.println("\n--- Doubly Linked List Menu ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert After Position");
            System.out.println("4. Delete at Position");
            System.out.println("5. Display Forward");
            System.out.println("6. Display Backward");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at beginning: ");
                    int dataBeginning = scanner.nextInt();
                    list.insertAtBeginning(dataBeginning);
                    break;
                case 2:
                    System.out.print("Enter data to insert at end: ");
                    int dataEnd = scanner.nextInt();
                    list.insertAtEnd(dataEnd);
                    break;
                case 3:
                    System.out.print("Enter position after which to insert: ");
                    int position = scanner.nextInt();
                    System.out.print("Enter data to insert: ");
                    int dataInsert = scanner.nextInt();
                    list.insertAfter(position, dataInsert);
                    break;
                case 4:
                    System.out.print("Enter position to delete: ");
                    int positionDelete = scanner.nextInt();
                    list.deleteAtPosition(positionDelete);
                    break;
                case 5:
                    list.displayForward();
                    break;
                case 6:
                    list.displayBackward();
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

