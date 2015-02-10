//Thomas Madigan, Eric Voss
//tfmadigan12@ole.augie.edu, envoss11@ole.augie.edu
//Driver1.java
public class Driver1
{
	public static void main(String[]args)
    {
        Object[] objArr={"John","Paul","George","Ringo"};
        String[] stringArr = {"Mick", "Keith","Ronnie","Charlie"};
        Generic.bubbleSort(objArr);
		System.out.println(Generic.binSearch(objArr, "Paul"));
		System.out.println(Generic.binSearch(objArr, "Ronnie"));
        Generic.bubbleSort(stringArr);
        System.out.println(Generic.binSearch(stringArr, "Paul"));
        System.out.println(Generic.binSearch(stringArr, "Mick"));
    }
}