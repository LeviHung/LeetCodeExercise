package twopointers;

public class LongPressedName
{
  public static boolean isLongPressedName(String name, String typed)
  {
    char[] arrayN = name.toCharArray();
    char[] arrayT = typed.toCharArray();
    int indexN = 0;
    int indexT = 0;
    while (indexN < arrayN.length && indexT < arrayT.length) {
      if (arrayN[indexN] != arrayT[indexT]) {
        return false;
      } else {
        indexN++;
        if (indexN < arrayN.length && arrayN[indexN] == arrayN[indexN-1]) {
          indexT++;
        } else {
          indexT = nextDifferentLetter(arrayT, indexT);
        }
      }
    }
    
    if (indexN == arrayN.length && indexT == arrayT.length) {
      return true;
    } else {
      return false;
    }
  }

  public static int nextDifferentLetter(char[] array, int index) {
    char ch = array[index++];
    while (index < array.length && ch == array[index]) {
      index++;
    }
    return index;
  }

  
  public static void readme()
  {
    String str = "Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.\n\n";

    str += "You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.\n";

    System.out.println(str);
  }

  public static void main()
  {
    LongPressedName.readme();

    String name;
    String typed;

    // name = "alex", typed = "aaleex" => true
    name = "alex";
    typed = "aaleex";
    System.out.println("isLongPressedName(" + name + ", " + typed + ") = " +
                       isLongPressedName(name, typed));
    System.out.println("");

    // name = "saeed", typed = "ssaaedd" => false
    name = "saeed";
    typed = "ssaaedd";
    System.out.println("isLongPressedName(" + name + ", " + typed + ") = " +
                       isLongPressedName(name, typed));
    System.out.println("");
  }
}