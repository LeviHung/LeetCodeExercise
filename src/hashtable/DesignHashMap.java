package hashtable;

import java.util.List;
import java.util.ArrayList;

public class DesignHashMap
{
  // ===== Use ArrayList =====
  private static class BucketNodes extends ArrayList<BucketNode> {
  }

  private BucketNodes data[];

  /*
   * Constructor
   * @param size The size of the hash table
   */
  public DesignHashMap()
  {
    data = new BucketNodes[10000];
  }

  private int getHash(int key) 
  {
    int hash = 0;
    hash = key % this.data.length;
    return hash;
  }

  public void put(int key, int value)
  {
    int address = this.getHash(key);

    if (this.data[address] == null) {
      this.data[address] = new BucketNodes();
    }

    for (int i = 0; i < this.data[address].size(); i++) {
      if (key == this.data[address].get(i).getKey()) {
          this.data[address].remove(i);
          break;
      }
    }

    BucketNode bn = new	BucketNode(key, value); 

    this.data[address].add(bn);

  }

  public int get(int key)
  {
    int address = this.getHash(key);

    if (this.data[address] != null) {
      for (int i = 0; i < this.data[address].size(); i++) {
        if (key == this.data[address].get(i).getKey()) {
          return this.data[address].get(i).getValue();
        }
      }
    }
    return -1; 
  }

  public void remove(int key)
  {
    int address = this.getHash(key);

    if (this.data[address] != null) {
      for (int i = 0; i < this.data[address].size(); i++) {
        if (key == this.data[address].get(i).getKey()) {
            this.data[address].remove(i);
            break;
        }
      }
    }
  }
  
  public ArrayList<Integer> getKeys()
  {
    ArrayList<Integer> keyList = new ArrayList<>();

    for (int i = 0; i < this.data.length; i++) {
      if (this.data[i] != null) {
        for (int j = 0; j < this.data[i].size(); j++) {
          keyList.add(this.data[i].get(j).getKey());
        }				
      }
    }

    return keyList;
  }

  class BucketNode {
    private int key;
    private int value;

    public BucketNode(int key, int value)
    {
      this.key = key;
      this.value = value;
    }

    public int getKey()
    {
      return this.key;
    }

    public int getValue()
    {
      return this.value;
    }

    public void setKey(int key)
    {
      this.key = key;
    }

    public void setValue(int value)
    {
      this.value = value;
    }
  }
  // ====== Use array ======
  /*
  private int [] array;
  public DesignHashMap() 
  {
    array = new int [1000001];
  }

  public void put(int key, int value)
  {
    array[key] = value + 1;
  }

  public int get(int key)
  {
    return array[key] - 1;
  }
  
  public void remove(int key) 
  {
    array[key] = 0;
  }
  */

  // ===== Use linked list =====
  /*
  class MyHashMap {

  Node[] storage;
  static int bucketSize = 10000;

  class Node {
    int key; int value;
    Node next;

    public Node(int k,int v){
        this.key = k;
        this.value = v;
        this.next = null;
    }
  }

  public MyHashMap() {
    storage = new Node[bucketSize];
  }

  private int getBuckets(int key){
    return key%bucketSize;
  }

  private Node search(Node head,int key){
    Node prev = null;
    Node curr = head;
    while(curr != null && curr.key != key){
        prev = curr;
        curr = curr.next;
    }
    return prev;
  }

  public void put(int key, int value) {
    int bk = getBuckets(key);
    if(storage[bk]==null){
        storage[bk] = new Node(-1,-1);
    }
    Node prev = search(storage[bk],key);
    if(prev.next == null){
        prev.next = new Node(key,value);
    } else{
        prev.next.value = value;
    }
  }

  public int get(int key) {
    int bk = getBuckets(key);
    if(storage[bk]==null){
        return -1;
    }

    Node prev = search(storage[bk],key);
    if(prev.next == null)
        return -1;

    return prev.next.value;
  }

  public void remove(int key) {
    int bk = getBuckets(key);
    if(storage[bk]==null) return;

    Node prev = search(storage[bk],key);
    if(prev.next == null) return;

    Node delete = prev.next;
    prev.next = prev.next.next;
    delete.next = null;
  }
  }
  */
  
  public static void readme()
  {
    String str = "Design a HashMap without using any built-in hash table libraries.\n\n";

    str += "Implement the MyHashMap class:\n\n";

    str += "MyHashMap() initializes the object with an empty map.\n\n";

    str += "void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.\n\n";

    str += "int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.\n\n";

    str += "void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    DesignHashMap.readme();

   /*
    MyHashMap myHashMap = new MyHashMap();
    myHashMap.put(1, 1); // The map is now [[1,1]]
    myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
    myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
    myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
    myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
    myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
    myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
    myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
    */

    DesignHashMap myHashMap = new DesignHashMap();

    System.out.println("myHashMap.put(1, 1)");
    myHashMap.put(1, 1); // The map is now [[1,1]]
    System.out.println("myHashMap.put(2, 2)");
    myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
    System.out.println("myHashMap.get(1) = " + myHashMap.get(1));
    myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
    System.out.println("myHashMap.get(3) = " + myHashMap.get(3));
    myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
    System.out.println("myHashMap.put(2, 1)");
    myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
    System.out.println("myHashMap.get(2) = " + myHashMap.get(2));
    myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
    System.out.println("myHashMap.remove(2)");
    myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
    System.out.println("myHashMap.get(2) = " + myHashMap.get(2));
    myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
  }
}