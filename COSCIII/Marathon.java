//Thomas Madigan
//tfmadigan12@ole.augie.edu
//Marathon.java
import java.util.*;
import java.io.*;
class Runner
{
	private String name;
	private Time24 raceTime;
	//Post: The Runner object initialized with name="unknown" and raceTime=0:0.
	public Runner()
    {
   		name="unknown";
		raceTime=new Time24(0,0);
   	}
   	//Post: The Runner object initialized with name=s and raceTime=t.
	public Runner(String s, Time24 t)
   	{
    	name=s;		
		raceTime=new Time24(t.getHour(), t.getMinute());	
    }
    //Return: The name of the Runner object
	public String getName()
   	{ 
		return name; 
	}
	//Return: The raceTime of the Runner object
	public Time24 getRaceTime()
   	{ 
		return new Time24(raceTime.getHour(), raceTime.getMinute()); 
	}	
	//Post: Changes name to s
	public void setName(String s)
	{
		name=s;
	}
	//Post: Sets the race time to t
	public void setRaceTime(Time24 t)
	{
		raceTime=t;
	}
	//Pre: 	f has a line in the following format ready to be read:
	//		name hh:mm where name is a String and hh, mm are integers.
	//	    The token delimiters of f have been set to white space 
	//		characters and the colon by the caller.
	//Post: The line read in from f, the name and the time stored in 
	//		the Runner object
	public void read(Scanner f)
	{
		this.name=f.next();
		raceTime.setTime(f.nextInt(), f.nextInt());
	}
	//Desc:	Compare 2 Runner objects based on raceTime
	//Return: 1 if current object's raceTime > r's raceTime 0 if 
	//		  current object's raceTime == r's raceTime
	public int compareTo(Runner r)
	{
		Time24 t=r.getRaceTime();
		int originalTime=raceTime.getHour()*60+raceTime.getMinute();
		int testTime=t.getHour()*60+t.getMinute();
		if(originalTime>testTime)
			return 1;
		else if(originalTime<testTime)
			return -1;
		else
			return 0;
	}
}
public class Marathon
{
	//Desc:	Output the name and time of the runner who came in first, as well as the
	//		name and time of the runner who came in last in a marathon race 
	//		(assuming there are no ties).
	//Input: A text file named marathon.txt containing the name and time of each
	//		 participant in the following format (the file has at least 1 participant,
	//		 name is just 1 word with no space, and name and time are separated by tabs,
	//		 blanks, and newlines):
	//		 John	2:40
	//		 Paul	3:20
	//		 Carl	2:10
	//Output: The name and time of the runner who came in first, as well as the name and
	//		  time of the runner who came in last printed to the screen.
	public static void main(String[]args) throws FileNotFoundException
	{
		Runner first=new Runner();
		Runner last=new Runner();
		Scanner f=new Scanner(new File("marathon.txt"));
		f=f.useDelimiter("\t|:|\r\n");
		first.read(f);
		findMax(f, first);
		f=new Scanner(new File("marathon.txt"));
		f=f.useDelimiter("\t|:|\r\n");
		last.read(f);
		findMin(f, last);
		System.out.println("First Place "+first.getName()+" "+first.getRaceTime());
		System.out.println("Last Place "+last.getName()+" "+last.getRaceTime());
	}
	//Desc: Reads through the scanner and finds the shortest time and sets this as the
	//		first runner
	public static void findMax(Scanner f, Runner first)
	{
		while(f.hasNext())
		{
			Runner temp=new Runner();
			temp.read(f);
			if(first.compareTo(temp)==1)
			{
				first.setName(temp.getName());
				first.setRaceTime(temp.getRaceTime());
				break;
			}
		}
	}
	//Desc: Reads through the scanner and finds the largest time and sets this as the
	//		last runner
	public static void findMin(Scanner f, Runner last)
	{
		while(f.hasNextLine())
		{
			Runner temp=new Runner();
			temp.read(f);
			if(last.compareTo(temp)==-1)
			{
				last.setName(temp.getName());
				last.setRaceTime(temp.getRaceTime());
				break;
			}
		}
	}
}