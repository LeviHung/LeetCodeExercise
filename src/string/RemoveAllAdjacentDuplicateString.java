package string;

public class RemoveAllAdjacentDuplicateString
{
  public static String removeDuplicates(String s)
  {    
    char[] array = s.toCharArray();
    int index = 0;
    int len = array.length - 1;
    int next = 1;
    while (index < len && next < array.length) {
      if (array[index] == array[next]) {
        array[index] = ' ';
        array[next] = ' ';
        next++;
        while (index > 0 && array[index] == ' ') {
          index--;
        }

      } else {
        index++;
        if (index == next) {
          next++;
        }
      }
    }
    //System.out.println(Arrays.toString(array));
    StringBuilder sb = new StringBuilder();
    for (char ch: array) {
        if (ch != ' ') {
            sb.append(ch);
        }
    }
    return sb.toString();
  }

  public static String removeDuplicatesOpt(String s) 
  {
    char[] chars = s.toCharArray();
    char[] out = new char[chars.length];

    int end = 0;

    char prevChar = '^';

    for (int i = 0; i < chars.length; i++) {
        char curr = chars[i];
        if (curr == prevChar) {    
            end--;
            if (end == 0) {prevChar = '^';}
            else {prevChar = out[end - 1];}           

            continue;                
        } else {
            out[end] = curr;
            end++;                
            prevChar = curr;                
        }
    } 

    return new String(out, 0, end);
  }
  
  public static void readme()
  {
    String str = "You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.\n\n";

    str += "We repeatedly make duplicate removals on s until we no longer can.\n\n";
    
    str += "Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.\n";

    System.out.println(str);
  }

  public static void main()
  {
    RemoveAllAdjacentDuplicateString.readme();

    String s;
    // s = "abbaca" => "ca"
    s = "abbaca";
    System.out.println("removeDuplicates(" + s + ") = " + 
                       removeDuplicates(s));

    // s = "azxxzy" => "ay"
    s = "azxxzy";
    System.out.println("removeDuplicates(" + s + ") = " + 
                       removeDuplicates(s));

    System.out.println("removeDuplicatesOpt(" + s + ") = " + 
                       removeDuplicatesOpt(s));

    }
}