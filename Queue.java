/*
 * Author: Amittai Aviram - aviram@bc.edu
 */

public interface Queue<T> {

   void enqueue(T entry);
   T dequeue();
   T first();
   int size();
   boolean isEmpty();
}
