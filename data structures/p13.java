import java.util.*;
class p13
{
	public static int linearSearch(int[] array, int target)
	{
		for(int i=0; i<array.length; i++)
		{
			if(array[i]==target)
			{
				return i;
			}
		}
		return -1;
	}
	
	
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of elements in the array: ");
		int size = input.nextInt();
		int[] array = new int[size];
		System.out.println("Enter elements to the array: ");
		for(int i=0; i<size; i++)
		{
			array[i] = input.nextInt();
		}
		System.out.println("Enter element to search: ");
		int target = input.nextInt();
		int index = linearSearch(array, target);
		if(index!=-1)
		{
			System.out.println("Element found at index " + index);
		}
		else
		{
			System.out.println("Element not found in array");
		}
	}
}
			
			
