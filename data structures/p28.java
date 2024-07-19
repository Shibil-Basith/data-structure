import java.util.Scanner;

// ListNode class to represent each node in the stack
class ListNode {
    int data;
    ListNode next;

    // Constructor to initialize a node
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// StackLinkedList class to represent the stack implemented using linked list
class StackLinkedList {
    ListNode top; // Top of the stack

    // Constructor to initialize an empty stack
    public StackLinkedList() {
        top = null;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Method to push (insert) an element onto the stack
    public void push(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        System.out.println(data + " pushed to stack.");
    }

    // Method to pop (remove) an element from the stack
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow. Cannot pop from empty stack.");
            return;
        }
        int poppedValue = top.data;
        top = top.next;
        System.out.println(poppedValue + " popped from stack.");
    }

    // Method to peek (get the top element) of the stack
    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No elements to peek.");
        } else {
            System.out.println("Top element of stack: " + top.data);
        }
    }

    // Method to display the elements of the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        ListNode current = top;
        System.out.print("Stack (top to bottom): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Main class to demonstrate the stack operations with a menu-driven approach
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackLinkedList stack = new StackLinkedList();

        while (true) {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display Stack");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to push: ");
                    int data = scanner.nextInt();
                    stack.push(data);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.peek();
                    break;
                case 4:
                    stack.display();
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

