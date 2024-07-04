package easy;

public class ExcelSheetColumnTitle
{
  public static String convertToTitle(int columnNumber)
  {
    int add = 0;
    StringBuilder sb = new StringBuilder();
    
    while (columnNumber > 0) {
      //System.out.println("column = " + columnNumber);
      add = ((columnNumber) % 26);
      if (add == 0) {
        add = 26;
      }
      
      sb.append((char) ('@' + add));

      columnNumber = (columnNumber - 1) / 26; 
    }

    return sb.reverse().toString();
  }

  public static String convertToTitleEx(int columnNumber)
  {
    StringBuilder result = new StringBuilder();
    while (columnNumber > 0) {
      columnNumber--;
      char c = (char) ('A' + columnNumber % 26);
      result.insert(0, c);
      columnNumber /= 26;
    }
    return result.toString();
  }

  public static void readme()
  {
    String str = "Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.\n\n";

    System.out.println(str);
  }

  public static void main() 
  {
    ExcelSheetColumnTitle.readme();
    String str = "";

    // columnNumber = 1 => "A"
    int columnNumber = 1;
    System.out.println("convertToTitle(" + columnNumber + ") = " + 
                  ExcelSheetColumnTitle.convertToTitle(columnNumber));


    // columnNumber = 28 = "AB"
    columnNumber = 28;
    System.out.println("convertToTitle(" + columnNumber + ") = " + 
                  ExcelSheetColumnTitle.convertToTitle(columnNumber));

    //columnNumber = 701 = "ZY"
    columnNumber = 701;
    System.out.println("convertToTitle(" + columnNumber + ") = " + 
                  ExcelSheetColumnTitle.convertToTitle(columnNumber));
  }
}