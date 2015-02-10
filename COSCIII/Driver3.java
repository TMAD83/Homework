//Thomas Madigan, Eric Voss
//tfmadigan12@ole.augie.edu, envoss11@ole.augie.edu
//Driver3.java
public class Driver3
{
	public static void main(String[]args)
    {
        Object[] objArr={"John","Paul","George","Ringo"};
        String[] stringArr = {"Mick", "Keith","Ronnie","Charlie"};
        Generic.bubbleSort(objArr);
        System.out.println(Generic.arrToString(objArr));
        Generic.bubbleSort(stringArr);
        System.out.println(Generic.arrToString(stringArr));
    }
}