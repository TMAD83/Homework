//Thomas Madigan, Eric Voss
//tfmadigan12@ole.augie.edu, envoss11@ole.augie.edu
//Driver2.java
public class Driver2
{
    public static void main(String[] args)
    {
        Object[] objArr={"John","Paul","George","Ringo"};
        String[] stringArr={"Mick", "Keith","Ronnie","Charlie"};
        Generic.insertionSort(objArr);
        System.out.println(Generic.arrToString(objArr));
        Generic.insertionSort(stringArr);
        System.out.println(Generic.arrToString(stringArr));
    }
}