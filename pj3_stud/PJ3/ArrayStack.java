/**
    A class of stacks whose entries are stored in an array.
    Implement all methods in ArrayStack class using resizable 
    array strategy, i.e. use doubleArray() 

    Main Reference : text book or class notes
    Must throw StackException during exception events in methods:
	peek(), pop(), ArrayStack(int initialCapacity)
    Do not change or add data fields 
    Do not add new methods

*/

package PJ3;
import java.util.Arrays;

public class ArrayStack<T> implements StackInterface<T>
{
  public T[] stack;    // Array of stack entries
  private int topIndex; // Index of top entry
  private static final int DEFAULT_CAPACITY = 50;
	
  /* Construct a stack with DEFAULT_CAPACITY */
  public ArrayStack()
  {
   	this(DEFAULT_CAPACITY);
   	topIndex=0;
  } // end default constructor
	
       
  /* Construct a stack with the given initialCapacity */
  /* Throw StackException if initialCapacity <= 0     */
  public ArrayStack(int initialCapacity)
  {
	  
      stack = (T[])new Object[initialCapacity];
      topIndex=0;
      
	  // add stataments
  } // end constructor

  public void push(T newEntry)
  {
	  if(size() == stack.length)
		  throw new StackException("stack is full");
	  else {
		  stack[topIndex]=newEntry;
		  topIndex++;
		  }
      	// add stataments
  } // end push

  /* Throw StackException if stack is empty */
  public T peek()
  {
	  if(empty())
		  throw new StackException("stack is empty");
      	// add stataments
	return stack[topIndex-1];
  } // end peek

  /* Throw StackException if stack is empty */
  public T pop()
  {
	  if(empty())
		  throw new StackException("stack is empty!");
      	// add stataments
	  topIndex--;
	  T result = stack[topIndex];
	  stack[topIndex]=null;
       	return result;
  } // end pop

  public boolean empty()
  {
      	// add stataments
	return topIndex==0;
  } // end empty
	

  public int size()
  {
 	// add stataments
        return topIndex;
  } // end size 

  public void clear()
  {
	  for(int i =0;i<stack.length && i<topIndex;i++)
	  {
		  stack[i]=null;
	  }
	  topIndex=0;
 	// add stataments
  } // end clear
   
  // toString() returns a list of data in Stack, separate them with ','
  public String toString()
  {
	  String myString = "";
	  for(int i=0;i<stack.length;i++)
	  {
		  myString+=stack[i]+",";
	  }
      	// add stataments
      	return myString;
  }

  // double the size of array using Arrays.copyOf()
  private void doubleArray()
  {
      	
      	T[] array=Arrays.copyOf(stack,2*stack.length);
      			
      			// add stataments
  } // end doubleArray


  /****************************************************
     Do not modify: Stack test
  ****************************************************/
  public static void main (String args[])
  {
        System.out.println("\nYour Test output:\n");
	StackInterface<Integer> s = new ArrayStack<Integer>(10);
	if (s.empty()) 
            System.out.println("OK: stack is empty");
	else
            System.out.println("Error: stack is not empty");

	if (s.size() == 0) 
            System.out.println("OK: stack size is 0");
	else
            System.out.println("Error: stack size is " + s.size());

	s.push(10);
	s.push(30);
	s.push(50);
        System.out.println("Push 3 data: 10, 30, 50");
        System.out.println("Print stack " + s);

	if (s.size() == 3) 
            System.out.println("OK: stack size is 3");
	else
            System.out.println("Error: stack size is " + s.size());

	if (s.peek() == 50) 
            System.out.println("OK: peek stack top is 50");
	else
            System.out.println("Error: peek stack top is " + s.size());

	if (!s.empty()) 
            System.out.println("OK: stack is not empty");
	else
            System.out.println("Error: stack is empty");

        System.out.println("Pop 2 data: 50, 30");
        s.pop();
        System.out.println("Print stack " + s);
	int data=s.pop();
        System.out.println("Print stack " + s);
	if (data == 30) 
            System.out.println("OK: stack pop data is 30");
	else
            System.out.println("Error: stack pop data is " + data);

        System.out.println("Clear stack");
        s.clear();
        System.out.println("Print stack " + s);

	if (s.empty()) 
            System.out.println("OK: stack is empty");
	else
            System.out.println("Error: stack is not empty");

	if (s.size() == 0) 
            System.out.println("OK: stack size is 0");
	else
            System.out.println("Error: stack size is " + s.size());

	s.push(7);
	s.push(37);
	s.push(58);
        System.out.println("Push 3 data: 7, 37, 58");
        System.out.println("Print stack " + s);

	if (s.size() == 3) 
            System.out.println("OK: stack size is 3");
	else
            System.out.println("Error: stack size is " + s.size());

	if (!s.empty()) 
            System.out.println("OK: stack is not empty");
	else
            System.out.println("Error: stack is empty");
        s.clear();

        System.out.println("========================");
        try {
            System.out.println("\nContruct a stack with negative capacity");
	    StackInterface<Integer> s2 = new ArrayStack<Integer>(-3);
        } 
        catch (StackException e) {
            System.out.println("StackException : " + e.getMessage());
        }

        try {
            System.out.println("\nPeek empty stack");
	    s.peek();
        } 
        catch (StackException e) {
            System.out.println("StackException : " + e.getMessage());
        }

        try {
            System.out.println("\nPop empty stack");
	    s.pop();
        } 
        catch (StackException e) {
            System.out.println("StackException : " + e.getMessage());
        }
  }

} // end ArrayStack
