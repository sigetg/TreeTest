/*
 * Author: Amittai Aviram - aviram@bc.edu
 */

public class SinglyLinkedListBasedQueue<T> implements Queue<T>, Iterable<T> {

  private SinglyLinkedList<T> buffer;

  public SinglyLinkedListBasedQueue() {
    buffer = new SinglyLinkedList<>();
  }

  @Override
  public int size() {
    return buffer.size();
  }

  @Override
  public boolean isEmpty() {
    return buffer.isEmpty();
  }

  @Override
  public void enqueue(T entry) {
    buffer.addLast(entry);
  }

  @Override
  public T dequeue() {
    return buffer.removeFirst();
  }

  @Override
  public T first() {
    return buffer.first();
  }

  @Override
  public java.util.Iterator<T> iterator() {
    return buffer.iterator();
  }

  public static <T> void printQueue(SinglyLinkedListBasedQueue<T> queue) {
    for (T element : queue) {
      System.out.print(element + " ");
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    Queue<Integer> queue = new SinglyLinkedListBasedQueue<>();
    System.out.print("> ");
    while (true) {
      String input = scanner.next();
      if (input.equals("q")) {
        return;
      } else if (input.equals("d")) {
        System.out.println(queue.dequeue());
      } else {
        queue.enqueue(Integer.parseInt(input));
      }
      printQueue((SinglyLinkedListBasedQueue<Integer>)queue);
      System.out.print("> ");
    }
  }

}
