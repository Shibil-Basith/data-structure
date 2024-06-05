import java.util.*;
public class p3
{
	public static void main(String args[])
	{
		int n, i, pos;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of elements you want in array: ");
		n = input.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter elements to the array: ");
		for(i=0; i<n; i++)
		{
			arr[i] = input.nextInt();
		}
		System.out.print("Enter position to delete: ");
		pos = input.nextInt();
		
		System.out.println("Array before deleting element: ");
		for(i=0; i<n; i++)
		{
			System.out.println(arr[i]);
		}
		
		for(i=pos-1; i<n-1; i++)
		{
			arr[i] = arr[i+1];
		}
		n--;
		System.out.println("Array after deleting: ");
		for(i=0; i<n; i++)
		{
			System.out.println(arr[i]);
		}
	}
}
		
			
		
