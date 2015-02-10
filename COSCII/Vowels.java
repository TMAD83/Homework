//Thomas Madigan
//tfmadigan12@ole.augie.edu
//Vowels.java
import java.util.Scanner;
public class Vowels
{
	//Desc: The user enters a line and the program splits it into
	//		a char array to count how may of each vowel there is 
	//		in the line
	//Input: The user enters a line and if the user wants to run 
	//		 the program again via the keyboard
	//Output: The number of each occurrence of each vowel is printed
	//		  on the screen
	public static void main(String[] args)
	{
		Scanner f=new Scanner(System.in);
		char again='Y';
		while(again=='Y'||again=='y')
		{
			System.out.print("Enter a line: ");
			String Line=f.nextLine();
			char[] arr=Line.toCharArray();
			int a=0, e=0, i=0, o=0, u=0;
			for(int j=0; j<arr.length; ++j)
				switch(arr[j])
				{
					case 'a':
					case 'A': ++a; break;
					case 'e':
					case 'E': ++e; break;
					case 'i': 
					case 'I': ++i; break;
					case 'o': 
					case 'O': ++o; break;
					case 'u': 
					case 'U': ++u; break;
				}
			NumVowels(a, "a");
			NumVowels(e, "e");
			NumVowels(i, "i");
			NumVowels(o, "o");
			NumVowels(u, "u");
			System.out.print("Again (y/n):");
			again=f.nextLine().charAt(0);
		}
	}
	
	
	
	
	
	
	//Output: Prints on the screen the number of occurrences
	//		  of each vowel
	public static void NumVowels(int j, String s)
	{
		System.out.printf("There are %d %s's\n", j, s);
	}
}