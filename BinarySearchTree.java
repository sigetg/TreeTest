/*
 * Author: George Sigety - sigetyg@bc.edu
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;

public class BinarySearchTree<T extends Comparable<T>> implements BinaryTree<T> {

  private class Node {
    private T element;
    private Node right;
    private Node left;
    private Node parent;

    public Node(T element) {
      this.element = element;
    }

    public Node getRight() {
      return right;
    }

    public T getElement() {
      return element;
    }

    public Node getLeft() {
      return left;
    }

    public Node getParent() {
      return parent;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public void setRight(Node right) {
      this.right = right;
    }

    public void setElement(T element) {
      this.element = element;
    }

    public void setParent(Node parent) {
      this.parent = parent;
    }

    public boolean hasLeft() {
      if (left == null) {
        return false;
      } else {
        return true;
      }
    }

    public boolean hasRight() {
      if (right == null) {
        return false;
      } else {
        return true;
      }
    }

    @Override
    public String toString() {
      return element.toString();
    }

    public boolean isLeft() {
      if (parent != null) {
          if (((parent.getLeft()).getElement()) == element) {
              return true;
          }
      }
      return false;
  }
}

  public Node root = null;

  public void add(T element) {
    Node me = new Node(element);
    if (isEmpty()) {
      root = me;
      size++;
    } else {
      size++;
    add(me, root);
    }
  }


  private void add(Node me, Node root) {
    if (!(me.getElement().compareTo(root.getElement()) == 1)) {
      if (root.getLeft() == null) {
        root.setLeft(me);
        me.setParent(root);
      } else {
        root = root.getLeft();
        add(me, root);
      }

    } else {
      if (root.getRight() == null) {
        root.setRight(me);
        me.setParent(root);
      } else {
        root = root.getRight();
        add(me, root);
      }
    }
  }

  public boolean find(T element) {
      return find(root, element) != null;
  }

  private Node find(Node root, T element) {
      Node myNode = null;
      boolean hate = (root.getElement().equals(element));
      if (hate == true) {
          myNode = root;
          return myNode;
      }
      if ((root.getElement()).compareTo(element) == 1) {
          if (root.hasLeft()) {
              return find(root.getLeft(), element);
          } else {
              return null;
          }
      } else {
          if (root.hasRight()) {
              return find(root.getRight(), element);
          } else {
              return null;
          }
      }
  }

  public void remove(T element) {
    Node gone;
    gone = find(root, element);
    if (gone == null) {
        throw new NoSuchElementException("No such element in the tree: " + String.valueOf(element));
    }
    if (gone.getLeft() != null && gone.getRight() != null) {
        throw new IllegalArgumentException(
                "Cannot remove " + String.valueOf(element) + " because it has two children. ");
    }
      if (gone.getParent() == null) {
          if (gone.getLeft() != null) {
              root = gone.getLeft();
              (gone.getLeft()).setParent(null);
          }
          if (gone.getRight() != null) {
              root = gone.getRight();
              (gone.getRight()).setParent(null);
          }
      }
      if (gone.getRight() != null && gone.getLeft() == null && !(gone.getParent() == null)) {
          (gone.getRight()).setParent(gone.getParent());
          if (gone.isLeft()) {
              (gone.getParent()).setLeft(gone.getRight());
          } else {
              (gone.getParent()).setRight(gone.getRight());
          }
      }
      if (gone.getLeft() == null && gone.getRight() == null) {
          if (gone.getParent() == null) {
              root = null;
          } else {
              if (gone.isLeft()) {
                  (gone.getParent()).setLeft(null);
              } else {
                  (gone.getParent()).setRight(null);
              }
          }
      }
      if (gone.getLeft() != null && gone.getRight() == null && gone.getParent() != null) {
          (gone.getLeft()).setParent(gone.getParent());
          if (gone.isLeft()) {
              (gone.getParent()).setLeft(gone.getLeft());
          } else {
              (gone.getParent()).setRight(gone.getLeft());
          }
      }
      size = size - 1;
  }

  public int size = 0;

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    if (size ==0) {
      return true;
    } else {
      return false;
    }
  }

  public void printInPreorder() {
    if (size > 0) {
      printInPreorder(root);
      System.out.println("");
    } else {
      System.out.println("Empty tree.");
    }
  }

  private void printInPreorder(Node root) {
    if (root == null) {
      return;
    }
    System.out.print(root.getElement() + " ");
    printInPostorder(root.getLeft());
    printInPostorder(root.getRight());
  }

  public void printInInorder() {
    if (size > 0) {
      printInInorder(root);
      System.out.println("");
    } else {
      System.out.println("Empty tree.");
    }
  }

  private void printInInorder(Node root) {
    if (root == null) {
      return;
    }
    printInInorder(root.getLeft());
    System.out.print(root.getElement() + " ");
    printInInorder(root.getRight());
  }

  public void printInPostorder() {
    if (size > 0) {
      printInPostorder(root);
      System.out.println("");
    } else {
      System.out.println("Empty tree.");
    }
  }

  private void printInPostorder(Node root) {
    if (root == null) {
      return;
    }
    printInPostorder(root.getLeft());
    printInPostorder(root.getRight());
    System.out.print(root.getElement() + " ");
  }


  public void printInRankOrder() {
    if (isEmpty()) {
      System.out.println("Empty tree.");
      return;
    }
    Queue<Node> queue = new SinglyLinkedListBasedQueue<>();
    queue.enqueue(root);
    int rank = 0;
    while (!queue.isEmpty()) {
      Node node = queue.dequeue();
      int depth = depth(node);
      if (depth != rank) {
        rank = depth;
        System.out.println("");
      }
      System.out.print(node.getElement() + " ");
      if (node.getLeft() != null) {
        queue.enqueue(node.getLeft());
      }
      if (node.getRight() != null) {
        queue.enqueue(node.getRight());
      }
    }
    System.out.println("");
  }

  public void printTreeGraph(String fileName) {
    try {
      FileWriter writer = new FileWriter(fileName);
      writer.write("digraph Tree {\n");
      Queue<Node> queue = new SinglyLinkedListBasedQueue<>();
      queue.enqueue(root);
      while (!queue.isEmpty()) {
        Node node = queue.dequeue();
        if (node.getLeft() != null) {
          writer.write("\t" + node + " -> " + node.getLeft());
          queue.enqueue(node.getLeft());
        }
        if (node.getRight() != null) {
          writer.write("\t" + node + " -> " + node.getRight());
          queue.enqueue(node.getLeft());
        }
      }
      writer.close();
    } catch (IOException e) {
        System.out.println(e);
      }
    }

  public int depth(Node node) {
    int depth = 0;
    while (node != root) {
      node = node.getParent();
      ++depth;
    }
    return depth;
  }
}
