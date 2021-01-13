public class Radix{
  public static int nth(int n, int col)
  {
    return Math.abs(n / (int)Math.pow(10, col) % 10);
  }

  public static int length(int n)
  {
    return (int)(Math.log10(Math.abs(n))+1);
  }




// Requires local copy of MyLinkedList
  public static void merge(MyLinkedList original,MyLinkedList[]buckets)
  {
    int length = buckets.length;
    for(int i = 0; i < length; i++)
    {
      original.extend(buckets[i]);
    }
  }

/*
public static void main(String[] args)
{
  for(int i = 0; i < 1; i++)
  {
    String Return_String = "[";

    Return_String = Return_String + (nth(123, 1)) + ", ";
    Return_String = Return_String + (nth(-123, 1)) + ", ";
    Return_String = Return_String + (nth(123, 2)) + ", ";
    Return_String = Return_String + (nth(-123, 2)) + "]";
    System .out.println("Function Output");
    System.out.println(Return_String);
    System.out.println("Expected Output");
    System.out.println("[2, 2, 1, 1]");
    System.out.println("");
    Return_String = "[";
    Return_String = Return_String + (length(123)) + ", ";
    Return_String = Return_String + (length(-123)) + ", ";
    Return_String = Return_String + (length(1203)) + ", ";
    Return_String = Return_String + (length(-1230)) + "]";
    System .out.println("Function Output");
    System.out.println(Return_String);
    System.out.println("Expected Output");
    System.out.println("[3, 3, 4, 4]");
  }*/

}
}
