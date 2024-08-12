package twopointers;

public class ReverseStringIII
{
  public static String reverseWords(String s) 
  {    
    char[] arrayS = s.toCharArray();
    int lastSpace = -1;
    int l = 0;
    int r = 0;
    char tmp = '\0';
    for (int i = 0; i < arrayS.length; i++) {
      if (arrayS[i] == ' ') {
        l = lastSpace + 1;
        r = i - 1;
  
        while (l < r) {
          tmp = arrayS[l];
          arrayS[l] = arrayS[r];
          arrayS[r] = tmp;
          l++;
          r--;
        }
        lastSpace = i;
      }
    }
    if (lastSpace != arrayS.length - 1) {
      l = lastSpace + 1;
      r = arrayS.length - 1;
      while (l < r) {
        tmp = arrayS[l];
        arrayS[l] = arrayS[r];
        arrayS[r] = tmp;
        l++;
        r--;
      }
    }

    return String.valueOf(arrayS);
  }

  public static String reverseWordsOpt(String s) 
  {
    char[] arr= s.toCharArray();
    int left=0; int right=0;
    //start two pointers from same postion
    //move the right pointeer until you find space
    while(right<arr.length){
        //stop where rigth pointer meets space
        if (arr[right]==' '){
            //do reverse
            reverse(arr,left,right-1);
            //move left pointer to after the space and make it point word
            left=right+1; //points to word after space

        }
        right++;
    }
    //for the last word as there will be no space it will only print before last word so we manually reverse
    reverse(arr,left,right-1);
    return new String(arr);
  }
    
  public static void reverse(char arr[],int i, int j){
    while(i<j){
      char temp= arr[i];
      arr[i]=arr[j];
      arr[j]=temp;
      i++;
      j--;
    }
  }
  
  public static void readme()
  {
    String str = "Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    ReverseStringIII.readme();
    String s;
    // s = "Let's take LeetCode contest" => "s'teL ekat edoCteeL tsetnoc"
    s = "Let's take LeetCode contest";
    System.out.println("reverseWords(" + s + ") = " + 
                        reverseWords(s));

    // s = "Mr Ding" => "rM gniD"
    s = "Mr Ding";
    System.out.println("reverseWords(" + s + ") = " + 
                        reverseWords(s));

    System.out.println("reverseWordsOpt(" + s + ") = " + 
                        reverseWordsOpt(s));
  }
}