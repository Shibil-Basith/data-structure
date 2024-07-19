import java.util.Scanner;

// ListNode class to represent each node in the queue
class ListNode {
    int data;
    ListNode next;

    // Constructor to initialize a node
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// QueueLinkedList class to represent the queue implemented using linked list
class QueueLinkedList {
    ListNode front; // Front of the queue
    ListNode rear; // Rear of the queue

    // Constructor to initialize an empty queue
    public QueueLinkedList() {
        front = null;
        rear = null;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Method to enqueue (insert) an element into the queue
    public void enqueue(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(data + " enqueued to queue.");
    }

    // Method to dequeue (remove) an element from the queue
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow. Cannot dequeue from empty queue.");
            return;
        }
        int dequeuedValue = front.data;
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
        }
        System.out.println(dequeuedValue + " dequeued from queue.");
    }

    // Method to peek (get the front element) of the queue
    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No elements to peek.");
        } else {
            System.out.println("Front element of queue: " + front.data);
        }
    }

    // Method to display the elements of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        ListNode current = front;
        System.out.print("Queue (front to rear): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Main class to demonstrate the queue operations with a menu-driven approach
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QueueLinkedList queue = new QueueLinkedList();

        while (true) {
            System.out.println("\n--- Queue Menu ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display Queue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to enqueue: ");
                    int data = scanner.nextInt();
                    queue.enqueue(data);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.peek();
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

