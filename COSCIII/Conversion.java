//Conversion.java
package myJavaLib.util;  				//line 2
/**
	Provides common temperature conversion operations
*/
public class Conversion				
{
	private Conversion(){}			//line 8	
	/**
	Convert a Fahrenheit degree to Celsius<p>
	<b>Pre:</b><br>fah is in degree Fahrenheit<p>
	<b>Return:</b><br>The degree Celsius that is equivalent to fah<p>
	*/
   	public static double fahToCel (double fah) 
   	{
		return (fah-32)*5/9;
	}		
	/**
		Convert a Celsius degree to Fahrenheit<p>
		<b>Pre:</b><br>cel is in degree Celsius<p>
		<b>Return:</b><br>The degree Fahrenheit that is equivalent to cel<p>
	*/
   	public static double celToFah(double cel) 
   	{
		return cel*9/5+32;
	}		
}