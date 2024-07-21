package string;

public class DetectCapital
{
  public static boolean detectCapitalUse(String word)
  {    
    // Use charAt() method instead of array to 
    // get better for runtime when the string is short.
    // use < 97 instead of isUpperCase() to get better for runtime.
    // char[] arrayS = word.toCharArray();
    boolean isSecondCap = false;
    if (word.length() >= 2 && word.charAt(1) < 97) {
      if (word.charAt(0) >= 97) {
          return false;
      }
      isSecondCap = true;
    }
    
    for (int i = 2; i < word.length(); i++) {
      if (word.charAt(i) < 97) {
        if (isSecondCap == false) {
          return false;
        }
      } else {
        if (isSecondCap == true) {
          return false;
        }
      }
    }

    return true;
  }

  public static boolean detectCapitalUseOpt(String word) 
  {
      int cap=0;
      int small=0;
      for(int i=0; i<word.length(); i++){
         if(word.charAt(i)+0<97){
          cap++;
         }
         else{
          small++;
         }
      }
      if(cap==word.length() || small==word.length()){
          return true;
      }
      if(small==word.length()-1 && word.charAt(0)+0<97){
          return true;
      }
      return false;
  }
  
  public static void readme()
  {
    String str = "We define the usage of capitals in a word to be right when one of the following cases holds:\n\n";

    str += "All letters in this word are capitals, like \"USA\".\n\n";

    str += "All letters in this word are not capitals, like \"leetcode\".\n\n";

    str += "Only the first letter in this word is capital, like \"Google\".\n\n";

    str += "Given a string word, return true if the usage of capitals in it is right.\n";

    System.out.println(str);
  }

  public static void main()
  {
    DetectCapital.readme();

    String word;
    // word = "USA" => true
    word = "USA";
    System.out.println("detectCapitalUse(" + word + ") = " + 
                        detectCapitalUse(word));

    // word = "FlaG" => false
    word = "FlaG";
    System.out.println("detectCapitalUse(" + word + ") = " + 
                        detectCapitalUse(word));

    word = "Google";
    System.out.println("detectCapitalUse(" + word + ") = " + 
                        detectCapitalUse(word));

    word = "aE";
    System.out.println("detectCapitalUse(" + word + ") = " + 
                        detectCapitalUse(word));

    word = "leetcode";
    System.out.println("detectCapitalUse(" + word + ") = " + 
                        detectCapitalUse(word));

    System.out.println("detectCapitalUseOpt(" + word + ") = " + 
                        detectCapitalUseOpt(word));

  }
}