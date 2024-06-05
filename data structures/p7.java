import java.util.*;

public class p7
{
	public static void main(String args[])
	{
		int front=-1, rear=-1, max=10, n;
		Scanner input = new Scanner(System.in);
		int queue[] = new int[max];
		do
		{
			System.out.print("Enter the number of elements you want to insert into the queue: ");
			n = input.nextInt();
			if(n>max)
			{
				System.out.println("The number exceeds the maxsize...Re-enter the value...");
			}
		}while(n>max);
		System.out.println("Enter the elements: ");
		for(int i=0; i<n; i++)
		{
			queue[i] = input.nextInt();
			if(front==-1)
			{
				front=0;
			}
			rear++;
		}
		
		System.out.println("Do you want to delete element from the queue? (0 or 1): ");
		int choice = input.nextInt();
		while(choice==1)
		{
			if(front<=rear)
			{
				front++;
				System.out.println("Do you want to delete more element from the queue? (0 or 1): ");
	 			choice = input.nextInt();
	 		}
	 		else
	 		{
	 			System.out.println("Queue empty...");
	 			choice = 0;
	 		}
	 	}
	 	
	 	if(rear<front)
	 	{
			front=rear=-1;
		}
	 	
	 	System.out.println("Qeueue after delete operation: ");
	 	for(int i=front; i<=rear; i++)
	 	{
	 		if(front!=-1)
	 		{
	 			System.out.println(queue[i]);
	 		}
	 		else
	 		{
	 			System.out.println("No element to display...");
	 		}
	 	}
	 	System.out.println("Rear: " + rear);
	 	System.out.println("Front: " + front);
	 }
}
	 	
			
		
		
