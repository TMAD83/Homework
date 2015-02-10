//Thomas Madigan
//tfmadigan12@ole.augie.edu
//CurrencyExchange.java
public class CurrencyExchange
{
	//Desc: Converts the amount of United States dollars to Hong Kong dollars
	//Pre: d1 is the amount in US dollars
	//Return: The amount of money in US dollars converted to HK dollars
	public static double usToHk(double d1)
	{
		double currency=d1*7.8;
		return currency;
	}
	//Desc: Converts the amount of Hong Kong dollars to United States dollars
	//Pre: d1 is the amount in HK dollars
	//Return: The amount of money in HK dollars converted to US dollars
	public static double hkToUs(double d1)
	{
		double currency=d1/7.8;
		return currency;
	}
}