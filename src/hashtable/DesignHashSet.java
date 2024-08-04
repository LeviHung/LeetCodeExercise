package hashtable;

import java.util.List;
import java.util.ArrayList;

public class DesignHashSet
{
  private boolean [] array;
  public DesignHashSet() 
  {
    array = new boolean [1000001];
  }

  public void add(int key) 
  {
    array[key] = true;
  }

  public void remove(int key) 
  {
    array[key] = false;
  }
  public boolean contains(int key) 
  {
    return array[key];
  }

  // Use hash and mask to descrease the memory size;
  /*
  int size = 1000032;
  int[] hashSet;
  public MyHashSet() {
      hashSet = new int[size / 32];
  }

  public void add(int key) {
      hashSet[getIdx(key)] |= getMask(key);
  }

  public void remove(int key) {
      hashSet[getIdx(key)] &= (~getMask(key));
  }

  public boolean contains(int key) {
      return (hashSet[getIdx(key)]&getMask(key)) != 0;
  }

  private int getIdx(int key){
      return key / 32;
  }

  private int getMask(int key){
      key %= 32;
      return (1 << key);
  }
  
  */
  /*
  private List <Integer> list;
  public DesignHashSet() 
  {
    list = new ArrayList<>();

  }

  public void add(int key) 
  {
    if (list.contains(key) == false)
      list.add(key);
  }

  public void remove(int key) 
  {
    int index = list.indexOf(key);
    if (index >= 0) {
      list.remove(index);
    }
  }
  public boolean contains(int key) 
  {
    return list.contains(key);
  }
  */
  public static void readme()
  {
    String str = "Design a HashSet without using any built-in hash table libraries.\n\n";

    str += "Implement MyHashSet class:\n\n";

    str += "void add(key) Inserts the value key into the HashSet.\n\n";

    str += "bool contains(key) Returns whether the value key exists in the HashSet or not.\n\n";

    str += "void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.\n";

    System.out.println(str);
  }

  public static void main()
  {
    DesignHashSet.readme();

   /*
    MyHashSet myHashSet = new MyHashSet();
    myHashSet.add(1);      // set = [1]
    myHashSet.add(2);      // set = [1, 2]
    myHashSet.contains(1); // return True
    myHashSet.contains(3); // return False, (not found)
    myHashSet.add(2);      // set = [1, 2]
    myHashSet.contains(2); // return True
    myHashSet.remove(2);   // set = [1]
    myHashSet.contains(2); // return False, (already removed)
    */

    DesignHashSet myHashSet = new DesignHashSet();
    
    System.out.println("myHashSet.add(1)");
    myHashSet.add(1);      // set = [1]
    System.out.println("myHashSet.add(2)");
    myHashSet.add(2);      // set = [1, 2]
    System.out.println("myHashSet.contains(1) = " + myHashSet.contains(1));
    myHashSet.contains(1); // return True
    System.out.println("myHashSet.contains(3) = " + myHashSet.contains(3));
    myHashSet.contains(3); // return False, (not found)
    System.out.println("myHashSet.add(2)");
    myHashSet.add(2);      // set = [1, 2]
    System.out.println("myHashSet.contains(2) = " + myHashSet.contains(2));
    myHashSet.contains(2); // return True
    System.out.println("myHashSet.remove(2)");
    myHashSet.remove(2);   // set = [1]
    System.out.println("myHashSet.contains(2) = " + myHashSet.contains(2));
    myHashSet.contains(2); // return False, (already removed)

  }
}