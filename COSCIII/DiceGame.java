//Thomas Madigan
//tfmadigan12@ole.augie.edu
//DiceGame.java
//The screen shot at the end of the handout for chapter 18 is not enough to
//	show if the program is working correctly. This is because it does not show
//	what happens if the player and the computer are tied.
import java.util.Scanner;
public class DiceGame
{
	private static int userTotal;
	private static int pcTotal;
	private static Dice user;
	private static Dice pc;
	private static int wins;
	private static int losses;
	private static int ties;
	//Desc: The program creates 2 dice objects and calls the methods toss,
	//		whoWon, and printReport to toss the dice and prints the results
	//		at the end
	//Input: The user enters if they want to play again via the keyboard
	//Output: Asks the user if they want to play again
	public static void main(String[]args)
	{
		pc=new Dice();
		user=new Dice();
		Scanner keyboard=new Scanner(System.in);
		while(true)
		{
			toss();
			whoWon();
			System.out.print("Play again? (y/n):");
			if(keyboard.next().charAt(0)=='n')
				break;
		}
		printReport();
	}
	//Post: Initialises the user and pc dice objects and gives a value to pcTotal
	//		and userTotal
	//Output: Prints when the tosses are being made and what the totals are for each
	//		  set of dice
	public static void toss()
	{
		user.toss();
		userTotal=user.getTotal();
		System.out.print("User tossing dice...");
		System.out.println("You have "+userTotal);
		pc.toss();
		pcTotal=pc.getTotal();
		System.out.print("Computer tossing dice...");
		System.out.print("Computer has "+pcTotal);
	}
	
	//Post: Adds 1 for each win, loss, and tie
	//Output: Prints the result of the game
	public static void whoWon()
	{
		if(userTotal>pcTotal)
		{
			System.out.print(" You won. ");
			++wins;
		}
		else if(userTotal<pcTotal)
		{
			System.out.print(" You lost. ");
			++losses;
		}
		else
		{
			System.out.print(" You tied. ");
			++ties;
		}
	}
	//Output: Prints on the screen the number of ties wins and losses
	public static void printReport()
	{
		System.out.printf("You won %d games\nYou lost %d games\nYou tied %d games",
						  wins, losses, ties);
	}
}