//Thomas Madigan
//tfmadigan12@ole.augie.edu
//Palindrome.java
import java.util.Scanner;
public class Palindrome
{
	//Desc: The user enters a string and than isPalindrome is called to check
	//		weather or not the string is a palindrome or not.
	//Input: The user enters in a string via the keyboard
	//Output: The program prompts the user to enter a string and then prints
	//		  if the string is a palindrome or not
	public static void main(String []args)
	{	
		Scanner f=new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s=f.nextLine();
		System.out.println(isPalindrome(s, 0, s.length()-1));		
	}
	//Return: True if s is a palindrome and false if it is not
	public static boolean isPalindrome(String s, int start, int last)
	{		
		if(start>last) return true;
		if(s.charAt(start) !=s.charAt(last))
			return false;
		return isPalindrome(s, start+1, last-1);
	}
}