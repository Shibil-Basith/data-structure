import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class p24 {
    private Node head;

    public CircularLinkedList() {
        head = null;
    }

    // Method to insert a node at the beginning of the circular linked list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            // If the list is empty, point the new node to itself
            head = newNode;
            head.next = head;
        } else {
            Node temp = head;

            // Traverse to the last node
            while (temp.next != head) {
                temp = temp.next;
            }

            // Insert new node at the beginning
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
    }

    // Method to display the circular linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements to insert:");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + ":");
            int data = scanner.nextInt();
            list.insertAtBeginning(data);
        }

        System.out.println("Updated list:");
        list.display();

        scanner.close();
    }
}
