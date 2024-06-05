import java.util.Scanner;
class CircularQueue {
	private int[] queue;
	private int front;
	private int rear;
	private int size;
	private int capacity;
	public CircularQueue(int capacity) {
		this.capacity = capacity;
		this.queue = new int[capacity];
		this.front = -1;
		this.rear = -1;
		this.size = 0;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public boolean isFull() {
		return size == capacity;
	}
	public void enqueue(int item) {
		if (isFull()) {
			System.out.println("Queue is full!");
			return;
		}
		if (isEmpty()) {
			front = 0;
		}
		rear = (rear + 1) % capacity;
		queue[rear] = item;
		size++;
		System.out.println(item + " enqueued to the queue");
	}
	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty!");
			return -1;
		}
		int item = queue[front];
		if (front == rear) {
			front = -1;
			rear = -1;
		}
		else {
			front = (front + 1) % capacity;
		}
		size--;
		System.out.println(item + " dequeued from the queue");
		return item;
	}
	public void display() {
		if (isEmpty()) {
			System.out.println("Queue is empty!");
			return;
		}
		System.out.print("Queue: ");
		if(front<=rear)
		{
			for(int i=front; i<=rear; i++)
			{
				System.out.print(queue[i] + " ");
			}
		}
		else
		{
			for(int i=0; i<=rear; i++)
			{
				System.out.print(queue[i] + " ");
			}
			for(int i=front; i<capacity; i++)
			{
				System.out.print(queue[i] + " ");
			}
		}
	}
		
	}
	
public class p9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the capacity of the queue: ");
		int capacity = scanner.nextInt();
		CircularQueue queue = new CircularQueue(capacity);
		while (true) {
			System.out.println("\nCircular Queue Operations:");
			System.out.println("1. Enqueue");
			System.out.println("2. Dequeue");
			System.out.println("3. Display");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:	System.out.print("Enter the element to enqueue: ");
				int element = scanner.nextInt();
				queue.enqueue(element);
				break;
			case 2:	queue.dequeue();
				break;
			case 3:	queue.display();
				break;
			case 4:	System.out.println("Exiting program...");
				System.exit(0);
			default:System.out.println("Invalid choice! Please enter a valid option.");
			}
		}
	}
}

