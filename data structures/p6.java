import java.util.*;

public class p6
{
	public static void main(String args[])
	{
		int max=5, i, n, top=-1, ch;
		Scanner input = new Scanner(System.in);
		int stack[] = new int[max];
		while(true)
		{
			System.out.println("Stack operations: ");
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
					top = push(stack, max, top, n);
					break;
				case 2: top = pop(stack, top);
					break;
				case 3: displayStack(stack, top);
					break;
				case 4: return;
				default: System.out.println("Invalid choice");
			}
			
			try
			{
				Thread.sleep(3000);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	public static int push(int stack[], int max, int top, int n)
	{
		
		if(top<max-1)
		{
			stack[++top] = n;
			System.out.println("Push operation successful");
			return top;
		}
		else
		{
			System.out.println("Array overflow...");
			return top;
		}
	}
	
	
	public static int pop(int stack[], int top)
	{
		if(top==-1)
		{
			System.out.println("Array underflow...");
			return top;
		}
		else
		{
			top--;
			System.out.println("Pop operation successful");
			return top;
		}
	}
	
	public static void displayStack(int[] stack, int top)
	{
		
		if(top==-1)
		{
			System.out.println("Array underflow...");
			return;
		}
		
		System.out.println("Stack: ");
		for(int i=0; i<=top; i++)
		{
			System.out.println(stack[i]);
		}
	}
}
		
		
