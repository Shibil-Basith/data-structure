import java.util.*;

class p2
{
	public static void main(String args[])
	{
		int n, pos, max=10, count=0, ch;
		Scanner input = new Scanner(System.in);
		int arr[] = new int[max];
		System.out.print("Enter the no.of elements of the array: ");
		n = input.nextInt();
		System.out.println("Enter elements to the array: ");
		for(int i=0; i<n; i++)
		{
			arr[i] = input.nextInt();
			count++;
		}
		do{
			do{
			
				System.out.print("Enter the position at which you want to insert new element: ");
				pos = input.nextInt();
				if(pos>count+1 || pos<=0)
				{
					System.out.println("position must be between 1-"+(count+1));
				} 
			}while(pos>count+1 || pos<=0);
			if(count>=max)
			{
				System.out.println("Array overflow");
				display(arr, count);
				return;
			}
			for(int i=count-1; i>=pos-1; i--)
			{
				arr[i+1] = arr[i];
			}
		
			System.out.print("Enter the new element: ");
			arr[pos-1] = input.nextInt();
			count++;
			
			System.out.println("Want to insert more elements? (0 or 1)");
			ch = input.nextInt();
		}while(ch==1);
		display(arr, count);
		
	}
	
	public static void display(int arr[], int count)
	{
		System.out.println("New array: ");
		for(int i=0; i<count; i++)
		{
			System.out.println(arr[i]);
		}
	}
}
		
		
		
