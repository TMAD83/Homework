//Thomas Madigan
//tfmadigan12@ole.augie.edu
//Part2.java
import java.io.*;
import java.util.*;
public class Part2
{
	public static void main(String[]args) throws FileNotFoundException
	{
		Scanner f=new Scanner(new File("data.txt"));
		Vector<Entry<String,Time24>> v=new Vector<Entry<String,Time24>>();
		while(f.hasNext())
		{
			f.useDelimiter(":| |\r\n");
			String s=f.next()+" "+f.next();			
			Time24 t=new Time24(Integer.parseInt(f.next()),Integer.parseInt(f.next()));
			Entry e=new Entry(s,t);
			v.add(e);
		}
		Collections.sort(v);
		for(int i=0; i<v.size(); ++i)
		{
			Entry e=v.get(i);
			System.out.println(e.toString());
		}	
	}
}