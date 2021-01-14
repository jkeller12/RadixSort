public class Radix{
  public static int nth(int n, int col)
  {
    return Math.abs(n / (int)Math.pow(10, col) % 10);
  }

  public static int length(int n)
  {
    return (int)(Math.log10(Math.abs(n))+1);
  }
  public static void merge( MyLinkedList original, MyLinkedList[]buckets)
  {
    int length = buckets.length;
    for(int i = 0; i < length; i++)
    {
      original.extend(buckets[i]);
    }
  }


  public static void merge( SortableLinkedList original, SortableLinkedList[]buckets)
  {
    int length = buckets.length;
    for(int i = 0; i < length; i++)
    {
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data)
  {
    int Length_Greatest_Int = 0;
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for(int i = 0 ; i < 10; i++)
    {
      buckets[i] = new SortableLinkedList();
    }
    while(data.size() != 0)
    {
      int Current = data.remove(0);
      Length_Greatest_Int = Integer.max(length(Current), Length_Greatest_Int);
      buckets[nth(Current, 0)].add(Current);
    }
    merge(data,buckets);

    for(int i = 1; i < Length_Greatest_Int; i++)
    {
      buckets = new SortableLinkedList[10];
      for(int j = 0; j < 10; j++)
      {
        buckets[j] = new SortableLinkedList();
      }
      while(data.size() != 0)
      {
        int Current = data.remove(0);
        buckets[nth(Current, i)].add(Current);
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
      int Current = data.remove(0);
      if(Current < 0)
      {
        Negative.add(Current * -1);
      }
      else
      {
        Positive.add(Current);
      }
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
}
