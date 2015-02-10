//Thomas Madigan, Eric Voss
//tfmadigan12@ole.augie.edu, envoss11@ole.augie.edu
//Time24.java
import java.util.StringTokenizer;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Time24
{
	private int hour;
	private int minute;
	//Post: Sets the hour value in the range 0 to 23 and the minute value in the range 0 to 59
	private void normalizeTime()
   	{
      		int extraHours = minute / 60;
      		minute %= 60;
      		hour = (hour + extraHours) % 24;
   	}
	/**
		Initializes this Time24 object<p>
		<b>Post:</b><br>hour and minute of this Time24 object both initialized to 0<p>
	*/
	public Time24()
   	{
   		this(0,0);		//calls the 2-argument constructor of class Time24
   	}
	/**
		Initializes this Time24 object<p>
		<b>Pre:</b><br>h and m cannot be negative<p>
		<b>Post:</b><br>hour and minute of this Time24 object initialized to h and m 
		respectively.  This operation will normalize the time if necessary (e.g. 
		9:75 is stored as 10:15).<p>
		<b>Throw:</b><br>IllegalArgumentException if h or m is negative<p>
	*/
	public Time24(int h, int m)
   	{
    	setTime(h, m);
  	}
	/**
		Sets the hour and minute of this Time24 object to a particular time<p>
		<b>Pre:</b><br>h and m cannot be negative<p>
		<b>Post:</b><br>hour and minute of this Time24 object set to h and m 
		respectively.  This operation will normalize the time if necessary (e.g. 
		9:75 is stored as 10:15).<p>
		<b>Throw:</b><br>IllegalArgumentException if h or m is negative<p>
	*/
	public void setTime(int h, int m)
	{
		if (h < 0 || m < 0)
        throw new IllegalArgumentException("Time24.setTime: argument"
		+ " must not be negative");
      	this.hour = h;
   		this.minute = m;
		normalizeTime();
   	}
	/**
		Adds minutes to this Time24 object <p>
		<b>Pre:</b><br>m cannot be negative<p>
		<b>Post:</b><br>This Time24 object set to m minutes later.  This operation will 
		normalize the time if necessary (e.g. 9:75 is stored as 10:15).<p>
		<b>Throw:</b><br>IllegalArgumentException if m is negative<p>
	*/
	public void addTime(int m)
   	{
		if(m<0)
			throw new IllegalArgumentException("Time24.addTime: argument can't be" 			+"negative");
		this.minute+=m;
		normalizeTime();
   	}
	/**
		Measures the interval from this Time24 object to another time<p>
		<b>Return:</b><br>The interval from this Time24 object to t as a Time24 
	*/
	public Time24 interval(Time24 t)
   	{
		int curTime=this.hour*60+this.minute;
		int tTime=t.hour*60+t.minute;
		if(tTime<curTime)
			tTime+=24*60;
		return new Time24(0, tTime-curTime);
   	}
	/**
		Gets the hour value of this Time24 object<p>
		<b>Return:</b><br>The hour value of this Time24 object<p>
	*/
	public int getHour()
   	{ 
		return hour; 
	}
	/**
		Gets the minute value of this Time24 object<p>
		<b>Return:</b><br>The minute value of this Time24 object<p>
	*/
	public int getMinute()
   	{ 
		return minute; 
	}
	/**
	Sees if This.hour and this.minute are equal to the one from the object
	<b>Return:</b><br>True if they are the same false if they are not<p>
	*/
	public boolean equals(Object j)
	{
		Time24 t=(Time24)(j);
		if((t.getHour()==hour)&&(t.getMinute()==minute))
			return true;
		return false;
	}
	/**
		Converts this Time24 object to a string<p>
		<b>Return:</b><br>This Time24 object as a String in the form "hh:mm"<p>
	*/
	public String toString()
   	{
		DecimalFormat f=new DecimalFormat("00");
		return hour+":"+f.format(minute);
   	}
	/**
		Reads in from the keyboard the hour and the minute<p>
		<b>Input:</b><br>read in from the keyboard to fill the hour and the minute
		in the form "hh:mm"<p>
		<b>Post:</b><br>Sets the hour and the minute to hh and mm when read in from
		the keyboard<p>
	*/
	public void readTime(Scanner f)
	{
		f=new Scanner(System.in);
		String [] arr=f.nextLine().split(":");
		setTime(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
	}
}