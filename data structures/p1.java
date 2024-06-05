import java.util.*;

class p1
{
	public static void main(String args[])
	{
		int n, pos;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the no.of elements of the array: ");
		n = input.nextInt();
		int arr[] = new int[n+1];
		System.out.println("Enter elements to the array: ");
		for(int i=0; i<n; i++)
		{
			arr[i] = input.nextInt();
		}
		do{
			
			System.out.print("Enter the position at which you want to insert new element: ");
			pos = input.nextInt();
			if(pos>n+1 || pos<=0)
			{
				System.out.println("position must be between 1-"+(n+1));
			} 
		}while(pos>n+1 || pos<=0);
		for(int i=n-1; i>=pos-1; i--)
		{
			arr[i+1] = arr[i];
		}
		
		System.out.print("Enter the new element: ");
		arr[pos-1] = input.nextInt();
		
		System.out.println("New array: ");
		for(int i=0; i<=n; i++)
		{
			System.out.println(arr[i]);
		}
	}
}
		
		
		
