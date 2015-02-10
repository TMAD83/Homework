//Thomas Madigan
//tfmadigan12@ole.augie.edu
//DiceApp.java
import java.util.Scanner;
public class DiceApp
{
	//Output: The outcomes of throwing a die 5 times printed on the screen
	public static void main(String[] args)
	{
		Dice d=new Dice();
		Scanner f=new Scanner(System.in);
		for (int i=0; i<3; ++i)
		{
			System.out.print("Hit enter when you are ready to throw your dice");
			f.nextLine();
			d.toss();
			System.out.println("Throwing..."+d.toString());
		}
	}
}
