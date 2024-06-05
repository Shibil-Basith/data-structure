import java.util.*;

public class p8
{
	public static void main(String args[])
	{
		int max=3, i, n, front=-1, rear=-1, ch;
		Scanner input = new Scanner(System.in);
		int queue[] = new int[max];
		while(true)
		{
			System.out.println("Queue operations: ");
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Display");
			System.out.println("4. Exit");
			System.out.println("Enter your choice: ");
			
			ch = input.nextInt();
			
			switch(ch)
			{
				case 1:	System.out.println("Enter the element: ");
					n = input.nextInt();
					int arraypush[] = push(queue, max, front, rear, n);
					rear = arraypush[0];
					front = arraypush[1];
					break;
				case 2: int arraypop[] = pop(queue, max, front, rear);
					rear = arraypop[0];
					front = arraypop[1];
					break;
				case 3: displayQueue(queue, front, rear);
					break;
				case 4: return;
				default: System.out.println("Invalid choice");
			}
			
		}
	}
	
	
	public static int[] push(int queue[], int max, int front, int rear, int n)
	{
		
		if(rear<max-1)
		{
			if(front==-1)
			{
				front=0;
			}
			queue[++rear] = n;
			System.out.println("Push operation successful");
			int arr[] = {rear, front};
			return arr;
		}
		else
		{
			System.out.println("Queue overflow...");
			int arr[] = {rear, front};
			return arr;
		}
	}
	
	
	public static int[] pop(int stack[], int max, int front, int rear)
	{
		if(front==-1)
		{
			System.out.println("Queue underflow...");
			int arr[] = {rear, front};
			return arr;
		}
		else
		{
			front++;
			if(front>=max)
			{
				front=rear=-1;
				int arr[] = {rear, front};
				return arr;
			}
			System.out.println("Pop operation successful");
			int arr[] = {rear, front};
			return arr;
		}
	}
	
	public static void displayQueue(int[] queue, int front, int rear)
	{
		
		if(front==-1)
		{
			System.out.println("Queue underflow...");
			System.out.println("front=" + front);
			return;
		}
		
		System.out.println("Queue: ");
		for(int i=front; i<=rear; i++)
		{
			System.out.println(queue[i]);
		}
	}
}
		
		
