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
class p25{
    ListNode head; // Head of the list

    // Constructor to initialize an empty circular linked list
    public p25() {
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


    public void insertAtLast(int data)
    {
        ListNode newNode = new ListNode(data);
        if(isEmpty())
        {
            head = newNode;
            head.next = head;
        }
        else
        {
            ListNode current = head;
            while(current.next!=head)
            {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
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
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("null");
    }

    public static void main(String[] args) {
        p25 list = new p25();
        Scanner scanner = new Scanner(System.in);
        int ch = 1;

        System.out.println("Enter elements to the circular linked list: ");
        while(ch == 1)
        {
            System.out.print("Enter data:");
            int data = scanner.nextInt();
            list.insertAtLast(data); // Insert at the beginning for this example
            System.out.println("Do you want to enter more elements: ");
            ch = scanner.nextInt();
        }

        System.out.println("Circular Linked List after initial insertion: ");
        list.display();

        System.out.println("Enter position to insert a new element:");
        int position = scanner.nextInt();

        System.out.println("Enter data for the new element:");
        int newData = scanner.nextInt();

        // Insert node at the specified position
        list.insertAtPosition(newData, position);

        // Display the list after insertion at position
        System.out.println("Circular Linked List after insertion at position:");
        list.display();

        scanner.close();
    }
}

