//Thomas Madigan
//tfmadigan12@ole.augie.edu
//Student.java
import java.util.Vector;
import java.io.*;
import java.util.Scanner;
class Student implements java.io.Serializable
{
    private int id;
   	private String name;
	private int age;
	public Student () 
	{ 
		id=0;
		name="";
		age=0;
	}
	public Student (int id, String name, int age) 
	{ 
		setId(id);
		setName(name);
		setAge(age);
	}
	public void setId( int s ) 
	{ 
		this.id=s;
	}
   	public int getId() 
	{ 
		return id;
	}
	public void setName(String s) 
	{ 
		this.name=s;
	}
   	public String getName() 
	{ 
		return name;
	}
	public void setAge( int a ) 
	{ 
		age=a;
	}
   	public int getAge()
	{ 
		return age;
	}
	//compare based on id
	public boolean equals(Object obj)	
	{
		if(((Student)obj).getId()==this.id)
			return true;
		return false;
	}
	//compare based on id
	public int compareTo(Student stu)				
	{
		if(stu.getId()>this.id)
			return -1;
		else
			return 1;
	}
	public String toString()
	{
		return "Id: "+getId()+" Name: "+getName()+" Age: "+getAge();
	}
}
public class StudentDB
{
	private static Scanner keyboard=new Scanner(System.in);
	//Desc: 	Maintains a database of Student records.  The database is stored in binary file 
	//	Student.data
	//Input:	User enters commands from keyboard to manipulate database.
	//Output:Database updated as directed by user.
   	public static void main(String[] args) throws IOException, ClassNotFoundException
   	{
		Vector<Student> v=new Vector<Student>();
   		File s=new File("Student.data");
		if (s.exists()) loadStudent(v);
		int choice=5;					
		do {
			System.out.println("\t1. Add a Student record");	
			System.out.println("\t2. Remove a Student record");	
   			System.out.println("\t3. Print a Student record");	
   			System.out.println("\t4. Print all Student records");	
   			System.out.println("\t5. Quit");	
			choice= keyboard.nextInt();
			keyboard.nextLine();
   			switch (choice)						
			{
				case 1: addStudent(v); break;		
				case 2: removeStudent(v); break;		
				case 3: printStudent(v); break;		
				case 4: printAllStudent(v); break;		
				default:  break;	
			}
		} while (choice!=5);
 		storeStudent(v); 
	}		
	//Input: 	user enters an integer (id), a string (name), an integer (age) from the 
	//	keyboard all on separate lines
	//Post: 	The input record added to v if id does not exist
	//Output: various prompts as well as "Student added" or "Add failed: Student already exists" 
	//	printed on the screen accordingly
   	public static void addStudent(Vector<Student> v) 
	{
		Student add=new Student();
		Scanner keyboard=new Scanner(System.in);
		System.out.print("Enter the student's ID: ");
		add.setId(keyboard.nextInt());
		System.out.print("Enter the studnet's name: ");
		String name=keyboard.next();
		name+=" "+keyboard.next();
		add.setName(name);
		System.out.print("Enter the studnt's age: ");
		add.setAge(keyboard.nextInt());
		for(int i=0; i<v.size(); ++i)
		{
			if(add.equals(v.get(i)))
			{
				System.out.println("Add failed: Student already exists");
				return;
			}
			if(add.compareTo(v.get(i))==-1)
			{
				v.add(i, add);
				return;
			}
		}
		v.add(add);
	}
	//Input: 	user enters an integer (id) from the keyboard	
	//Post: 	The record in v whose id field matches the input removed from v.
	//Output: various prompts as well as "Student removed" or "Remove failed: Student does not 
	//	exist" printed on the screen accordingly
    public static void removeStudent(Vector<Student> v) 
	{
		Scanner keyboard=new Scanner(System.in);
		Student temp=new Student();
		System.out.print("Enter in a student id: ");
		temp.setId(keyboard.nextInt());
		for(int i=0; i<v.size(); ++i)
			if(temp.equals(v.get(i)))
			{
				v.remove(i);
			}
	}
	//Input: 	user enters an integer (id) from the keyboard	
	//Output: various prompts as well as the record in v whose id field matches the input printed on the 
	//	screen or "Print failed: Student does not exist" printed on the screen accordingly
   	public static void printStudent(Vector<Student> v) 
	{
		Scanner keyboard=new Scanner(System.in);
		Student temp=new Student();
		System.out.print("Enter in a student id: ");
		temp.setId(keyboard.nextInt());
		for(int i=0; i<v.size(); ++i)
			if(temp.equals(v.get(i)))
			{
				System.out.println(v.get(i).toString());	
			}
	}
   	//Output: All records in v printed on the screen.
	public static void printAllStudent(Vector<Student> v) 
	{
		for(int i=0; i<v.size(); ++i)
			System.out.println(v.get(i).toString());
	}
  	//Input: 	Binary file Student.data must exist and contains student records.
	//Post: 	All records in Student.data loaded into vector v.
   	public static void loadStudent(Vector<Student> v) throws IOException, ClassNotFoundException
	{
		ObjectInputStream f=new ObjectInputStream(new FileInputStream("Student.data"));
		try	{
				Vector<Student> v1=(Vector<Student>)(f.readObject());
				for(int i=0; i<v1.size(); ++i)
					v.add(v.get(i));
			}
			catch(EOFException e)
			{
				f.close();
			}
	}
	//Output: All records in v written to binary file Student.data.
   	public static void storeStudent(Vector<Student> v) throws IOException
	{
		ObjectOutputStream f=new ObjectOutputStream(new FileOutputStream("Student.data"));
		f.writeObject(v);
		f.close();
	}	
}