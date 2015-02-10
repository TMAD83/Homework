//Thomas Madigan
//tfmadigan12@ole.augie.edu
//RockPaperScissor.java
import java.util.Scanner;
import java.util.Random;
import java.util.Date;
public class RockPaperScissor
{  
	/*Desc: The program will tell the user what time it is when they start. The 
			program will then pay a game of rock, paper and scissors and will 
			compute who won and then will ask if the user if they want to play 
			again. When the user is finished the program will tell the user the
			total amount of time played in seconds*/
	//Input: The user will enter the r, p, or s for their call and will put down
	//		 if they want to play again 
	/*Output: Prints on the screen who won what the computer had and if the user
			  wants to play again. Also will print out the total amount of games
			  tied, won, and lost. Also prints the time started and the total 
			  time spent playing*/
	public static void main(String[] args) 
	{		
		Scanner keyboard=new Scanner(System.in);
     		Random r=new Random();				
		char userCall='p', computerCall='p', again='y', result='u';
		int userWins=0, userLosses=0, userTies=0;
		Date d = new Date();
		System.out.println("Welcome! It is " + d.toString());			
		while (again=='y') {
			System.out.print("Please call (p, r, s): ");		
			userCall= keyboard.nextLine().charAt(0);
			computerCall=generateComputerCall(r);			
			result=whoWin(computerCall, userCall);   			
			switch (result)	{
				case 'u': 	System.out.print("\tI have "+ computerCall+", you won. ");	
					userWins++;
					break;
				case 'c': 	System.out.print("\tI have "+ computerCall+", you lost. ");	
					userLosses++;
					break;
				case 't': 	System.out.print("\tI have "+ computerCall+", we tied. ");	
					userTies++;
					break;
			}
			System.out.print("Play again? (y/n):");
			again= keyboard.nextLine().charAt(0);
		}
		printReport (userWins, userLosses, userTies);
		printTimeReport (d);
	}
	//Desc: Generates the call that the computer will use
	//Return: Will return either r, p, or s as a char
	public static char generateComputerCall(Random r)
	{
		int j=r.nextInt(3);
		char ch='0';
		switch (j)
		{
			case 0:	ch='r'; break;
			case 1: ch='p'; break;
			case 3: ch='s';	break;
		}
		return ch;
	}
	//Desc: Will calculate who won the game or if the game was a tie
	//Return: Will return either u, p, or t as a char
	public static char whoWin(char b, char c)
	{
		char result='0';
		if(b=='p') {
			if(c=='s')
				result='u';
			else if(c=='p')
				result='t';
			else
				result='c';
		}
		if(b=='s') {
			if(c=='s')
				result='t';
			else if(c=='p')
				result='c';
			else
				result='u';
		}
		if(b=='r') {
			if(c=='s')
				result='c';
			else if(c=='p')
				result='u';
			else
				result='t';
		}
		return result;
	}
	//Desc: Finds and prints the amount of games won, lost, and tied
	//Output: Prints the games won, lost, and tied
	public static void printReport(int i, int j, int k)
	{
		System.out.println("You won "+i+" games");
		System.out.println("You tied "+j+" games");
		System.out.println("You lost "+k+" games");
	}
	//Desc: Calculates the total time in seconds playing the game
	//Output: Will print the Total amount of time in seconds spent playing the game
	public static void printTimeReport(Date d)
	{
		long j=d.getTime();
		Date c=new Date();
		long i=c.getTime();
		
		System.out.print("The game took "+(i-j)/1000+" seconds");		
	}
}