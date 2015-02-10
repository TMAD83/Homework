//Thomas Madigan
//tfmadigan12@ole.augie.edu
//ParkingGarage.java
import java.util.Scanner;
public class ParkingGarage
{
	//Desc:  	The program computes the cost of parking a car in a public garage at the rate $5.00/hour.
	//			The client will always be charged for whole hours.  For example, if a car parked for 2 
	//			hours and 1 minute, the client will be charged for 3 hours.
	//Input: 	User inputs the entry time and exit time in 24-hr clock format (hh:mm) 
	//Output:	The enter and exit times, the length of time the car is parked and the total charges.
	public static void main(String[]args)
	{
		Scanner keyboard=new Scanner(System.in);
		Time24 arrivalTime=new Time24();
		Time24 exitTime=new Time24();
		System.out.print("Time enters the garage in 24-hr clock format (hh:mm) ");
		arrivalTime.readTime(keyboard);
		System.out.print("Time exits the garage in 24-hr clock format (hh:mm) ");
		exitTime.readTime(keyboard);
		System.out.println("Car enters at: "+arrivalTime.toString());
		System.out.println("Car exits at: "+exitTime.toString());
		Time24 totalTime=arrivalTime.interval(exitTime);
		System.out.println("Parking time: "+totalTime.toString());
		double totalCost=totalTime.getHour()*5;
		if(totalTime.getMinute()!=0)
			totalCost+=5;
		System.out.printf("Charges: $%.2f",totalCost);
	}
}