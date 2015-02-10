import java.util.Scanner;
public class TestBox
{
	//Desc: The program tests the Box class by setting the height width and 
	//		length and gets the surface area and volume
	//Input: The user enters the length, width, and height of the box via 
	//		 the keyboard
	//Output: Will print out the Surface area and the volume of the box
	public static void main(String[]args)
	{
		Scanner f=new Scanner(System.in);
		Box b1=new Box();
		System.out.print("Enter the length of the box: ");
		double length=f.nextDouble();
		System.out.print("Enter the width of the box: ");
		double width=f.nextDouble();		
		System.out.print("Enter the height of the box: ");
		double height=f.nextDouble();
		b1.setHeight(height);
		b1.setLength(length);
		b1.setWidth(width);
		double SurfaceArea=b1.getSurfaceArea();
		double Volume=b1.getVolume();
		System.out.println("The surface area is: "+SurfaceArea);
		System.out.println("The volume of the box is: "+Volume);
	}
}