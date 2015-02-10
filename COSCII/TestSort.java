//Thomas Madigan
//tfmadigan12@ole.augie.edu
//TestSort.java
public class TestSort
{
		//Desc: Tests the sort class by calling it and sorting arr
		//Output: Prints the 3 sorted arrays on the screen
		public static void main(String[] args)
		{
			int[] arr={3,5,6,2,4};
			Sort.bubbleSortD(arr);
			for(int i=0; i<arr.length; ++i)
				System.out.print(arr[i]+" ");
			System.out.println("");
			int[] arr2={4,6,1,5,2};
			Sort.selectionSortD(arr2);
			for(int i=0; i<arr2.length; ++i)
				System.out.print(arr2[i]+" ");
			System.out.println("");
			int[] arr3={7,9,4,3,8,1};
			Sort.insertionSortD(arr3);
			for(int i=0; i<arr3.length; ++i)
				System.out.print(arr3[i]+" ");
		}	
}