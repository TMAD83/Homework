public class Student implements Duty
{
	private int id;
	public Student()
	{
		this.id=-1;
	}
	public Student(int id)
	{
		this.id=id;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public int getId()
	{
		return id;
	}
	public String getDuty()
	{
		return "Duty of student id "+id+" is to study 40 hours a week";
	}
}