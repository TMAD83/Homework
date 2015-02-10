//Thomas Madigan
//tfmadigan12@ole.augie.edu
//Dice.java
import java.util.Random;
public class Dice
{
	private int value1;
	private int value2;
	private Random r;
	//Post:	This Die initialized randomly to a value in the range 1..6
	public Dice()	
	{
		int die1=getValue1();
		int die2=getValue2();
	}
	//Post:	This Die set randomly to a value in the range 1..6 
	//Return:	This Die object  
	public void toss()
	{
		Random r=new Random();
		value1=r.nextInt(6)+1;
		value2=r.nextInt(6)+1;
	}
	//Return: The face value of the first die value  
	public int getValue1()
	{
		return value1;
	}
	//Return: The face value of the second die
	public int getValue2()
	{
		return value2;
	}
	//Return: The total of both of the face values of the dice
	public int getTotal()
	{
		int totalValue=value1+value2;
		return totalValue;
	}
	//Return:	The value of this Die in the format "Die: value" 
	public String toString()				
	{
		return "Die1: "+value1+" Die2: "+value2+" Total: "+getTotal();
	}
}
