import java.util.*;

public class p4
{
	public static void main(String args[])
	{
		int max=10, i, n, top=-1, ch;
		Scanner input = new Scanner(System.in);
		int stack[] = new int[max];
		do
		{
			System.out.println("Enter number elements you want to insert into stack: ");
			n = input.nextInt();
		}while(n>max);
		if(n>0)
		{
			System.out.println("Enter elements to the array: "); 
			for(i=0; i<n; i++)
			{
				stack[i] = input.nextInt();
				top++;
			}
		}
		
		System.out.println("top: " + top);
		
		while(top<max-1)
		{
			System.out.println("Do you want to push element into stack: ");
			ch = input.nextInt();
			if(ch==1)
			{
				System.out.println("Enter element to push at position " + (top+1) + ": ");
				stack[++top] = input.nextInt();
			}
			else
			{
				break;
			}
		}
		
		if(top==max-1)
		{
			System.out.println("Array overflow...Cannot add more elements into the array...");
		}
		System.out.println("Stack: ");
		displayStack(stack, top);
	}
	
	
	public static void displayStack(int[] stack, int top)
	{
		
		if(top==-1)
		{
			System.out.println("Array underflow...");
		}
		for(int i=0; i<=top; i++)
		{
			System.out.println(stack[i]);
		}
	}
}
				
			
			
		
		
		
