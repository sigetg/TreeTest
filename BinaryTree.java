/*
 * Author: George Sigety - sigetyg@bc.edu
 */

public interface BinaryTree<T> {

  void add(T element);
  boolean find(T element);
  void remove(T element);
  int size();
  boolean isEmpty();
  void printInPreorder();
  void printInInorder();
  void printInPostorder();
  void printInRankOrder();
  void printTreeGraph(String fileName);
}
