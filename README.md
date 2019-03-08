# CSCI507
Final Project for Data Structures
Fall 2018
 
 
//----------------------------------------------------------------
// ArrayBoundedStack.java    by Dale/Joyce/Weems         Chapter 2
//
// Implements StackInterface using an array to hold the 
// stack elements.
//
// Two constructors are provided: one that creates an array of a 
// default size and one that allows the calling program to 
// specify the size.
//----------------------------------------------------------------

package ch02.stacks;

public class ArrayBoundedStack<T> implements StackInterface<T> 
{
  protected final int DEFCAP = 100; // default capacity
  protected T[] elements;           // holds stack elements
  protected int topIndex = -1;      // index of top element in stack

  public ArrayBoundedStack() 
  {
    elements = (T[]) new Object[DEFCAP];
  }

  public ArrayBoundedStack(int maxSize) 
  {
    elements = (T[]) new Object[maxSize];
  }

  public void push(T element)
  // Throws StackOverflowException if this stack is full,
  // otherwise places element at the top of this stack.
  {      
    if (isFull())
      throw new StackOverflowException("Push attempted on a full stack.");
    else
    {
      topIndex++;
      elements[topIndex] = element;
    }
  }

  public void pop()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes top element from this stack.
  {                  
    if (isEmpty())
      throw new StackUnderflowException("Pop attempted on an empty stack.");
    else
    {
      elements[topIndex] = null;
      topIndex--;
    }
  }

  public T top()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns top element of this stack.
  {                 
    T topOfStack = null;
    if (isEmpty())
      throw new StackUnderflowException("Top attempted on an empty stack.");
    else
      topOfStack = elements[topIndex];
    return topOfStack;
  }

  public boolean isEmpty()
  // Returns true if this stack is empty, otherwise returns false.
  {              
    return (topIndex == -1); 
  }

  public boolean isFull()
  // Returns true if this stack is full, otherwise returns false.
  {              
    return (topIndex == (elements.length - 1));
  }

  public String toString()
    {
        String x = "[";
        for(int i =topIndex; i >= 1; i--)
            x += elements[i]+", ";

        return x + elements[0] + "]";
    }

    public int size()
    {
       return topIndex + 1;
    }

    public void popSome(int count)
    {
        if(count > topIndex + 1)
            throw new StackUnderflowException("Count exceeds number of elements");
        for(int i = 0; i < count; i++)
            pop();

    }

    public boolean swapStart()
    {
        if(topIndex + 1 < 1)
            return false;
        T temp = elements[topIndex];
        elements[topIndex] = elements[topIndex-1];
        elements[topIndex-1] = temp;
        return true;
    }

    public T poptop()
    {
        T result = top();
        pop();
        return result;
    }


}

************************************Test Code*****************************************
package ch02.stacks;


public class teststack {
    public static void main(String[] args) {
        ArrayBoundedStack<Integer> test = new ArrayBoundedStack<>(10);
        test.push(1);
        test.push(3);
        test.push(4);
        test.push(1452);
        test.push(10);
        test.push(122);
        test.push(17);


        System.out.println(test);
        System.out.println(test.size());

        test.popSome(3);
        System.out.println(test);

        System.out.println(test.swapStart());
        System.out.println(test);

        System.out.println(test.poptop());
        System.out.println(test);
    }

}
 
//---------------------------------------------------------------------------
// ArrayBoundedQueue.java        by Dale/Joyce/Weems                Chapter 4
//
// Implements QueueInterface with an array to hold the queue elements.
//
// Two constructors are provided: one that creates a queue of a default
// capacity and one that allows the calling program to specify the capacity.
//---------------------------------------------------------------------------
package ch04.queues;

public class ArrayBoundedQueue<T> implements QueueInterface<T>
{
  protected final int DEFCAP = 100; // default capacity
  protected T[] elements;           // array that holds queue elements
  protected int numElements = 0;    // number of elements in this queue
  protected int front = 0;          // index of front of queue
  protected int rear;               // index of rear of queue

  public ArrayBoundedQueue() 
  {
    elements = (T[]) new Object[DEFCAP];
    rear = DEFCAP - 1;
  }

  public ArrayBoundedQueue(int maxSize) 
  {
    elements = (T[]) new Object[maxSize];
    rear = maxSize - 1;
  }

  public void enqueue(T element)
  // Throws QueueOverflowException if this queue is full;
  // otherwise, adds element to the rear of this queue.
  {  
    if (isFull())
      throw new QueueOverflowException("Enqueue attempted on a full queue.");
    else
    {
      rear = (rear + 1) % elements.length;
      elements[rear] = element;
      numElements = numElements + 1;
    }
  }

  public T dequeue()
  // Throws QueueUnderflowException if this queue is empty;
  // otherwise, removes front element from this queue and returns it.
  {   
    if (isEmpty())
      throw new QueueUnderflowException("Dequeue attempted on empty queue.");
    else
    {
      T toReturn = elements[front];
      elements[front] = null;
      front = (front + 1) % elements.length;
      numElements = numElements - 1;
      return toReturn;
    }
  }

  public boolean isEmpty()
  // Returns true if this queue is empty; otherwise, returns false.
  {              
    return (numElements == 0);
  }

  public boolean isFull()
  // Returns true if this queue is full; otherwise, returns false.
  {              
    return (numElements == elements.length);
  }
  
  public int size()
  // Returns the number of elements in this queue.
  {
    return numElements;
  }

  public String toString()
  {
    String x = "[";
    for(int i =front; i < rear; i++)
      x += elements[i]+", ";

    return x + elements[rear] + "]";
  }

    public int space()
    {
        return elements.length - numElements;
    }

    public void remove(int count)
    {
      if(count > numElements)
          throw new QueueUnderflowException("Count exceeds number of elements");
      for(int i = 0; i < count; i++)
          dequeue();

    }

    public boolean swapEnds()
    {
        if(numElements < 1)
            return false;
        T temp = elements[front];
        elements[front] = elements[rear];
        elements[rear] = temp;
        return true;
    }


    public boolean swapStart()
    {
        if(numElements < 1)
            return false;
        T temp = elements[front];
        elements[front] = elements[front+1];
        elements[front+1] = temp;
        return true;
    }
}

************************************Test Code*****************************************
package ch04.queues;

public class testqueue {
    public static void main(String[] args)
    {
        ArrayBoundedQueue<Integer> test = new ArrayBoundedQueue<Integer>(10);
        test.enqueue(1);
        test.enqueue(3);
        test.enqueue(4);
        test.enqueue(1452);
        test.enqueue(10);
        test.enqueue(122);
        test.enqueue(17);

        System.out.println(test);
        System.out.println(test.space());

        test.remove(3);
        System.out.println(test);

        System.out.println(test.swapEnds());
        System.out.println(test);

        System.out.println(test.swapStart());
        System.out.println(test);
    }
}
 
 
//---------------------------------------------------------------------------
// BinarySearchTree.java          by Dale/Joyce/Weems               Chapter 7
//
// Defines all constructs for a reference-based BST.
// Supports three traversal orders Preorder, Postorder & Inorder ("natural")
//---------------------------------------------------------------------------

package BSTProject;

import java.util.*;   // Iterator, Comparator

import ch04.queues.*;
import ch02.stacks.*;
import support.BSTNode;      

public class BinarySearchTree<T> implements BSTInterface<T>
{
  protected BSTNode<T> root;      // reference to the root of this BST
  protected Comparator<T> comp;   // used for all comparisons

  protected boolean found;   // used by remove

  public BinarySearchTree() 
  // Precondition: T implements Comparable
  // Creates an empty BST object - uses the natural order of elements.
  {
    root = null;
    comp = new Comparator<T>()
    {
       public int compare(T element1, T element2)
       {
         return ((Comparable)element1).compareTo(element2);
       }
    };
  }

  public BinarySearchTree(Comparator<T> comp) 
  // Creates an empty BST object - uses Comparator comp for order
  // of elements.
  {
    root = null;
    this.comp = comp;
  }

  public boolean isFull()
  // Returns false; this link-based BST is never full.
  {
    return false;
  }

  public boolean isEmpty()
  // Returns true if this BST is empty; otherwise, returns false.
  {
    return (root == null);
  }

  public T min()
  // If this BST is empty, returns null;
  // otherwise returns the smallest element of the tree.
  {
    if (isEmpty())
       return null;
    else
    {
       BSTNode<T> node = root;
       while (node.getLeft() != null)
         node = node.getLeft();
       return node.getInfo();
    }
  }

  public T max()
  // If this BST is empty, returns null;
  // otherwise returns the largest element of the tree.
  {
    if (isEmpty())
       return null;
    else
    {
       BSTNode<T> node = root;
       while (node.getRight() != null)
         node = node.getRight();
       return node.getInfo();
    }
  }

  private int recSize(BSTNode<T> node)
  // Returns the number of elements in subtree rooted at node.
  {
    if (node == null)    
      return 0;
    else
      return 1 + recSize(node.getLeft()) + recSize(node.getRight());
  }

  public int size()
  // Returns the number of elements in this BST.
  {
    return recSize(root);
  }

  public int size2()
  // Returns the number of elements in this BST.
  {
    int count = 0;
    if (root != null)
    {
      LinkedStack<BSTNode<T>> nodeStack = new LinkedStack<BSTNode<T>>();
      BSTNode<T> currNode;
      nodeStack.push(root);
      while (!nodeStack.isEmpty())
      {
        currNode = nodeStack.top();
        nodeStack.pop();
        count++;
        if (currNode.getLeft() != null)
          nodeStack.push(currNode.getLeft());
        if (currNode.getRight() != null)
          nodeStack.push(currNode.getRight());
      }
    }
    return count;
  }

  private boolean recContains(T target, BSTNode<T> node)
  // Returns true if the subtree rooted at node contains info i such that 
  // comp.compare(target, i) == 0; otherwise, returns false.
 {
    if (node == null)
      return false;       // target is not found
    else if (comp.compare(target, node.getInfo()) < 0)
      return recContains(target, node.getLeft());   // Search left subtree
    else if (comp.compare(target, node.getInfo()) > 0)
      return recContains(target, node.getRight());  // Search right subtree
    else
      return true;        // target is found
  }

  public boolean contains (T target)
  // Returns true if this BST contains a node with info i such that 
  // comp.compare(target, i) == 0; otherwise, returns false.
  {
    return recContains(target, root);
  }

  
  private T recGet(T target, BSTNode<T> node)
  // Returns info i from the subtree rooted at node such that 
  // comp.compare(target, i) == 0; if no such info exists, returns null.
  {
    if (node == null)
      return null;             // target is not found
    else if (comp.compare(target, node.getInfo()) < 0)
      return recGet(target, node.getLeft());         // get from left subtree
    else
    if (comp.compare(target, node.getInfo()) > 0)
      return recGet(target, node.getRight());        // get from right subtree
    else
      return node.getInfo();  // target is found
  }

  public T get(T target)
  // Returns info i from node of this BST where comp.compare(target, i) == 0;
  // if no such node exists, returns null.
  {
    return recGet(target, root);
  }

  private BSTNode<T> recAdd(T element, BSTNode<T> node)
  // Adds element to tree rooted at node; tree retains its BST property.
  {
    if (node == null)
      // Addition place found
      node = new BSTNode<T>(element);
    else if (comp.compare(element, node.getInfo()) <= 0)
      node.setLeft(recAdd(element, node.getLeft()));    // Add in left subtree
    else
      node.setRight(recAdd(element, node.getRight()));   // Add in right subtree
    return node;
  }

  public boolean add (T element)
  // Adds element to this BST. The tree retains its BST property.
  {
    root = recAdd(element, root);
    return true;
  }

/*
  public boolean add (T element)
  // Adds element to this BST. The tree retains its BST property.
  {
    BSTNode<T> newNode = new BSTNode<T>(element);
    BSTNode<T> prev = null, curr = null;
    
    if (root == null)
      root = newNode;
    else
    {
      curr = root;
      while (curr != null)
      {
        if (comp.compare(element, curr.getInfo()) <= 0)
        {
          prev = curr;
          curr = curr.getLeft();
        }
        else
        {
          prev = curr;
          curr = curr.getRight();
        }
      }
      if (comp.compare(element, prev.getInfo()) <= 0)
        prev.setLeft(newNode);
      else
        prev.setLeft(newNode);
    }
    return true;
  }
*/

  private T getPredecessor(BSTNode<T> subtree)
  // Returns the information held in the rightmost node of subtree
  {
    BSTNode<T> temp = subtree;
    while (temp.getRight() != null)
      temp = temp.getRight();
    return temp.getInfo();
  }

  private BSTNode<T> removeNode(BSTNode<T> node)
  // Removes the information at node from the tree. 
  {
    T data;
    if (node.getLeft() == null)
      return node.getRight();
    else if (node.getRight() == null) 
      return node.getLeft();
    else
    {
      data = getPredecessor(node.getLeft());
      node.setInfo(data);
      node.setLeft(recRemove(data, node.getLeft()));  
      return node;
    }
  }

  private BSTNode<T> recRemove(T target, BSTNode<T> node)
  // Removes element with info i from tree rooted at node such that
  // comp.compare(target, i) == 0 and returns true; 
  // if no such node exists, returns false. 
  {
    if (node == null)
      found = false;
    else if (comp.compare(target, node.getInfo()) < 0)
      node.setLeft(recRemove(target, node.getLeft()));
    else if (comp.compare(target, node.getInfo()) > 0)
      node.setRight(recRemove(target, node.getRight()));
    else  
    {
      node = removeNode(node);
      found = true;
    }
    return node;
  }

  public boolean remove (T target)
  // Removes a node with info i from tree such that comp.compare(target,i) == 0
  // and returns true; if no such node exists, returns false.
  {
    root = recRemove(target, root);
    return found;
  }

  public Iterator<T> getIterator(BSTInterface.Traversal orderType)
  // Creates and returns an Iterator providing a traversal of a "snapshot" 
  // of the current tree in the order indicated by the argument.
  // Supports Preorder, Postorder, and Inorder traversal.
  {
    final LinkedQueue<T> infoQueue = new LinkedQueue<T>();
    if (orderType == BSTInterface.Traversal.Preorder)
      preOrder(root, infoQueue);
    else
    if (orderType == BSTInterface.Traversal.Inorder)
      inOrder(root, infoQueue);
    else
    if (orderType == BSTInterface.Traversal.Postorder)
      postOrder(root, infoQueue);

    return new Iterator<T>()
    {
      public boolean hasNext()
      // Returns true if the iteration has more elements; otherwise returns false.
      {
        return !infoQueue.isEmpty();
      }
      
      public T next()
      // Returns the next element in the iteration.
      // Throws NoSuchElementException - if the iteration has no more elements
      { 
        if (!hasNext())
          throw new IndexOutOfBoundsException("illegal invocation of next " + 
                                     " in BinarySearchTree iterator.\n");
        return infoQueue.dequeue();
      }

      public void remove()
      // Throws UnsupportedOperationException.
      // Not supported. Removal from snapshot iteration is meaningless.
      {
        throw new UnsupportedOperationException("Unsupported remove attempted on " 
                                              + "BinarySearchTree iterator.\n");
      }
    };
  }

  private void preOrder(BSTNode<T> node, LinkedQueue<T> q)
  // Enqueues the elements from the subtree rooted at node into q in preOrder.
  {
    if (node != null)
    {
      q.enqueue(node.getInfo());
      preOrder(node.getLeft(), q);
      preOrder(node.getRight(), q);
    }
  }

  private void inOrder(BSTNode<T> node, LinkedQueue<T> q)
  // Enqueues the elements from the subtree rooted at node into q in inOrder.  
  {
    if (node != null)
    {
      inOrder(node.getLeft(), q);
      q.enqueue(node.getInfo());
      inOrder(node.getRight(), q);
    }
  }

  private void postOrder(BSTNode<T> node, LinkedQueue<T> q)
  // Enqueues the elements from the subtree rooted at node into q in postOrder.  
  {
    if (node != null)
    {
      postOrder(node.getLeft(), q);
      postOrder(node.getRight(), q);
      q.enqueue(node.getInfo());
    }
  }
  
  public Iterator<T> iterator()
  // InOrder is the default, "natural" order.
  {
    return getIterator(BSTInterface.Traversal.Inorder);
  }

  //
  public int leafCount()
  {
      return leafCount(root);
  }

  private int leafCount(BSTNode current)
  {
      if(current == null)
          return 0;

      if(current.getLeft() == null && current.getRight() == null)
          return 1;

      return leafCount(current.getRight()) + leafCount(current.getLeft());
  }

    public int oneChild()
    {
        return getOneChildren(root);
    }

    private int getOneChildren(BSTNode current) {
        int count = 0;
        if(current != null) {
            if(current.getLeft() == null && current.getRight() != null)
                count++;
            else if(current.getLeft() != null & current.getRight() == null)
                count++;
            count += getOneChildren(current.getLeft());
            count += getOneChildren(current.getRight());
        }
        return count;
    }

    public int height(BSTNode current)
    {
        if (current == null)
            return 0;
        else
        {
            /* compute the Height of each subtree */
            int lHeight = height(current.getLeft());
            int rHeight = height(current.getRight());

            /* use the larger one */
            if (lHeight > rHeight)
                return (lHeight + 1);
            else
                return (rHeight + 1);
        }
    }

}

************************************Test Code*****************************************
package BSTProject;

public class testbst
{
    public static void main (String [] args)
    {
        BinarySearchTree<String> test = new BinarySearchTree<String>();
        test.add("c");
        test.add("c");
        test.add("b");

        System.out.println(test.leafCount());
        System.out.println(test.oneChild());
        System.out.println("Height of tree is : " +
                test.height(test.root));


        BinarySearchTree<Integer> test1 = new BinarySearchTree<Integer>();
        test1.add(10);
        test1.add(5);
        test1.add(20);

        System.out.println(test1.leafCount());
        System.out.println(test1.oneChild());
        System.out.println("Height of tree is : " +
                test1.height(test1.root));
    }
}

