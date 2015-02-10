//Thomas Madigan
//tfmadigan12@ole.aguie.edu
//BigOAscending.java
import java.util.Random;
public class BigOAscending
{
	//Desc: Calls HWSort methods sortA sortB and sortC and uses these methods
	//		to sort the array arr
	//Output: prints SIZE and how many seconds it takes for sortA, sortB, and sortC to run
	public static void main(String[] args)
	{
		final int SIZE=20000;
		StopWatch sw=new StopWatch();
		Random rnd=new Random();
		int[] arr=new int[SIZE];
		for(int i=0; i<SIZE; ++i)
			arr[i]=rnd.nextInt(100000);
		System.out.println("Array size: "+SIZE);
		sw.start();
		HWSort.sortA(arr, 0, SIZE);
		System.out.printf("%s%.6f\n"," sortA: ", sw.stop() );
		sw.start();
		HWSort.sortB(arr);
		System.out.printf("%s%.6f\n"," sortB: ", sw.stop());
		sw.start();
		HWSort.sortC(arr);
		System.out.printf("%s%.6f\n"," sortC: ", sw.stop());
		
	}
}
/*
				sortA		sortB		sortC
	20000		0.025277	1.253564	0.002691	
	40000		0.035394	4.212119	0.005375
	80000		0.061591	16.141532	0.007341
	160000		0.064098	65.811980	0.011458
	320000		0.115755	299.464657	0.015393
	Big-O		log n		quadratic	log n
*/