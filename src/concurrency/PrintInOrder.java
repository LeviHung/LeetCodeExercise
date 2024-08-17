package concurrency;

public class PrintInOrder {
  private volatile int flag;
  public PrintInOrder() {
      flag = 0;
  }

  public synchronized void first(Runnable printFirst) throws InterruptedException {

      // printFirst.run() outputs "first". Do not change or remove this line.
      while (flag != 0) {
          wait();
      }
      printFirst.run();
      flag = 1;
      notifyAll();
  }

  public synchronized void second(Runnable printSecond) throws InterruptedException {

      // printSecond.run() outputs "second". Do not change or remove this line.
      while (flag != 1) {
          wait();
      }
      printSecond.run();
      flag++;
      notifyAll();
  }

  public synchronized void third(Runnable printThird) throws InterruptedException {        
      // printThird.run() outputs "third". Do not change or remove this line.
      while (flag != 2) {
          wait();
      }
      printThird.run();
      flag++;
  }

  public static void readme()
  {
    String str = "Suppose we have a class:\n\n";
    str += "public class Foo {\n";
    str += "  public void first() { print(\"first\"); }\n";
    str += "  public void second() { print(\"second\"); }\n";
    str += "  public void third() { print(\"third\"); }\n";
    str += "}\n";
    str += "The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().\n\n";
    str += "Note:\n\n";
    str += "We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seem to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.\n";
          
    System.out.println(str);
  }

  public static void main() 
    {
        PrintInOrder.readme();
    }

}

/*
class Foo {
  private volatile int flag;
  public Foo() {
      flag = 0;
  }

  public void first(Runnable printFirst) throws InterruptedException {

      // printFirst.run() outputs "first". Do not change or remove this line.
      printFirst.run();
      flag++;
  }

  public void second(Runnable printSecond) throws InterruptedException {

      // printSecond.run() outputs "second". Do not change or remove this line.
      while (flag < 1) {
          continue;
      }

      printSecond.run();
      flag++;
  }

  public void third(Runnable printThird) throws InterruptedException {

      // printThird.run() outputs "third". Do not change or remove this line.
      while (flag < 2) {
          continue;
      }
      printThird.run();
      flag++;
  }
}
*/


