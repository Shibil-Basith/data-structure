import java.util.Scanner;

public class p12 {
    private int[] deque;
    private int front;
    private int rear;
    private int size;

    public p12(int size) {
        deque = new int[size];
        front = -1;
        rear = -1;
        this.size = size;
    }

    public boolean isFull() {
        return (front == (rear + 1) % size);
    }

    public boolean isEmpty() {
        return front == -1;
    }

    // Insert at rear
    public void insertRear(int item) {
        if (isFull()) {
            System.out.println("Deque is full.");
            return;
        }

        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % size;
        deque[rear] = item;
    }

    // Insert at front
    public void insertFront(int item) {
        if (isFull()) {
            System.out.println("Deque is full.");
            return;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + size) % size;
        }
        deque[front] = item;
    }

    // Delete from front
    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }

        System.out.println("Front: " + front +"\nRear: " + rear);
        System.out.println("Deleted: " + deque[front]);

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    // Delete from rear
    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }

        System.out.println("Deleted: " + deque[rear]);

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            rear = (rear - 1 + size) % size;
        }
    }

    // Display the deque
    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }

        System.out.print("Deque elements: ");
        int i = front;
        while (true) {
            System.out.print(deque[i] + " ");
            if (i == rear) {
                break;
            }
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the deque:");
        int size = sc.nextInt();

        p12 deque = new p12(size);

        System.out.println("Choose Deque type: 1. Input Restricted 2. Output Restricted");
        int choice = sc.nextInt();

        boolean continueLoop = true;

        while (continueLoop) {
            if (choice == 1) {
                System.out.println("Input Restricted Deque Operations:");
                System.out.println("1. Insert at Rear");
                System.out.println("2. Delete from Front");
                System.out.println("3. Delete from Rear");
                System.out.println("4. Display");
                System.out.println("5. Exit");

                int operation = sc.nextInt();

                switch (operation) {
                    case 1:
                        System.out.println("Enter the element to insert at rear:");
                        int rearElement = sc.nextInt();
                        deque.insertRear(rearElement);
                        break;
                    case 2:
                        deque.deleteFront();
                        break;
                    case 3:
                        deque.deleteRear();
                        break;
                    case 4:
                        deque.display();
                        break;
                    case 5:
                        continueLoop = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else if (choice == 2) {
                System.out.println("Output Restricted Deque Operations:");
                System.out.println("1. Insert at Rear");
                System.out.println("2. Insert at Front");
                System.out.println("3. Delete from Front");
                System.out.println("4. Display");
                System.out.println("5. Exit");

                int operation = sc.nextInt();

                switch (operation) {
                    case 1:
                        System.out.println("Enter the element to insert at rear:");
                        int rearElement = sc.nextInt();
                        deque.insertRear(rearElement);
                        break;
                    case 2:
                        System.out.println("Enter the element to insert at front:");
                        int frontElement = sc.nextInt();
                        deque.insertFront(frontElement);
                        break;
                    case 3:
                        deque.deleteFront();
                        break;
                    case 4:
                        deque.display();
                        break;
                    case 5:
                        continueLoop = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("Invalid choice. Please select 1 or 2.");
                choice = sc.nextInt();
            }
        }

        sc.close();
    }
}
