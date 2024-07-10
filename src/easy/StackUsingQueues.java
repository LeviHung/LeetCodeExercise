package easy;

public class StackUsingQueues
{
  private class ArrayQueue 
  {
    private int front;			// Queue front pointer 
    private int rear;				// Queue rear pointer 
    private int number;			// The amount of items in the queue
    private int array[];	  // Holds queue elements
  
    /**
     * Constructor.
     * @param size The capacity of the queue.
     */
    public ArrayQueue(int size)
    {
      front = 0;
      rear = 0;
      number = 0;
      array = new int [size];
    }
  
    /**
     * The enqueue method enqueues a value onto the queue.
     * @param str The value to enqueue into the queue.
     * @throws Exception When the queue is full.
     */
    public void push_to_back(int value) throws Exception 
    {
      if (number >= array.length) {
        throw new Exception("Error! The queue is full.");			
      }
  
      array[rear] = value;
      number++;
      rear++;
  
      if (rear >= array.length) {
        rear = 0;
      }
    }
  
    /**
     * The dequeue method dequeues a value off the queue.
     * @return The value dequeued.
     * @throws Exception When the queue is empty.
     */
    public int pop_from_front() throws Exception
    {
      if (number == 0) {
        throw new Exception("Error! The queue is empty.");
      }
  
      int strResult = array[front];
      number--;
      front++;
  
      if (front >= array.length) {
        front = 0;
      }
  
      return strResult;
    }
  
    /**
     * The peek method returns the value at the front of the queue.
     * @return The value at the front of the queue.
     * @throws Exception When the queue is empty.
     */
    public int peek() throws Exception
    {
      if (number == 0) {
        throw new Exception("Error! The queue is empty.");
      }
  
      return array[front];
    }
  
    public int size()
    {
      return number;
    }
  
    public boolean is_empty()
    {
      return (number==0);
    }
  }
  
  private ArrayQueue queue;  
  public StackUsingQueues()
  {
    queue = new ArrayQueue(100);
  }

  public void push(int x) 
  {
    try {
      queue.push_to_back(x);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public int pop() 
  {
    try {
      for (int i = 0; i < queue.size() - 1; i++) {
        queue.push_to_back(queue.pop_from_front());
      }
      return queue.pop_from_front();
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    
    return 0;
  }

  public int top() 
  {
    try {
      for (int i = 0; i < queue.size() - 1; i++) {
        queue.push_to_back(queue.pop_from_front());
      }
      int value = queue.pop_from_front();
      queue.push_to_back(value);
      return value;

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    
    return 0;
  }

  public boolean empty() 
  {
    return (queue.size() == 0);
  }

  public static void readme()
  {
    String str = "Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).\n\n";

    str += "Implement the MyStack class:\n\n";

    str += "void push(int x) Pushes element x to the top of the stack.\n\n";

    str += "int pop() Removes the element on the top of the stack and returns it.\n\n";
    
    str += "int top() Returns the element on the top of the stack.\n\n";

    str += "boolean empty() Returns true if the stack is empty, false otherwise.\n\n";

    str += "Notes:\n\n";
    str += "You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.\n\n";

    str += "Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.\n";

    
    System.out.println(str);
  }

  public static void main()
  {

    StackUsingQueues.readme();

    // ["MyStack", "push", "push", "top", "pop", "empty"]
    // [[], [1], [2], [], [], []]
    int value;
    boolean isEmpty;
    StackUsingQueues myStack = new StackUsingQueues();
    myStack.push(1);
    System.out.println("myStack.push(1)");
    myStack.push(2);
    System.out.println("myStack.push(2)");
    value = myStack.top(); // return 2
    System.out.println("myStack.top() = " + value);
    value = myStack.pop(); // return 2
    System.out.println("myStack.pop() = " + value);
    isEmpty = myStack.empty(); // return False
    System.out.println("myStack.empty() = " + isEmpty);

  }
}