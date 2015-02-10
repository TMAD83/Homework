//Thomas Madigan
//tfmadigan12@ole.augie.edu
//IntToEng.java
import java.util.Scanner;
public class IntToEng
{
	//Desc: Reads in a number calls intToEnglish and passes it n to convert
	//		the number form into word form
	//Input: Reads in a number via the keyboard
	//Output: Prompts the user to enter in a number using the keyboard also 
	//		  prints the string returned from intToEnglish
	public static void main(String[]args)
	{
		Scanner f=new Scanner(System.in);
		System.out.print("enter a number: ");
		int n=f.nextInt();
		System.out.println(intToEnglish(n));
	}
	//return: The digit in the one's place is concated to intToEnglish(n/10)
	//		  if n is zero it returns an empty string
	public static String intToEnglish(int n)
	{
		String arr[]={"Zero", "One", "Two", "Three", "Four", "Five",
					  "Six", "Seven", "Eight", "Nine"};
		if(n==0) return "";
		return intToEnglish(n/10)+" "+arr[(n%10)];
	}
}