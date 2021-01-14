public class Radix{
  public static int nth(int n, int col)
  {
    return Math.abs(n / (int)Math.pow(10, col) % 10);
  }

  public static int length(int n)
  {
    return (int)(Math.log10(Math.abs(n))+1);
  }

/*
  public static void merge(MyLinkedList original,MyLinkedList[]buckets)
  {
    int length = buckets.length;
    for(int i = 0; i < length; i++)
    {
      original.extend(buckets[i]);
    }
  } */
  /*
  SECOND PART!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  (added after class)
  You are given a doubly linked list class of integers SortableLinkedList. (Attached to the post)
  Do not commit this SortableLinkedList file!

  4. Modify your merge: */
  public static void merge( SortableLinkedList original, SortableLinkedList[]buckets)
  {
    int length = buckets.length;
    for(int i = 0; i < length; i++)
    {
      original.extend(buckets[i]);
    }
  }

  // Do NOT modify the SortableLinkedList class.

  // 5. Write a method that sorts non-negative integer values:
  public static void radixSortSimple(SortableLinkedList data)
  {
    int Length_Greatest_Int = 0;
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for(int i = 0 ; i < 10; i++)
    {
      buckets[i] = new SortableLinkedList();
    }
    for(int i = 0; i < data.size(); i++)
    {
      int Current = data.get(i);
      Length_Greatest_Int = Integer.max(length(Current), Length_Greatest_Int);
      buckets[nth(Current, 0)].add(Current);
    }

    while(data.size() != 0)
    {
      data.remove(0);
    }
    merge(data,buckets);

    for(int i = 1; i < Length_Greatest_Int; i++)
    {
      buckets = new SortableLinkedList[10];
      for(int j = 0; j < 10; j++)
      {
        buckets[j] = new SortableLinkedList();
      }
      for(int j = 0; j < data.size(); i++)
      {
        int Current = data.get(j);
        buckets[nth(Current, i)].add(Current);
      }

      while(data.size() != 0)
      {
        data.remove(0);
      }
      merge(data,buckets);

    }
  }

  // 6. Write a method that sorts any integer values:
  public static void radixSort(SortableLinkedList data)
  {
    SortableLinkedList Positive = new SortableLinkedList();
    SortableLinkedList Negative = new SortableLinkedList();

    while(data.size() != 0)
    {
      int Current = data.get(0);
      if(Current < 0)
      {
        Negative.add(Current * -1);
      }
      else
      {
        Positive.add(Current);
      }
      data.remove(0);
    }
    radixSortSimple(Positive);
    radixSortSimple(Negative);

    for(int i = 0 ; i < Negative.size(); i++)
    {
      data.set(i, data.get(i)*-1);
    }
    data.extend(Negative);
    data.extend(Positive);
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
