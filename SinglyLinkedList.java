/*
 * Author: Amittai Aviram - aviram@bc.edu
 */

public class SinglyLinkedList<T> implements SerialAccess<T>, Iterable<T> {

  private class Node {

    private T value;
    private Node next;

    public Node(T value) {
      this.value = value;
    }

    public T getValue() {
      return value;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node next) {
      this.next = next;
    }

    @Override
    public String toString() {
      return value.toString();
    }
  }

  private class ListIterator implements java.util.Iterator<T> {

    private Node current;
    private Node previous;

    ListIterator() {
      current = SinglyLinkedList.this.head;
    }

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public T next() {
      T answer = current.getValue();
      previous = current;
      current = current.getNext();
      return answer;
    }
  }

  private Node head;
  private Node tail;
  int size;

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public T first() {
    return head.getValue();
  }

  @Override
  public T last() {
    return tail.getValue();
  }

  @Override
  public void addFirst(T value) {
    Node newNode = new Node(value);
    if (isEmpty()) {
      tail = head = newNode;
    } else {
      newNode.setNext(head);
      head = newNode;
    }
    ++size;
  }

  @Override
  public void addLast(T value) {
    Node newNode = new Node(value);
    if (isEmpty()) {
      tail = head = newNode;
    } else {
      tail.setNext(newNode);
      tail = newNode;
    }
    ++size;
  }

  @Override
  public T removeFirst() {
    if (isEmpty()) {
      return null;
    }
    T answer = head.getValue();
    if (head == tail) {
      head = tail = null;
    } else {
      head = head.getNext();
    }
    --size;
    return answer;
  }

  @Override
  public T removeLast() {
    if (isEmpty()) {
      return null;
    }
    Node previous = head;
    while (previous != tail) {
      previous = previous.getNext();
    }
    T answer = tail.getValue();
    if (tail == head) {
      head = tail = null;
    } else {
      tail = previous;
      tail.setNext(null);
    }
    --size;
    return answer;
  }

  @Override
  public void clear() {
    tail = head = null;
  }

  @Override
  public java.util.Iterator<T> iterator() {
    return new ListIterator();
  }

  public static <T> void print(SinglyLinkedList<T> list) {
    for (T element : list) {
      System.out.print(element + " ");
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    System.out.print("> ");
    while (true) {
      String command = scanner.next();
      switch (command.charAt(0)) {
        case 'a':
          int value = scanner.nextInt();
          if (command.charAt(1) == 'f') {
            list.addFirst(value);
          } else {
            list.addLast(value);
          }
          break;
        case 'f':
          System.out.println(list.first());
          break;
        case 'r':
          if (command.charAt(1) == 'f') {
            System.out.println(list.removeFirst());
          } else {
            System.out.println(list.removeLast());
          }
          break;
        default:
          return;
      }
      print(list);
    }
  }
}
