//Thomas Madigan
//tfmadigan12@ole.augie.edu
//Sort.java
public class Sort				
{
	//Post: Elements in arr sorted in descending order
	public static void bubbleSortD(int[] arr)                    
	{    
		for(int pass=1; pass<arr.length; ++pass)
			for(int i=0; i<arr.length-pass ;++i)
				if(arr[i]<arr[i+1] )
				{
					int temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
				}
	}
	//Post: 	Elements in arr sorted in descending order
	public static void selectionSortD(int[] arr)                 
	{
		for(int pass=0; pass<arr.length-1; ++pass)
		{
			int max=pass;
			for(int i=pass+1; i<arr.length;++i)
				if(arr[i]>arr[max])
				{
					max=i;
				}
				int temp=arr[max];
				arr[max]=arr[pass];
				arr[pass]=temp;
				
		}

	}                                
	//Post: 	Elements in arr sorted in descending order
	public static void insertionSortD(int[] arr)                 
	{                                                  
		for(int pass=1; pass<arr.length; ++pass)
		{
			int pulled=arr[pass];
			int i=pass-1;
			while(i>=0)
			{
				if(pulled>arr[i])
					arr[i+1]=arr[i];
				else break;
				i--;
			}
			arr[i+1]=pulled;
		}
	}                                               
}