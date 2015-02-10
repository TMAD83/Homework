//Thomas Madigan
//tfmadigan12@ole.augie.edu
//CurrencyApp.java
import java.util.Scanner;
public class CurrencyApp
{
	//Desc: Calls the method CurrencyExchange to convert the entered amount of
	//		United States dollars to Hong Kong dollars
	//Input: The user enters the amount of Hong Kong dollars and US dollars via
	//		 the keyboard
	//Output: $US dollars converted to $HK and $HK to $US converted printed on
	//		  the screen
	public static void main(String[]args)
	{
		Scanner f=new Scanner(System.in);
		double $US=0.0;
		double $HK=0.0;
		System.out.print("Please enter a $US amount: ");
		$US=f.nextDouble();
		$HK=CurrencyExchange.usToHk($US);
		System.out.printf("US$%.2f=HK$%.2f\n", $US, $HK);
		System.out.print("Please enter a $HK amount: ");
		$HK=f.nextDouble();
		$US=CurrencyExchange.hkToUs($HK);
		System.out.printf("HK$%.2f=US$%.2f\n", $HK, $US);
	}
}