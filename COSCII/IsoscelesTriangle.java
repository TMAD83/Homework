//Thomas Madigan
//tfmadigan12@ole.augie.edu
//IsoscelesTriangle
public class IsoscelesTriangle extends Shape2D
{
	private double base;
	private double height;
	//Desc: Is the no argument constructor for IsoscelesTriangle
	public IsoscelesTriangle()
	{
		super();
		base=height=0.0;
	}
	//Desc: Creates an IsoscelesTriangle using the base and the height also
	//		calculates the area and the perimeter
	public IsoscelesTriangle(double base, double height)
	{
		super();
		this.base=base;
		this.height=height;
		calcAreaAndPerimeter();
	}
	//Post: Sets this.base to base
	public void setBase(double base)
	{
		this.base=base;
	}
	//Return: returns the base
	public double getBase()
	{
		return base;
	}
	//Post: Sets this.height to height
	public void setHeight(double height)
	{
		this.height=height;
	}
	//Return: Returns the height
	public double getHeight()
	{
		return height;
	}
	//Desc: calculates the area and the perimeter for the triangle
	//Post: area is set to the area and perimeter is set to the perimeter
	public void calcAreaAndPerimeter()
	{
		area=(height*base)/2;
		perimeter=2*height+base;
	}
	//Desc: compares the IsoscelesTriangle passed to it with the current
	//		IsoscelesTriangle
	//Return: returns 1 if the passed triangle is greater than the created
	//		  one, -1 if the created one is greater than the passed one or
	//		  0 if they are the same
	public int compareTo(IsoscelesTriangle t)
	{
		if (area>t.area) return 1;
		else if (area<t.area) return -1;
		else return 0;
	}
	//Desc: Prints the IsoscelesTriangle on the screen using *
	//Output: Prints the triangle on the screen using *
	public void draw()
	{
		double size=height;
		for (int row=1; row<=size; ++row)	
		{						
			for(int blank=0; blank<((height-row)*2-1)/2; ++blank)
				System.out.print(" ");
			for(int star=0; star<row*2-1; ++star)
				System.out.print("*");
			System.out.println("");
		}

	}
	//Return: returns the base height area and perimeter of the triangle
	public String toString()
	{
		return "Base: "+base+" Height: "+height+" Area: "+area+" Perimeter: "+perimeter;
	}
}