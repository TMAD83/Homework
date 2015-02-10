//Thomas Madigan
//tfmadigan12@ole.augie.edu
//Demo.java
import java.util.Scanner; 
class negativeNumberException extends Exception
{
	public negativeNumberException()
	{
		super("Negative Number");
	}
}
class zeroException extends Exception
{
	public zeroException()
	{
		super("zero");
	}
}
class tooBigException extends Exception
{
	public tooBigException()
	{
		super("Too big");
	}
}
public class Demo1
{
	//Desc: Display up to 5 random integers
	//Input: A number n entered via the keyboard indicating how many random integers
	//Output: n random integers in the range [0..100) displayed on the screen
	public static void main(String[] args)
	{
		int[] numbers = new int[5];
		int n=0;
		Scanner input = new Scanner(System.in);	
				n=fillNumbers(numbers,  input);
				showNumbers(numbers, n);
	}
	public static int fillNumbers(int[] numbers, Scanner input) 
	{
		System.out.print("How many random numbers you want to see? ");
		int n;
		while(true)
		{
			try
			{
				n=input.nextInt();
				if(n<0) throw new negativeNumberException();
				else if (n==0) throw new zeroException();
				else if (n>5) throw new tooBigException();
				break;
			}
			catch(NumberFormatException err)
			{
				System.out.println("Must enter an integer!");
			}
			catch(negativeNumberException err)
			{
				System.out.println("***negativeNumberException: Negative value is not good"); 
			}
			catch(zeroException err)
			{
				System.out.println("***zeroException: 0 is not good");
			}
			catch(tooBigException err)
			{
				System.out.println("***tooBigException: Value greater than 5 is not good");
			}
		}
		for (int i = 0; i < n; ++i)
			numbers[i] = (int)(Math.random()*100);
		return n;
	}
	//Desc: Takes in an int array and how long the array is
	//output: Prints the random numbers on the screen
	public static void showNumbers(int[] numbers, int n)
	{
		String s="";
		for(int i = 0; i < n; ++i)
		{
			s += numbers[i];
			s += "  ";
		}
		System.out.println(s);
	}
}