//Thomas Madigan
//tfmadigan12@ole.augie.edu
//Part4.java
import java.util.*;
import java.io.*; 
class Part4
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Vector<Entry<String, Time24>> v =new Vector<Entry<String, Time24>>();
		Scanner keyboard = new Scanner(System.in);
		Scanner input = new Scanner(new File("data.txt"));
		while (input.hasNext())
		{
			input.useDelimiter(":| |\r\n");
			String s=input.next()+" "+input.next();
			Time24 t=new Time24(Integer.parseInt(input.next()),
			Integer.parseInt(input.next()));
			Entry e=new Entry(s,t);
			v.add(e);
		}
		Collections.sort(v);
   		while (true)
		{
			System.out.print("Enter name: "); 
			String name=keyboard.nextLine();
			if (name.equals("DONE")) break;
			Entry<String, Time24> temp=
			new Entry<String, Time24>(name, new Time24(0,0));
			int index=Collections.binarySearch(v,temp);
			String output="";
			if(Collections.binarySearch(v,temp)<0)
				System.out.println("No such person");
			else
			{
				Time24 t=v.get(index).getValue();
				System.out.println(t.toString());
			}
		}
	}
}