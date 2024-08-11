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
class p26 {
    ListNode head; // Head of the list
    ListNode tail; // Tail of the list

    // Constructor to initialize an empty doubly linked list
    public p26() {
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
    public int searchForward(int key) {
        ListNode current = head;
        int i = 1;
        while (current != null) {
            if (current.data == key) {
                return i;
            }
            i++;
            current = current.next;
        }
        return -1;
    }

    // Method to search for an element in the doubly linked list (backward)
    public int searchBackward(int key) {
        ListNode current = tail;
        int i = 1;
        while (current != null) {
            if (current.data == key) {
                return i;
            }
            i++;
            current = current.prev;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        p26 list = new p26();

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
                    int searchForwardPosition = list.searchForward(keyForward);
                    if (searchForwardPosition != -1) {
                        System.out.println(keyForward + " found in the list at " + searchForwardPosition + "(Forward).");
                    } else {
                        System.out.println(keyForward + " not found in the list (Forward).");
                    }
                    break;
                case 5:
                    System.out.print("Enter element to search backward: ");
                    int keyBackward = scanner.nextInt();
                    int searchBackwardPosition = list.searchBackward(keyBackward);
                    if (searchBackwardPosition != -1) {
                        System.out.println(keyBackward + " found in the list at " + searchBackwardPosition + "(Forward).");
                    } else {
                        System.out.println(keyBackward + " not found in the list (Forward).");
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
