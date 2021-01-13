public class SortTester {
  public static void main(String[] args) {
    SortableLinkedList list = new SortableLinkedList();
    for (int i = 0; i < args.length; i ++) {
      list.add(Integer.parseInt(args[i]));
    }
    Radix.radixSort(list);
    System.out.println(list);
  }
}
