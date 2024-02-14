public class LinkedList{
  Item head;
  Item tail;

  public LinkedList() {
    head = null;
    tail = null;
  }

  // Add an item to the end of the list
  public void add(Item x) {
    if (tail == null) {
      tail = x;
      head = x;
    }
    else {
      tail.next = x;
      x.previous = tail;
      tail = x;
    }
  }

  // Remove the given item from the list
  public void remove(Item x) {
    if (x == head) {
      if (x == tail) {
        head = tail = null;
      }
      else {
        head = x.next;
        head.previous = null;
      }
    }
    else {
      if (x == tail) {
        tail = x.previous;
        tail.next = null;
      }
      else {
        x.previous.next = x.next;
        x.next.previous = x.previous;
      }
    }
  }

  // Return a string representation of the list
  public String toString() {
    if (head == null)
      return "[EMPTY]";

    String s = "[H:";
    Item currentItem = head;
    while (currentItem != null) {
      s += currentItem.data;
      if (currentItem != tail)
        s += "]<==>[";
      currentItem = currentItem.next;
    }
    return s + ":T]";
  }

  // Add up the total data in the list
  public int totalData() {
    return totalData(head);
  }

  // 0 <-> 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 <-> NULL
  // ^ cur head

  //We have done SOMETHING for each node in the list
  //We have added the value of each node in the list
  private int totalData(Item curHead){
    if(curHead == null){
      return 0; //stop because we are at the end of the list
    }
    //Otherwise, do something and move to the next element
    return curHead.getData() + totalData(curHead.getNext());
  }

  // 0 <-> 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 <-> NULL
  // ^ cur head
  // Result: 1 <-> 3 <-> 5 <-> NULL
  public LinkedList getOddValues(){
    LinkedList result = new LinkedList();
    return getOddValues(head, result);
  }

  private LinkedList getOddValues(Item curHead, LinkedList result){
    if(curHead == null){
      //we are at the end of the list
      //What should we do?
      return result;
    }

    //do SOMETHING
    //and then repeat for the rest of the list
    if(curHead.getData() % 2 == 1) {
        result.add(new Item(curHead.getData()));
    }
    return getOddValues(curHead.getNext(), result);
  }


  public LinkedList inCommon(LinkedList otherList){
    return inCommon(head, otherList, new LinkedList());
  }

  public boolean contains(byte data){
    return contains(head, data);
  }

  private boolean contains(Item curHead, byte data){
    if(curHead == null){
      return false;
    }

    if(curHead.getData() == data){
      return true;
    }

    return contains(curHead.getNext(), data);
  }

  private LinkedList inCommon(Item curHead, LinkedList otherList, LinkedList result){
    if(curHead == null){
      //we are at the end of the list
      //What should we do?
      return result;
    }

    //Do SOMETHING
    //If the current node's data is ALSO in the other list's data
    //Then add the current node's data to the result

    if(otherList.contains(curHead.getData())){
      result.add(new Item(curHead.getData()));
    }
    //Repeat for the rest of the list
    return inCommon(curHead.getNext(), otherList, result);

  }

  public static void main(String[] args){
    LinkedList list = new LinkedList();
    list.add(new Item(23));
    list.add(new Item(65));
    list.add(new Item(87));
    list.add(new Item(45));
    list.add(new Item(56));
    list.add(new Item(34));
    list.add(new Item(95));
    list.add(new Item(71)); //476?

    System.out.println(list.totalData());
    System.out.println("Before getOddValues: " + list);
    System.out.println("getOddValues Result: " + list.getOddValues());
    System.out.println("After getOddValues: " + list);

    LinkedList list2 = new LinkedList();
    list2.add(new Item(45));
    list2.add(new Item(76));
    list2.add(new Item(23));
    list2.add(new Item(14));
    list2.add(new Item(98));
    list2.add(new Item(21));
    list2.add(new Item(95));
    System.out.println(list.inCommon(list2));
    System.out.println(list2.inCommon(list));
    System.out.println(list);
  }
}