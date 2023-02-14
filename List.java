/*
 * Author: George Sigety - sigetyg@bc.edu
 */

public interface List<T> {
  public int size();
  public boolean isEmpty();
  public T first();
  public T last();
  public void addFirst(T item);
  public void addLast(T item);
  public T removeFirst();
  public T removeLast();
  public void clear();
}
