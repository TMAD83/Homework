//Thomas Madigan
//tfmadigan12@ole.aguie.edu
//Sort.java
import java.util.Random;
public class Sort
{
	//Desc: Creates an array and fills it with 100 random numbers and then
	//		calls insertionSort to sort the array.
	public static void main(String[]args)
	{
		int[] arr=new int[10];
		Random r=new Random();
		for(int i=0; i<arr.length; ++i)
			arr[i]=r.nextInt(100);
		System.out.print("Before: ");
		for(int i=0; i<arr.length; ++i)
			System.out.print(arr[i]+" ");
		System.out.println();
		insertionSort(arr, arr.length-1);
		System.out.print("After: ");
		for(int i=0; i<arr.length; ++i)
			System.out.print(arr[i]+" ");
	}
	//post: Sorts the array arr from least to greatest
	public static void insertionSort(int []arr,int high)
	{
		if(high>0)
		{
			insertionSort(arr,high-1);
			if(arr[high-1]>arr[high])
			{
				int temp=arr[high-1];
				arr[high-1]=arr[high];
				arr[high]=temp;
			}
			insertionSort(arr,high-1);
		}
	}
}