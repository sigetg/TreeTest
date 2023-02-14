/*
 * Author: Amittai Aviram - aviram@bc.edu
 */

public class TreeTest {

  public static void main(String[] args) {
    BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    tree.printInInorder();
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    System.out.println("Add elements to build the tree. Enter \"q\" to quit.");
    System.out.print("> ");
    while (scanner.hasNextInt()) {
      tree.add(scanner.nextInt());
      tree.printInRankOrder();
      tree.printInInorder();
      System.out.print("> ");
    }
    scanner.next();
    tree.printInInorder();
    tree.printTreeGraph("tree.dot");
    System.out.println("Find elements in the tree. Enter \"q\" to quit.");
    System.out.print("> ");
    while (scanner.hasNextInt()) {
      int probe = scanner.nextInt();
      if (tree.find(probe)) {
        System.out.println("Found: " + probe);
      } else {
        System.out.println("Not found: " + probe);
      }
      System.out.print("> ");
    }
    scanner.next();
    tree.printInRankOrder();
    System.out.println("Remove elements from the tree. Enter \"q\" to quit.");
    System.out.print("> ");
    while (!tree.isEmpty() && scanner.hasNextInt()) {
      try {
        tree.remove(scanner.nextInt());
      } catch (java.util.NoSuchElementException | IllegalArgumentException e) {
        System.out.println(e);
      }
      tree.printInRankOrder();
      tree.printInInorder();
      if (!tree.isEmpty()) {
        System.out.print("> ");
      }
    }
  }
}
