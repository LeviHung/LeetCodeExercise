package easy;

public class QueueUsingStacks
{
  private class ArrayStack
  {
    private int top;				// Stack top pointer 
    private int array[];	// Holds stack elements

    /**
     * Constructor.
     * @param size The capacity of the stack.
     */
    public ArrayStack(int size)
    {
      top = 0;
      array = new int [size];
    }

    /**
     * The push method pushes a value onto the stack.
     * @param str The value to push onto the stack.
     * @throws Exception When the stack is full.
     */
    public void push(int value) throws Exception 
    {
      if (top >= array.length) {
        throw new Exception("Error! The stack is full.");			
      }

      array[top] = value;
      top++;
    }

    /**
     * The pop method pops a value off the stack.
     * @return The value popped.
     * @throws Exception When the stack is empty.
     */
    public int pop() throws Exception
    {
      if (top == 0) {
        throw new Exception("Error! The Stack is empty.");
      }

      top--;

      return array[top];
    }

    /**
     * The peek method returns the value at the top of the stack.
     * @return The value at the top of the stack.
     * @throws Exception When the stack is empty.
     */
    public int peek() throws Exception
    {
      if (top == 0) {
        throw new Exception("Error! The Stack is empty.");
      }

      return array[top - 1];
    }

    /**
     * 
     * @return True if the stack is empty. Otherwise false. 
     */
    public boolean isEmpty()
    {
      return (top == 0);
    }
  }

  private ArrayStack stack;
  private ArrayStack stackAux;
  int number;
  int numberAux;

  public QueueUsingStacks()
  {
    stack = new ArrayStack(100);
    stackAux = new ArrayStack(100);
    number = 0;
    numberAux = 0;
  }

  public void push(int x) 
  {
    try {
      number++;
      stack.push(x);
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public int pop() 
  {
    if (stack.isEmpty() && stackAux.isEmpty()) {
      //throw new Exception("Error! The queue is empty.");
      return 0;
    }
    try {
      if (stackAux.isEmpty()) {
        while (!stack.isEmpty()) {
          stackAux.push(stack.pop());
        }
      }
      number--;
      return stackAux.pop();

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return 0;
  }

  public int peek() 
  {
    if (stack.isEmpty() && stackAux.isEmpty()) {
      //throw new Exception("Error! The queue is empty.");
      return 0;
    }

    try {
      if (stackAux.isEmpty()) {
        while (!stack.isEmpty()) {
          stackAux.push(stack.pop());
        }
      }
      return stackAux.peek();

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return 0;
  }

  public boolean empty() 
  {
    return (number == 0);
  }

  public static void readme()
  {
    String str = "Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).\n\n";

    str += "Implement the MyQueue class:\n\n";

    str += "void push(int x) Pushes element x to the back of the queue.\n\n";

    str += "int pop() Removes the element from the front of the queue and returns it.\n\n";

    str += "int peek() Returns the element at the front of the queue.\n\n";

    str += "boolean empty() Returns true if the queue is empty, false otherwise.\n\n";

    str += "Notes:\n\n";
    
    str += "You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.\n\n";

    str += "Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.\n";


    System.out.println(str);
  }

  public static void main()
  {

    QueueUsingStacks.readme();

    // ["MyStack", "push", "push", "top", "pop", "empty"]
    // [[], [1], [2], [], [], []]
    int value;
    boolean isEmpty;
    QueueUsingStacks myQueue = new QueueUsingStacks();
    myQueue.push(1);
    System.out.println("myQueue.push(1)");
    myQueue.push(2);
    System.out.println("myQueue.push(2)");
    value = myQueue.peek(); // return 2
    System.out.println("myQueue.peek() = " + value);
    value = myQueue.pop(); // return 2
    System.out.println("myQueue.pop() = " + value);
    isEmpty = myQueue.empty(); // return False
    System.out.println("myQueue.empty() = " + isEmpty);

  }
}