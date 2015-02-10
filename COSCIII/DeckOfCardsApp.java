//Thomas Madigan
//tfmadigan12@ole.augie.edu
//DeckOfCardsApp.java
import java.util.Scanner;
public class DeckOfCardsApp
{
	//Desc: Prompts the user creates a DeckOfCards object and uses it to print n
	//		cards
	//Input: The user enters in if they want a new or shuffled deck. Then they
	//		 enter how many cards they want to see via the keyboard
	//Output: Prompts the user and displays the cards they want to see on the
	//		  screen
	public static void main(String[] args) 
   	{
		Scanner f=new Scanner(System.in);
		DeckOfCards d=DeckOfCards.getDeck();
		System.out.print("New deck or shuffled deck? N/S: ");
		char ch=f.nextLine().charAt(0);
		if (ch=='S' || ch=='s') d.shuffle();
 		System.out.print("How many cards do you want?");
		int n= f.nextInt();
		for (int i=0; i<n; ++i)
			System.out.println(d.deal());
	}
}