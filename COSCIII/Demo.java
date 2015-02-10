//Thomas Madigan, Eric Voss
//tfmadigan12@ole.augie.edu, envoss11@ole.augie.edu
//Demo.java
public class Demo
{
	public static void main(String[]args)
	{
		Time24 t1=new Time24(2,40);
		Time24 t2=new Time24(3,40);
		Time24 t3=new Time24(2,40);
		System.out.println(t1.equals(t2));
		System.out.println(t1.equals(t3));
	}
}