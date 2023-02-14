/*
 * Author: Amittai Aviram - aviram@bc.edu
 */

public interface SerialAccess<T> {
  int size();
  boolean isEmpty();
  T first();
  T last();
  void addFirst(T item);
  void addLast(T item);
  T removeFirst();
  T removeLast();
  void clear();
}
